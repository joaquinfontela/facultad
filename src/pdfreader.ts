import { Subject } from './graph'

const fs = require('fs');
const pdf = require('pdf-parse');

export class PdfParser {

    public dataBuffer: any;

    public constructor(filepath: string) {
        this.dataBuffer = fs.readFileSync(filepath);
    }

    public writeToTxt(filepath: string) {
        pdf(this.dataBuffer).then((data: any) => {
            fs.writeFile(filepath, data.text, function (err: Error) {
                if (err) return console.log(err);
            });
        });
    }
}

var parser: PdfParser = new PdfParser('../pdfs/Ingenieria Civil 2009.pdf');
parser.writeToTxt('test.txt');

// All pdfs shall be on its folder and automatically parsed and read.

// There also needs to be some type of structure that can hold all the information
// in the graph.

// A parser must be able to feed the pdf information to said structure.