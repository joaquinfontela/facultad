require("dotenv").config();

import { Bot } from "./bot";

var bot: Bot = new Bot();

const COMMAND_HEADER = "\n```+------AVAILABLE COMMANDS------+\n\n";
const COMMAND_FOOTER = "```";

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
        } else if (CMD_NAME == 'disconnect') {
            destroyClient();
        }
    }
});

client.login(process.env.DISCORDJS_BOT_TOKEN);