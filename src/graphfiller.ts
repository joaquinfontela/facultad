import { stringify } from 'querystring';
import { Subject } from './graph'
import { SubjectGraph } from './graph'

const fs = require('fs');
const readline = require('n-readlines');
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
    public parseText(filename: string, graph: SubjectGraph): void {
        var line: string;
        var reader = new readline(this.pathname + filename);
        while (line = reader.next().toString('utf-8')) {
            if (line == 'false') return;
            this.addToGraph(line, graph);
        }
    }

    /**
     * 
     * @param line Adds line to graph.
     */
    private addToGraph(line: string, graph: SubjectGraph): void {
        var data: string[] = line.split(',');
        graph.addSubject(new Subject(data[1], data[0], data[2], data[3].split('-')));
    }

    /**
     * Parses all text files found on this.pathname. Must all 
     * be valid text files.
     */
    public parseAllText(): SubjectGraph[] {
        var graphs: SubjectGraph[] = [];
        fs.readdirSync(this.pathname).forEach((file: string) => {
            console.log(BLUE + "reading: ", this.pathname + file + RESET);
            var graph: SubjectGraph = new SubjectGraph();
            this.parseText(file, graph);
            graphs.push(graph);
            console.log(graph.size());
        });
        return graphs;
    }

}

var filler: GraphFiller = new GraphFiller("../csv/");

var graphs: SubjectGraph[] = filler.parseAllText();
console.log(graphs[0].subjectCodesNeededFor("62.03").toString());