import { stringify } from 'querystring';
import { Subject } from './graph'

const fs = require('fs');
const readline = require('readline');

export class TxtReader {

    private pathname: string;

    /**
     * 
     * @param pathname Path to text files to be parsed.
     */
    public constructor(pathname: string) {
        this.pathname = pathname;
    }

    /**
     * 
     * @param filename name of the text file to be parsed.
     */
    public parseText(filename: string): void {
        try {
            var rl = readline.createInterface({
                input: fs.createReadStream(this.pathname + filename),
                output: process.stdout,
                terminal: false
            });

            rl.on('line', (line: string) => {
                this.parseLine(line);
            });
        } catch (err: any) {
            console.log(err);
        }
    }

    /**
     * 
     * @param line string value to be parsed. 
     */
    private parseLine(line: string) {
        console.log(line);
    }

    /**
     * Parses all text files found on this.pathname. Must all 
     * be valid text files.
     */
    public parseAllText(): void {
        fs.readdirSync(this.pathname).forEach((file: string) => {
            console.log("reading: ", this.pathname + file);
            this.parseText(file);
        });
    }

}

var reader: TxtReader = new TxtReader("../txts/");
reader.parseAllText();