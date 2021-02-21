// import * as data from './data/data.json'

// const express = require("express");
// const app = express();

// app.use(function (req: any, res: any, next: any) {
//     res.header("Access-Control-Allow-Origin", "*");
//     res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
//     next();
// });

// var router = express.Router();

// import { Bot } from '../server/bot';
// import { Credentials } from '../server/credentials';
// import { DiscordCredentials } from '../discord/discordcredentials';

// // Crear una clase que implemente a las 
// // credenciales y pasarlas por parámetro.

// const credentialsManager: Credentials = new DiscordCredentials();
// const bot: Bot = new Bot(credentialsManager);

// router.get('/', (req: any, res: any) => {
//     res.send("Hello World!");
// });

// router.get('/data/', (req: any, res: any) => {
//     res.send("Hello Data!");
// });

// router.get('/data/103924', (req: any, res: any) => {
//     res.send(data);
// });

// router.get('/data/:userid', (req: any, res: any) => {
//     var userId: string = req.params["userid"];
//     var userDataFile: string = bot.getUserDataFile(userId);
//     console.log(userDataFile);
//     res.json(userDataFile);
// });

// router.post('/', (req: any, res: any) => {
//     res.send("Hello Post!");
// });

// router.delete('/', (req: any, res: any) => {
//     res.send("Hello Delete!");
// });

// app.use(router);

// app.listen(2000, function () {
//     console.log("Node server running on http://localhost:2000");
// });
