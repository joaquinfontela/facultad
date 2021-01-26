const Graph = require('graphology');

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

    public addCorrelatives(subjects: Subject[]): void {
        this.correlatives = this.correlatives.concat(subjects);
    }
};

export class SubjectGraph {
    private adjList: Subject[] = [];

    public addSubject(subject: Subject) {
        this.adjList.push(subject);
    }

    private searchSubjectByCode(code: string): Subject | undefined {
        return this.adjList.find((s: Subject) => s.getCode() == code);
    }

    public getSubjectByCode(code: string): Subject {
        var value: Subject | undefined = this.searchSubjectByCode(code);
        if (value === undefined) {
            throw new TypeError("Couldn't find said subject.");
        } else {
            return value;
        }
    }

    public getCorrelatives(code: string): Subject[] {
        return this.getSubjectByCode(code).getCorrelatives();
    }

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