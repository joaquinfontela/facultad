import * as data from './data/data.json'

const express = require("express");
const app = express();

app.use(function (req: any, res: any, next: any) {
    res.header("Access-Control-Allow-Origin", "*");
    res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
    next();
});

var router = express.Router();

import { Bot } from '../server/bot';

// Crear una clase que implemente a las 
// credenciales y pasarlas por parámetro.

// const bot: Bot = new Bot();

router.get('/', (req: any, res: any) => {
    // console.log(req);
    res.send("Hello World!");
});

router.get('/data/', (req: any, res: any) => {
    // console.log(req);
    res.send("Hello Data!");
});

router.get('/data/103924', (req: any, res: any) => {
    // console.log(req);
    res.send(data);
});

router.post('/', (req: any, res: any) => {
    // console.log(req);
    res.send("Hello Post!");
});

router.delete('/', (req: any, res: any) => {
    // console.log(req);
    res.send("Hello Delete!");
});

app.use(router);

app.listen(2000, function () {
    console.log("Node server running on http://localhost:2000");
});