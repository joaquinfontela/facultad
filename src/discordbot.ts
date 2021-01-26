require("dotenv").config();

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

client.on('message', async (message: any) => {
    if (message.author.bot) return;
    if (message.content.startsWith(COMMAND_PREFIX)) {
        const [CMD_NAME, ...args] = message.content
            .trim()
            .substring(COMMAND_PREFIX.length)
            .split(/\s+/);
        if (CMD_NAME === 'announce') {
            console.log(args);
            const msg = args.join(' ');
            console.log(msg);
            webhookClient.send(msg);
        }
    }
});

client.login(process.env.DISCORDJS_BOT_TOKEN);