const fs = require('fs');
const pdf = require('pdf-parse');

export class PdfToTxt {

    private outputPath: string;

    public constructor(filepath: string) {
        this.outputPath = filepath;
    }

    private generateTxtName(file: string): string {
        var name: string = this.outputPath + file.split('/').splice(-1)[0].split('.')[0] + ".txt";
        return name;
    }

    public writeToTxt(file: string): void {
        var filetxt: string = this.generateTxtName(file);
        pdf(fs.readFileSync(file)).then((data: any) => {
            fs.writeFile(filetxt, data.text, function (err: Error) {
                if (err) return console.log(err);
            });
        }).catch((err: Error) => { console.log(err); });
    }

}

var parser: PdfToTxt = new PdfToTxt('../txts/');

parser.writeToTxt('../pdfs/Ingenieria Civil 2009.pdf');

//console.log(fs.readFileSync('test.txt', 'UTF-8'));

// All pdfs shall be on its folder and automatically parsed and read.

// There also needs to be some type of structure that can hold all the information
// in the graph.

// A parser must be able to feed the pdf information to said structure.