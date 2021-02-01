require("dotenv").config();

import { Bot } from "./bot";
import { DiscordCredentials } from "./discordcredentials";

const COMMAND_PREFIX = ">";
const UNAVAILABLE_COMMAND = "Error, el comando ingresado no existe. La próxima te mandamos a recursar álgebra."
const { Client } = require('discord.js');
const client = new Client({ partials: ['MESSAGE', 'REACTION'] });
const credentials: DiscordCredentials = new DiscordCredentials();
const bot = new Bot(credentials);
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
    var ids: number[] = []
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
    bot.addUser(message.author.id);
    if (message.content.startsWith(COMMAND_PREFIX)) {
        var [CMD_NAME, ...args] = message.content
            .trim()
            .substring(COMMAND_PREFIX.length)
            .split(/\s+/);
        CMD_NAME = CMD_NAME.toLowerCase();
        if (CMD_NAME === 'ayuda') {
            message.reply(bot.replyWithHelp());
        } else if (CMD_NAME == 'tomatela') {
            destroyClient();
        } else if (CMD_NAME == 'disponibles') {
            message.reply(bot.availableSubjects(userid, getCareerCodes(message)));
        } else if (CMD_NAME == 'aprobe') {
            bot.addSubjects(userid, args);
        } else if (CMD_NAME == 'recurse') {
            bot.removeSubjects(userid, args);
        } else if (CMD_NAME == 'siu') {
            message.reply(bot.showSubjects(userid));
        } else if (CMD_NAME == 'restantes') {
            message.reply(bot.remainingSubjects(userid, getCareerCodes(message), args));
        } else if (CMD_NAME == 'creds') {
            message.reply(bot.sendCreds(userid, getCareerCodes(message)));
        } else if (CMD_NAME == 'carreras') {
            client.channels.cache.get(message.channel.id).send(credentials.getRolesMsg()).then(
                (msg: any) => { careersMsgID = msg.id; });
        } else {
            message.reply(UNAVAILABLE_COMMAND);
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