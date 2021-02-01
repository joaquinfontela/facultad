import { WSAEDQUOT } from "constants";

const MATERIAS: number = 0;
const ROLES: number = 1;

export class Users {

    // User id -> [Subjects passed, Roles]
    private users: { [id: string]: [string[], string[]] } = {};

    public addUser(id: string) {
        if (!(id in this.users)) {
            this.users[id] = [[], []];
        }
    }

    private getValue(id: string, pos: number): string[] {
        if (id in this.users && pos < Object.keys(this.users).length) {
            return this.users[id][pos];
        }
        return [];
    }

    public getSubjects(id: string): string[] {
        return this.getValue(id, MATERIAS);
    }

    public getRoles(id: string): string[] {
        return this.getValue(id, ROLES);
    }

    public removeValue(id: string, pos: number, list: string[]): void {
        if (id in this.users) {
            this.users[id][pos] = this.users[id][pos].filter((c: string) => !list.includes(c));
        }
    }

    public removeSubjects(id: string, tokill: string[]): void {
        tokill = tokill.map((s: string) => s.toUpperCase());
        return this.removeValue(id, MATERIAS, tokill);
    }

    public removeRoles(id: string, tokill: string[]): void {
        return this.removeValue(id, ROLES, tokill);
    }

    public addValue(id: string, pos: number, list: string[]): void {
        if (id in this.users) {
            this.users[id][pos] = this.users[id][pos].concat(list);
        }
    }

    public addRoles(id: string, roleids: string[]): void {
        return this.addValue(id, ROLES, roleids);
    }

    public addSubjects(id: string, subjects: string[]): void {
        subjects = subjects.map((s: string) => s.toUpperCase());
        return this.addValue(id, MATERIAS, subjects);
    }

}