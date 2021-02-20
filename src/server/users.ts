import { WSAEDQUOT } from "constants";
require("dotenv").config();

export class Users {

    // User id -> [Subjects passed, Roles]
    private subjects: { [id: string]: string[] } = {};
    private careers: { [id: string]: number[] } = {};

    public updateCareer(userid: string, careerCodes: number[]): void {
        Object.keys(this.careers).forEach((key: string) => {
            if (key === userid) {
                this.careers[key] = careerCodes;
            };
        });
    }

    /**
     * 
     * @param id Id of the user to add.
     */
    public addUser(id: string): void {
        if (!(id in this.subjects)) {
            this.subjects[id] = [];
            this.careers[id] = [];
        }
    }

    /**
     * 
     * @param id User's id.
     * 
     * @returns Returns a list of passed subjects.
     */
    public getSubjects(id: string): string[] {
        return this.subjects[id];
    }

    /**
     * 
     * @param id User's id.
     * 
     * @returns Returns a list of the user's assigned roles.
     */
    public getCareers(id: string): number[] {
        return this.careers[id];
    }

    /**
     * 
     * @param id User's id.
     * 
     * @param tokill List of subjects to remove from said user.
     */
    public removeSubjects(id: string, tokill: string[]): void {
        if (tokill.length === 0) return;
        tokill = tokill.map((s: string) => s.toUpperCase());
        this.subjects[id] = this.subjects[id].filter((c: string) => !tokill.includes(c));
    }

    /**
     * 
     * @param id User's id.
     * 
     * @param tokill List of roles to remove from said user.
     */
    public removeCareers(id: string, tokill: number[]): void {
        this.careers[id] = this.careers[id].filter((n: number) => !tokill.includes(n));
    }

    /**
     * 
     * @param id User's id.
     * 
     * @param roleids List of roles to add to user.
     */
    public addCareer(id: string, roleids: number[]): void {
        this.careers[id] = this.careers[id].concat(roleids);
    }

    /**
     * 
     * @param id User's id.
     * 
     * @param subjects List of subjects to add to user.
     */
    public addSubjects(id: string, subs: string[]): void {
        if (subs.length === 0) return;
        subs = subs.map((s: string) => s.toUpperCase());
        this.subjects[id] = this.subjects[id].concat(subs);
    }

}