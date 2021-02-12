const express = require("express");
const app = express();

var router = express.Router();

router.get('/', function (req: any, res: any) {
    res.send("Hello World!");
});

router.get('/testing/', function (req: any, res: any) {
    res.send("Hello Testing!");
});

router.post('/', function (req: any, res: any) {
    res.send("Hello Post!");
});

app.use(router);

app.listen(3000, function () {
    console.log("Node server running on http://localhost:3000");
});