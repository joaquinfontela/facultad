import { WSAEDQUOT } from "constants";

const MATERIAS: 0 | 1 = 0;
const ROLES: 0 | 1 = 1;

export class Users {

    // User id -> [Subjects passed, Roles]
    private users: { [id: string]: [string[], string[]] } = {};

    /**
     * 
     * @param id Id of the user to add.
     */
    public addUser(id: string): void {
        if (!(id in this.users)) {
            this.users[id] = [[], []];
        }
    }

    /**
     * 
     * @param id User id.
     * 
     * @param pos 0 if it's trying to access the subject's list. 1 for the roles list.
     * 
     * @returns List with the values fetched from id and pos.
     */
    private getValue(id: string, pos: 0 | 1): string[] {
        if (id in this.users) {
            return this.users[id][pos];
        }
        return [];
    }

    /**
     * 
     * @param id User's id.
     * 
     * @returns Returns a list of passed subjects.
     */
    public getSubjects(id: string): string[] {
        return this.getValue(id, MATERIAS);
    }

    /**
     * 
     * @param id User's id.
     * 
     * @returns Returns a list of the user's assigned roles.
     */
    public getRoles(id: string): string[] {
        return this.getValue(id, ROLES);
    }

    /**
     * 
     * @param id User's id.
     * @param pos 0 if it's trying to access the subject's list. 1 for the roles list
     * @param list List of items to remove.
     */
    public removeValue(id: string, pos: 0 | 1, list: string[]): void {
        if (id in this.users) {
            this.users[id][pos] = this.users[id][pos].filter((c: string) => !list.includes(c));
        }
    }

    /**
     * 
     * @param id User's id.
     * @param tokill List of subjects to remove from said user.
     */
    public removeSubjects(id: string, tokill: string[]): void {
        tokill = tokill.map((s: string) => s.toUpperCase());
        return this.removeValue(id, MATERIAS, tokill);
    }

    /**
     * 
     * @param id User's id.
     * @param tokill List of roles to remove from said user.
     */
    public removeRoles(id: string, tokill: string[]): void {
        return this.removeValue(id, ROLES, tokill);
    }

    /**
     * 
     * @param id User's id.
     * @param pos 0 if it's trying to access the subject's list. 1 for the roles list.
     * @param list List of values to concat.
     */
    public addValue(id: string, pos: number, list: string[]): void {
        if (id in this.users) {
            this.users[id][pos] = this.users[id][pos].concat(list);
        }
    }
    /**
     * 
     * @param id User's id.
     * @param roleids List of roles to add to user.
     */
    public addRoles(id: string, roleids: string[]): void {
        return this.addValue(id, ROLES, roleids);
    }

    /**
     * 
     * @param id User's id.
     * @param subjects List of subjects to add to user.
     */
    public addSubjects(id: string, subjects: string[]): void {
        subjects = subjects.map((s: string) => s.toUpperCase());
        return this.addValue(id, MATERIAS, subjects);
    }

}