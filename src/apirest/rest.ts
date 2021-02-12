const express = require("express");
const app = express();

var router = express.Router();

router.get('/', function (req: any, res: any) {
    res.send("Hello World!");
});

router.post('/', function (req: any, res: any) {
    res.send("Hello Post!");
});

router.delete('/', function (req: any, res: any) {
    res.send("Hello Delete!");
});

app.use(router);

app.listen(3000, function () {
    console.log("Node server running on http://localhost:3000");
});