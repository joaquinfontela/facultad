require("dotenv").config();

import { Bot } from "./bot";
import { GraphFiller } from "./graphfiller";
import { SubjectGraph } from "./graph";
import { Users } from "./user";

const COMMAND_PREFIX = ">";
const COMMAND_HEADER = "\n```+------ COMANDOS FIUBENSES DISPONIBLES ------+\n\n";
const COMMAND_FOOTER = "```";
const UNAVAILABLE_COMMAND = "Error, el comando ingresado no existe. La próxima te mandamos a recursar álgebra."
const { Client } = require('discord.js');
const client = new Client({ partials: ['MESSAGE', 'REACTION'] });

var bot: Bot = new Bot();
const filler: GraphFiller = new GraphFiller("./csv/");
var users: Users = new Users();
var careersMsgID: string = "";

client.on('ready', () => {
    console.log(`${client.user.tag} has logged in.`);
});

function destroyClient(): void {
    client.destroy();
    process.exit();
}

// Not going for the api rest.
function getCareerCodes(message: any): number[] {
    var ids: number[] = []
    var careerIds: { [code: string]: number } = bot.getCareerIds();
    Object.keys(careerIds).forEach((key: string) => {
        if (message.member.roles.cache.has(key)) {
            ids.push(careerIds[key] - 1);
            // El -1 es porque se mapean las carreras 
            // contando desde el cero y no desde el uno
        }
    });
    return ids;
}

function replyWithHelp(): string {
    return (COMMAND_HEADER + bot.getHelp() + COMMAND_FOOTER);
}

function availableSubjects(userid: string, careerCodes: number[]): string {
    var graphs: SubjectGraph[] = filler.parseAllText();
    var reply: string = "\n";
    careerCodes.forEach((id: number) => {
        var answer: string[] = graphs[id].subjectsICanDo(users.getSubjects(userid));
        reply += "Para la carrera de " + bot.getCareerNameFromId(id) + " se puede cursar: \n"
        if (answer.length === 0) {
            reply += "nada, anda a estudiar vago\n";
        } else {
            answer.forEach((code: string) => {
                reply += code + " " + graphs[id].getSubjectByCode(code).getName() + "\n";
            });
        }
        reply += "\n";
    });
    return reply;
}

function remainingSubjects(userid: string, careerCodes: number[], args: string[]): string {
    if (Array.from(args).length === 0) {
        return ("Me tenes que pasar algún código para analizar master.");
    }
    var graphs: SubjectGraph[] = filler.parseAllText();
    var ans: string = "";
    careerCodes.forEach((id: number) => {
        ans += "\n En la carrera de " + bot.getCareerNameFromId(id) + " ";
        if (graphs[id].searchSubjectByCode(args[0]) === undefined) {
            ans += "no existe la materia de código: " + args[0];
        } else if (users.getSubjects(userid).includes(args[0])) {
            ans += "ya aprobó la materia."
        } else {
            var aCursar: string[] = graphs[id].subjectCodesNeededFor(args[0]).filter(
                (s: string) => !users.getSubjects(userid).includes(s));
            if (aCursar.length === 0) {
                ans += "ya puede cursar la materia ingresada.";
            } else {
                ans += "necesita cursar: " + aCursar.join(', ');
            }
        }
    });
    return ans;
}

function sendCreds(userid: string): string {
    var graphs: SubjectGraph[] = filler.parseAllText();
    return ("\n" + graphs[11].getTotalCredits(users.getSubjects(userid)));
}

function addSubjects(userid: string, args: string[]): void {
    users.addSubjects(userid, Array.from(args));
}

function removeSubjects(userid: string, args: string[]): void {
    users.removeSubjects(userid, args);
}

function showSubjects(userid: string): string {
    var subj: string[] = users.getSubjects(userid);
    if (subj.length === 0) {
        return " Aparentemente no aprobaste nada, fijate en fiubaconsultas";
    }
    return (" Usted robó las materias: \n" + subj.join(', '));
}

// Separar el if en varias funciones y parametrizar todo
// con lambdas para achicar la función.
client.on('message', async (message: any) => {
    if (message.author.bot) return;
    var userid: string = message.author.id;
    users.addUser(message.author.id);
    if (message.content.startsWith(COMMAND_PREFIX)) {
        var [CMD_NAME, ...args] = message.content
            .trim()
            .substring(COMMAND_PREFIX.length)
            .split(/\s+/);
        CMD_NAME = CMD_NAME.toLowerCase();
        if (CMD_NAME === 'ayuda') {
            message.reply(replyWithHelp());
        } else if (CMD_NAME == 'tomatela') {
            destroyClient();
        } else if (CMD_NAME == 'disponibles') {
            message.reply(availableSubjects(userid, getCareerCodes(message)));
        } else if (CMD_NAME == 'aprobe') {
            addSubjects(userid, args);
        } else if (CMD_NAME == 'recurse') {
            removeSubjects(userid, args);
        } else if (CMD_NAME == 'siu') {
            message.reply(showSubjects(userid));
        } else if (CMD_NAME == 'restantes') {
            message.reply(remainingSubjects(userid, getCareerCodes(message), args));
        } else if (CMD_NAME == 'creds') {
            message.reply(sendCreds(userid));
        } else if (CMD_NAME == 'carreras') {
            client.channels.cache.get(message.channel.id).send(bot.getRolesMsg()).then(
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