import { Subject } from './graph'

const fs = require('fs');
const readline = require('readline');

export class TxtReader {

    private pathname: string;

    public constructor(pathname: string) {
        this.pathname = pathname;
    }

    public parseText(filename: string): void {
        try {
            var rl = readline.createInterface({
                input: fs.createReadStream(this.pathname + filename),
                output: process.stdout,
                terminal: false
            });

            rl.on('line', (line: string) => {
                console.log(line);
            });
        } catch (err: any) {
            console.log(err);
        }
    }
}

var reader: TxtReader = new TxtReader("../txts/");
reader.parseText('Ingenieria Civil 2009.txt');