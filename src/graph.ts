const Graph = require('graphology');

/**
 * This class holds every important bit of information a subject can have.
 */
export class Subject {
    private name: string;
    private code: string;
    private credits: string;
    private neededCredits: number;
    private correlativeCodes: string[];

    public getCode(): string { return this.code; }
    public getCredits(): string { return this.credits; }
    public getNeededCredits(): number { return this.neededCredits; }
    public getName(): string { return this.name; }
    public getCorrelatives(): string[] { return this.correlativeCodes; }

    private loadNeededCredits(): void {
        for (var i = 0; i < this.correlativeCodes.length; i++) {
            var corr: string = this.correlativeCodes[i];
            if (corr.substr(0, 4) === "CRED") {
                this.correlativeCodes = this.correlativeCodes.filter((c: string) => c !== corr);
                this.neededCredits = Number(corr.substr(4, corr.length));
                return;
            }
        }
    }

    public constructor(name: string, code: string, credits: string, correlatives: string[]) {
        this.name = name;
        this.code = code;
        this.credits = credits;
        this.correlativeCodes = correlatives;
        this.neededCredits = 0;
        this.loadNeededCredits();
    }
};

function listConainedInAnother(a: any[], b: any[]): boolean {
    for (var i = 0; i < b.length; i++) {
        if (!a.includes(b[i])) {
            return false;
        }
    }
    return true;
}

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
    public searchSubjectByCode(code: string): Subject | undefined {
        return this.adjList.find((s: Subject) => s.getCode() === code);
    }

    /**
     * Wrapper for this.searchSubjectByCode. Returns the answer if it was found,
     * throws and exception otherwise.
     * 
     * @param code String that represents the code of the subject to be searched. 
     */
    /*public getSubjectByCode(code: string): Subject {
        var value: Subject | undefined = this.searchSubjectByCode(code);
        if (value === undefined) {
            throw new TypeError("Couldn't find the subject with code: " + code);
        } else {
            return value;
        }
    }*/

    /**
     * 
     * @param code Code of the subjects correlative list to be returned.
     */
    public getCorrelatives(code: string): string[] {
        var subj: Subject | undefined = this.searchSubjectByCode(code);
        if (subj === undefined) return [];
        return subj.getCorrelatives();
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
            var correlatives: string[] = subject.getCorrelatives();
            correlatives.forEach((code: string) => {
                var subj: Subject | undefined = this.searchSubjectByCode(code);
                if (subj === undefined) return;
                correlativeString += " -> " + subj.getName();
            });
            console.log(subject.getName() + correlativeString);
        }
    }

    private _subjectCodesNeededFor(code: string, codes: string[]): string[] {
        console.log(`Codes up to now: ${codes.toString()}`);
        this.adjList.forEach((s: Subject) => {
            let correlatives: string[] = this.getCorrelatives(code);
            let iterCode: string = s.getCode();
            if (correlatives.includes(iterCode) && !codes.includes(iterCode)) {
                codes.push(iterCode);
                codes = this._subjectCodesNeededFor(iterCode, codes);
            }
        });
        return codes;
    }

    public subjectCodesNeededFor(code: string): string[] {
        return this._subjectCodesNeededFor(code, []);
    }

    public size(): number {
        return this.adjList.length;
    }

    public getTotalCredits(codes: string[]): number {
        var creditosAcumulados: number = 0;
        codes.forEach((s: string) => {
            var subj: Subject | undefined = this.searchSubjectByCode(s);
            if (subj !== undefined) {
                creditosAcumulados += Number(subj.getCredits());
            }
        });
        return creditosAcumulados;
    }

    public subjectsICanDo(codes: string[]): string[] {
        var availables: string[] = [];
        var creditosAcumulados: number = this.getTotalCredits(codes);
        for (var i = 0; i < this.adjList.length; i++) {
            let correlatives: string[] = this.adjList[i].getCorrelatives();
            if ((listConainedInAnother(codes, correlatives) &&
                (creditosAcumulados >= this.adjList[i].getNeededCredits())) &&
                (!codes.includes(this.adjList[i].getCode()))) {
                availables.push(this.adjList[i].getCode());
            }
        }
        return availables;
    }
}