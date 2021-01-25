const fs = require('fs');
const pdf = require('pdf-parse');

/**
 * Transforms pdfs files to txt for easier reading and parsing.
 * 
 */
export class PdfToTxt {

    private outputPath: string;

    /**
     * 
     * @param filepath Output path where all the trasformed files
     * will be stored at.
     */
    public constructor(filepath: string) {
        this.outputPath = filepath;
    }

    /**
     * 
     * @param file Name of the file to transform from pdf to txt.
     */
    private generateTxtName(file: string): string {
        var name: string = this.outputPath +
            file.split('/').splice(-1)[0].split('.')[0] + ".txt";
        return name;
    }

    /**
     * 
     * @param file File to transform. Must exist and be a valid file.
     */
    public writeToTxt(file: string): void {
        var filetxt: string = this.generateTxtName(file);
        pdf(fs.readFileSync(file)).then((data: any) => {
            fs.writeFile(filetxt, data.text, function (err: Error) {
                if (err) return console.log(err);
            });
        }).catch((err: Error) => { console.log(err); });
    }

    /**
     * 
     * @param path Transforms all files found, from the path given,
     * to txt. Must all be valid pdf files.
     */
    public writeAllToTxt(path: string): void {
        fs.readdirSync(path).forEach((file: string) => {
            this.writeToTxt(path + file);
        });
    }

}

var parser: PdfToTxt = new PdfToTxt('../txts/');

parser.writeAllToTxt('../pdfs/');


// All pdfs shall be on its folder and automatically parsed and read.

// There also needs to be some type of structure that can hold all the information
// in the graph.

// A parser must be able to feed the pdf information to said structure.