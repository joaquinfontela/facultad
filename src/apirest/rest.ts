const express = require("express");
const app = express();

var router = express.Router();

import { Bot } from '../server/bot';

// Crear una clase que implemente a las 
// credenciales y pasarlas por parámetro.

// const bot: Bot = new Bot();

router.get('/', (req: any, res: any) => {
    console.log(req);
    res.send("Hello World!");
});

router.get('/data/', (req: any, res: any) => {
    console.log(req);
    res.send("Hello Data!");
});

router.post('/', (req: any, res: any) => {
    console.log(req);
    res.send("Hello Post!");
});

router.delete('/', (req: any, res: any) => {
    console.log(req);
    res.send("Hello Delete!");
});

app.use(router);

app.listen(3000, function () {
    console.log("Node server running on http://localhost:3000");
});