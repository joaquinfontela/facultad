require("dotenv").config();

import { Bot } from "./bot";
import { GraphFiller } from "./graphfiller";
import { SubjectGraph } from "./graph";
import { Channel } from "discord.js";

var bot: Bot = new Bot();
const filler: GraphFiller = new GraphFiller("./csv/");

const COMMAND_HEADER = "\n```+------ COMANDOS FIUBENSES DISPONIBLES ------+\n\n";
const COMMAND_FOOTER = "```";
const UNAVAILABLE_COMMAND = "Error, el comando ingresado no existe. La próxima te mandamos a recursar álgebra."

const { Client, WebhookClient } = require('discord.js');

var materiasCompletas: string[] = [];

const client = new Client({
    partials: ['MESSAGE', 'REACTION']
});

const webhookClient = new WebhookClient(
    process.env.WEBHOOK_ID,
    process.env.WEBHOOK_TOKEN,
);

const COMMAND_PREFIX = ">";

client.on('ready', () => {
    console.log(`${client.user.tag} has logged in.`);
});

function destroyClient(): void {
    client.destroy();
    process.exit();
}

var careersMsgID: string = "";

// Separar el if en varias funciones y parametrizar todo
// con lambdas para achicar la función.
client.on('message', async (message: any) => {
    if (message.author.bot) return;
    if (message.content.startsWith(COMMAND_PREFIX)) {
        const [CMD_NAME, ...args] = message.content
            .trim()
            .substring(COMMAND_PREFIX.length)
            .split(/\s+/);
        if (CMD_NAME === 'announce') {
            console.log(args);
            var msg: string = args.join(' ');
            console.log(msg);
            webhookClient.send(msg);
        } else if (CMD_NAME === 'help') {
            message.reply(COMMAND_HEADER + bot.getHelp() + COMMAND_FOOTER);
        } else if (CMD_NAME == 'tomatela') {
            destroyClient();
        } else if (CMD_NAME == 'disponibles') {
            var graphs: SubjectGraph[] = filler.parseAllText();
            var answer: string[] = graphs[11].subjectsICanDo(materiasCompletas);
            var reply: string = "Podés cursar: \n";
            answer.forEach((code: string) => {
                reply += code + " " + graphs[11].getSubjectByCode(code).getName() + "\n";
            });
            message.reply(reply);
        } else if (CMD_NAME == 'aprobe') {
            materiasCompletas = materiasCompletas.concat(Array.from(args));
        } else if (CMD_NAME == 'recurse') {
            materiasCompletas = materiasCompletas.filter((c: string) => !args.includes(c));
        } else if (CMD_NAME == 'siu') {
            message.reply(" Usted robó las materias: \n" + materiasCompletas.join("\n"));
        } else if (CMD_NAME == 'restantes') {
            var graphs: SubjectGraph[] = filler.parseAllText();
            message.reply("\n" + graphs[11].subjectCodesNeededFor(args[0]).join("\n"));
        } else if (CMD_NAME == 'creds') {
            var graphs: SubjectGraph[] = filler.parseAllText();
            message.reply("\n" + graphs[11].getTotalCredits(materiasCompletas));
        } else if (CMD_NAME == 'carreras') {
            var channelId: string = message.channel.id;
            client.channels.cache.get(channelId).send(bot.getRolesMsg()).then(
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
        member.roles.add(bot.getRoleID(name))
    }
});

client.on('messageReactionRemove', (reaction: any, user: any) => {
    const { name } = reaction.emoji;
    const member = reaction.message.guild.members.cache.get(user.id);
    if (!member.guild.me.hasPermission('MANAGE_ROLES')) {
        return console.log("No tengo el rol para darte roles, 🐱");
    } else if (reaction.message.id === careersMsgID) {
        member.roles.remove(bot.getRoleID(name))
    }
});

client.login(process.env.DISCORDJS_BOT_TOKEN);