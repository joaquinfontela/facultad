const Graph = require('graphology');

/**
 * This class holds every important bit of information a subject can have.
 */
export class Subject {
    private name: string;
    private code: string;
    private credits: number;
    private correlatives: Subject[];

    public getCode(): string { return this.code; }
    public getCredits(): number { return this.credits; }
    public getName(): string { return this.name; }
    public getCorrelatives(): Subject[] { return this.correlatives; }
    public changeName(name: string): void { this.name = name; }

    public constructor(name: string, code: string, credits: number) {
        this.name = name;
        this.code = code;
        this.credits = credits;
        this.correlatives = [];
    }

    /**
     * 
     * @param subjects Subjects to be added as correlatives.
     */
    public addCorrelatives(subjects: Subject[]): void {
        this.correlatives = this.correlatives.concat(subjects);
    }
};

export class SubjectGraph {
    private adjList: Subject[] = [];

    /**
     * 
     * @param subject Pushes subject to adjacency list.
     */
    public addSubject(subject: Subject) {
        this.adjList.push(subject);
    }

    /**
     * 
     * @param code String that represents the code of the subject to be searched.
     * 
     * @returns Subject or undefined whether the subject was found or not.
     */
    private searchSubjectByCode(code: string): Subject | undefined {
        return this.adjList.find((s: Subject) => s.getCode() == code);
    }

    /**
     * Wrapper for this.searchSubjectByCode. Returns the answer if it was found,
     * throws and exception otherwise.
     * 
     * @param code String that represents the code of the subject to be searched. 
     */
    public getSubjectByCode(code: string): Subject {
        var value: Subject | undefined = this.searchSubjectByCode(code);
        if (value === undefined) {
            throw new TypeError("Couldn't find said subject.");
        } else {
            return value;
        }
    }

    /**
     * 
     * @param code Code of the subjects correlative list to be returned.
     */
    public getCorrelatives(code: string): Subject[] {
        return this.getSubjectByCode(code).getCorrelatives();
    }

    /**
     * DEBUG ONLY
     * 
     * This function prints the graph structure.
     */
    public printGraph() {
        for (var i = 0; i < this.adjList.length; i++) {
            var subject: Subject = this.adjList[i];
            var correlativeString: string = "";
            var correlatives: Subject[] = subject.getCorrelatives();
            correlatives.forEach((s: Subject) => {
                correlativeString += " -> " + s.getName();
            });
            console.log(subject.getName() + correlativeString);
        }
    }
}

var graph: SubjectGraph = new SubjectGraph();
var a1: Subject = new Subject("analisis 1", "x1", 10);
var a2: Subject = new Subject("analisis 2", "x2", 20);
var a3: Subject = new Subject("analisis 3", "x3", 40);
var av: Subject = new Subject("algebra vectorial", "x4", 30);
graph.addSubject(a1);
graph.addSubject(a2);
graph.addSubject(a3);
graph.addSubject(av);
a1.addCorrelatives([a2]);
a2.addCorrelatives([a3, av]);
a3.addCorrelatives([]);
av.addCorrelatives([]);
graph.printGraph();