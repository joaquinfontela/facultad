require("dotenv").config();

import { Bot } from "../server/bot";
import { DiscordCredentials } from "./discordcredentials";

const COMMAND_PREFIX = "!";
const UNAVAILABLE_COMMAND = "Error, el comando ingresado no existe. La próxima te mandamos a recursar álgebra."
const { Client } = require('discord.js');
const client = new Client({ partials: ['MESSAGE', 'REACTION'] });
const credentials: DiscordCredentials = new DiscordCredentials();
const bot = new Bot(credentials);
const RED: string = "```diff\n";
const ORANGE: string = "```css\n";
const YELLOW: string = "```fix\n";
const BLUE: string = "```init\n";
const GREEN: string = "```json\n";
const END_COLOR: string = "\n```";
var careersMsgID: string = "";

client.on('ready', () => {
    console.log(`${client.user.tag} has logged in.`);
});

function destroyClient(): void {
    client.destroy();
    process.exit();
}

// Not going for the api rest.

/**
 * Devuelve una lista de números, del 0 al 11, que representan las doce
 * carreras, en orden alfabético.
 */
function getCareerCodes(message: any): number[] {
    var ids: number[] = [];
    var careerIds: { [code: string]: number } = credentials.getCareerIds();
    Object.keys(careerIds).forEach((key: string) => {
        if (message.member.roles.cache.has(key)) {
            ids.push(careerIds[key] - 1);
            // El -1 es porque se mapean las carreras 
            // contando desde el cero y no desde el uno
        }
    });
    return ids;
}

// Separar el if en varias funciones y parametrizar todo
// con lambdas para achicar la función.
client.on('message', async (message: any) => {
    if (message.author.bot) return;
    var userid: string = message.author.id;
    bot.addUser(userid);
    bot.updateUserCareer(userid, getCareerCodes(message));
    console.log(bot.getCareersFromUserid(userid).toString());
    if (message.content.startsWith(COMMAND_PREFIX)) {
        var [CMD_NAME, ...args] = message.content
            .trim()
            .substring(COMMAND_PREFIX.length)
            .split(/\s+/);
        CMD_NAME = CMD_NAME.toLowerCase();
        if (CMD_NAME === 'ayuda') {
            message.reply(YELLOW + bot.replyWithHelp() + END_COLOR);
        } else if (CMD_NAME == 'tomatela') {
            destroyClient();
        } else if (CMD_NAME == 'registrar') {
            if (args.length > 0) {
                bot.users.registerUniversityId(args[0], message.author.id); // Guardo el padrón
            }
        } else if (CMD_NAME == 'disponibles') {
            message.reply(ORANGE + bot.availableSubjects(userid, getCareerCodes(message)) + END_COLOR);
        } else if (CMD_NAME == 'aprobe') {
            bot.addSubjects(userid, args);
        } else if (CMD_NAME == 'recurse') {
            bot.removeSubjects(userid, args);
        } else if (CMD_NAME == 'siu') {
            message.reply(GREEN + bot.showSubjects(userid) + END_COLOR);
        } else if (CMD_NAME == 'restantes') {
            console.log(args.toString());
            if (args.length < 1) {
                message.reply(BLUE + "Dame materias masterchef" + END_COLOR);
            } else {
                message.reply(BLUE + bot.remainingSubjects(userid, getCareerCodes(message), args[0]) + END_COLOR);
            }
        } else if (CMD_NAME == 'creds') {
            message.reply(bot.sendCreds(userid, getCareerCodes(message)));
        } else if (CMD_NAME == 'carreras') {
            client.channels.cache.get(message.channel.id).send(credentials.getRolesMsg()).then(
                (msg: any) => { careersMsgID = msg.id; });
        } else {
            message.reply(RED + UNAVAILABLE_COMMAND + END_COLOR);
        }
    }
});

client.on('messageReactionAdd', (reaction: any, user: any) => {
    const { name } = reaction.emoji;
    const member = reaction.message.guild.members.cache.get(user.id);
    if (!member.guild.me.hasPermission('MANAGE_ROLES')) {
        return console.log("No tengo el rol para darte roles, 🐱");
    } else if (reaction.message.id === careersMsgID) {
        member.roles.add(credentials.getRoleID(name))
    }
});

client.on('messageReactionRemove', (reaction: any, user: any) => {
    const { name } = reaction.emoji;
    const member = reaction.message.guild.members.cache.get(user.id);
    if (!member.guild.me.hasPermission('MANAGE_ROLES')) {
        return console.log("No tengo el rol para darte roles, 🐱");
    } else if (reaction.message.id === careersMsgID) {
        member.roles.remove(credentials.getRoleID(name))
    }
});

client.login(process.env.DISCORDJS_BOT_TOKEN);

import * as data from './data/data.json'

const express = require("express");
const app = express();

app.use(function (req: any, res: any, next: any) {
    res.header("Access-Control-Allow-Origin", "*");
    res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
    next();
});

var router = express.Router();

import { Credentials } from '../server/credentials';

// Crear una clase que implemente a las 
// credenciales y pasarlas por parámetro.

const credentialsManager: Credentials = new DiscordCredentials();

router.get('/', (req: any, res: any) => {
    res.send("Hello World!");
});

router.get('/data/', (req: any, res: any) => {
    res.send("Hello Data!");
});

router.get('/data/:userid', (req: any, res: any) => {
    var univId: string = req.params["userid"];
    var userDataFile: string = bot.getUserDataFile(bot.users.getDiscordId(univId));
    res.json(userDataFile);
});

router.post('/data/:userid/:studentData', (req: any, res: any) => {
    let univId: string = req.params["userid"];
    let studentData: any = JSON.parse(req.params["studentData"]);
    const passed: string[] = studentData.passed;
    const failed: string[] = studentData.failed;
    let discordId: string = bot.users.getDiscordId(univId);
    bot.addSubjects(discordId, passed);
    bot.removeSubjects(discordId, failed);
});

router.delete('/', (req: any, res: any) => {
    res.send("Hello Delete!");
});

app.use(router);

app.listen(2000, function () {
    console.log("Node server running on http://localhost:2000");
});
