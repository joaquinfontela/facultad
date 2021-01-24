const Graph = require('graphology');

export class Subject {
    private name: string;
    private code: string;
    private credits: number;

    public getCode(): string { return this.code; }
    public getCredits(): number { return this.credits; }
    public getName(): string { return this.name; }
    public changeName(name: string): void { this.name = name; }

    public constructor(name: string, code: string, credits: number) {
        this.name = name;
        this.code = code;
        this.credits = credits;
    }
};

export class SubjectGraph {
    private graph = new Graph();

    public addSubject(name: string, code: string, credits: number,
        correlatives: Subject[]): void {
        let subject: Subject = new Subject(name, code, credits);
        this.graph.addNode(subject);
        for (let i = 0; i < correlatives.length; i++) {
            this.graph.addEdge(subject, correlatives[i]);
        }
    }

    public searchSubjectByCode(code: string): Subject {
        return this.graph.forEachNodeUntil((node: Subject) => {
            if (node.getCode() === code)
                return node;
        });
    }

    public getCorrelatives(code: string): Subject[] {
        var subject: Subject = this.searchSubjectByCode(code);
        return this.graph.neighbors(subject);
    }
}