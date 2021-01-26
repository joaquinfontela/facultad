import { stringify } from 'querystring';
import { Subject } from './graph'
import { SubjectGraph } from './graph'

const fs = require('fs');
const readline = require('readline');
const BLUE = "\x1b[36m";
const RESET = "\x1b[0m";

export class GraphFiller {

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
    public parseText(filename: string, callback: any): void {
        try {
            var rl = readline.createInterface({
                input: fs.createReadStream(this.pathname + filename),
                output: process.stdout,
                terminal: false
            });

            rl.on('line', (line: string) => {
                this.parseLine(line, callback);
            });
        } catch (err: any) {
            console.log(err);
        }
    }

    /**
     * 
     * @param line string value to be parsed. 
     */
    private parseLine(line: string, callback: any) {
        callback(line);
    }

    /**
     * Parses all text files found on this.pathname. Must all 
     * be valid text files.
     */
    public parseAllText(callback: any): void {
        fs.readdirSync(this.pathname).forEach((file: string) => {
            console.log(BLUE + "reading: ", this.pathname + file + RESET);
            this.parseText(file, callback);
        });
    }

}

var graph: SubjectGraph = new SubjectGraph();
var filler: GraphFiller = new GraphFiller("../csv/");
var callback = (s: string) => { console.log(s); }
filler.parseAllText(callback);