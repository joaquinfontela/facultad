require("dotenv").config();

import { Bot } from "./bot";
import { GraphFiller } from "./graphfiller";
import { SubjectGraph } from "./graph";

var bot: Bot = new Bot();
const filler: GraphFiller = new GraphFiller("./csv/");

const COMMAND_HEADER = "\n```+------ COMANDOS FIUBENSES DISPONIBLES ------+\n\n";
const COMMAND_FOOTER = "```";
const UNAVAILABLE_COMMAND = "Error, el comando ingresado no existe. La próxima te mandamos a recursar álgebra."

const { Client, WebhookClient } = require('discord.js');

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
            var answer: string[] = graphs[11].subjectsICanDo(args);
            var reply: string = "Podés cursar: \n";
            answer.forEach((code: string) => {
                reply += code + " " + graphs[11].getSubjectByCode(code).getName() + "\n";
            });
            message.reply(reply);
        } else if (CMD_NAME == 'restantes') {
            var graphs: SubjectGraph[] = filler.parseAllText();
            message.reply("\n" + graphs[11].subjectCodesNeededFor(args[0]).join("\n"));
        } else {
            message.reply(UNAVAILABLE_COMMAND);
        }
    }
});

client.login(process.env.DISCORDJS_BOT_TOKEN);