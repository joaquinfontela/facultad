/**
 * This class holds every important bit of information a subject can have.
 */
export class Subject {
    private name: string;
    private code: string;
    private credits: string;
    private neededCredits: number;
    private correlativeCodes: string[];

    /**
     * @returns Returns the subject's code.
     */
    public getCode(): string { return this.code; }

    /**
     * @returns Returns the amount of credits said subject gives.
     */
    public getCredits(): string { return this.credits; }

    /**
     * @returns Returns the amount of credits needed to take this subject.
     */
    public getNeededCredits(): number { return this.neededCredits; }

    /**
     * @returns Returns the subject's name.
     */
    public getName(): string { return this.name; }

    /**
     * @returns Returns the list of subject codes that must be passed for one to take this couse.
     */
    public getCorrelatives(): string[] { return this.correlativeCodes; }

    /**
     * Loads the amount of needed credits for one to take this course.
     */
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

    /**
     * 
     * @param name Name of the subject.
     * @param code The subject's name.
     * @param credits The amount of credits it gives once passed.
     * @param correlatives List of correlative subjects.
     */
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
    public addSubject(subject: Subject): void {
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
     * 
     * @param code Code of the subjects correlative list to be returned.
     * 
     * @returns Returns the list of said subjects correlatives.
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

    /**
     * 
     * @param code Code of the subject to analyze.
     * @param codes List needed for recursive algorithm.
     * 
     * @returns Returns a list of the subjects codes needed to take said course.
     */
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

    /**
     * 
     * Wrapper for _subjectCodesNeededFor(string, string[])
     * 
     * @param code Code of the subject to analyze.
     * 
     * @returns Returns a list of the subjects codes needed to take said course.
     */
    public subjectCodesNeededFor(code: string): string[] {
        return this._subjectCodesNeededFor(code, []);
    }

    /**
     * @returns Returns the number of pushed subjects.
     */
    public size(): number {
        return this.adjList.length;
    }

    /**
     * 
     * @param codes Subject codes to analyze.
     * 
     * @returns Returns the total number of credits accumulated from the list of subject codes given. 
     */
    public getTotalCredits(codes: string[]): number {
        var credits: number = 0;
        codes.forEach((s: string) => {
            var subj: Subject | undefined = this.searchSubjectByCode(s);
            if (subj !== undefined) {
                credits += Number(subj.getCredits());
            }
        });
        return credits;
    }

    /**
     * 
     * @param codes Subject codes to analyze.
     * 
     * @returns The list of subjects you can take.
     */
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