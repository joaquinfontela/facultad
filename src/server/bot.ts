import { Credentials } from "./credentials";
import { Users } from "./user";
import { GraphFiller } from "./graphfiller";
import { Subject, SubjectGraph } from "./graph";

const COMMAND_HEADER = "\n    +------ COMANDOS FIUBENSES DISPONIBLES ------+\n\n";

export class Bot {

    private credentialsManager: Credentials;
    private filler: GraphFiller = new GraphFiller("./csv/");
    private users: Users = new Users();

    constructor(credentialsManager: Credentials) {
        this.credentialsManager = credentialsManager;
    }

    /**
     * 
     * @param id Creates new user with the given id.
     */
    public addUser(id: string) { this.users.addUser(id); }

    /**
     * 
     * @returns Returns a reference to the credential manager.
     */
    public getCredentialManager(): Credentials {
        return this.credentialsManager;
    }

    /**
     * 
     * @returns Returns help to the user.
     */
    public replyWithHelp(): string {
        return (COMMAND_HEADER + this.credentialsManager.getHelp());
    }

    /**
     * 
     * @param userid User's id.
     * 
     * @param careerCodes List of the career codes that the user is enrolled in.
     * 
     * @returns Returns a string containing the subjects that the user can take, depending on the career. 
     */
    public availableSubjects(userid: string, careerCodes: number[]): string {
        if (careerCodes.length === 0) {
            return "Te tenes que anotar en alguna materia (pst, andate a la utn si podes)";
        }
        var graphs: SubjectGraph[] = this.filler.parseAllText();
        var reply: string = "\n";
        careerCodes.forEach((id: number) => {
            var answer: string[] = graphs[id].subjectsICanDo(this.users.getSubjects(userid));
            reply += "Para la carrera de " + this.credentialsManager.getCareerNameFromId(id) + " se puede cursar: \n"
            if (answer.length === 0) {
                reply += "nada, anda a estudiar vago\n";
            } else {
                answer.forEach((code: string) => {
                    var subj: Subject | undefined = graphs[id].searchSubjectByCode(code);
                    if (subj === undefined) {
                        reply += " no se encontró el código: " + code + "\n";
                    } else {
                        reply += code + " " + subj.getName() + "\n";
                    }
                });
            }
            reply += "\n";
        });
        return reply;
    }

    /**
     * 
     * @param userid User's id.
     * 
     * @param careerCodes List of the career codes that the user is enrolled in.
     * 
     * @param args Subject codes to analyze.
     * 
     * @returns Returns the information of the needed subjects to pass before taking up said courses. 
     */
    public remainingSubjects(userid: string, careerCodes: number[], args: string[]): string {
        if (Array.from(args).length === 0) {
            return "Me tenes que pasar algún código para analizar master.";
        } else if (careerCodes.length === 0) {
            return "Te tenes que anotar en alguna carrera (pst, andate a la utn si podes)";
        }
        var graphs: SubjectGraph[] = this.filler.parseAllText();
        var ans: string = "";
        careerCodes.forEach((id: number) => {
            ans += "\n En la carrera de " + this.credentialsManager.getCareerNameFromId(id) + " ";
            if (graphs[id].searchSubjectByCode(args[0]) === undefined) {
                ans += "no existe la materia de código: " + args[0];
            } else if (this.users.getSubjects(userid).includes(args[0])) {
                ans += "ya aprobó la materia."
            } else {
                var aCursar: string[] = graphs[id].subjectCodesNeededFor(args[0]).filter(
                    (s: string) => !this.users.getSubjects(userid).includes(s));
                if (aCursar.length === 0) {
                    ans += "ya puede cursar la materia ingresada.";
                } else {
                    ans += "necesita cursar: " + aCursar.join(', ');
                }
            }
        });
        return ans;
    }

    /**
     * 
     * @param userid User's id.
     * 
     * @param careerCodes List of the career codes that the user is enrolled in.
     * 
     * @returns Returns a string containing the info of the credits accumulated depending on the career.
     */
    public sendCreds(userid: string, careerCodes: number[]): string {
        if (careerCodes.length === 0) {
            return "Te tenes que anotar en alguna carrera (pst, andate a la utn si podes)";
        }
        var ans: string = "";
        var values: [string, number][] = this.getCredsTuple(userid, careerCodes);
        values.forEach((tuple: [string, number]) => {
            ans += "Para la carrera " + tuple[0] + " tenés: " + tuple[1] + "\n";
        });
        return ans;
    }

    /**
     * 
     * @param userid User's id.
     * 
     * @param careerCodes List of the career codes that the user is enrolled in.
     * 
     * @param careerCodes List of [careerName: string, creds: number] tuples.
     */
    public getCredsTuple(userid: string, careerCodes: number[]): [string, number][] {
        var tuples: [string, number][] = [];
        careerCodes.forEach((code: number) => {
            var graphs: SubjectGraph[] = this.filler.parseAllText();
            tuples.push([this.credentialsManager.getCareerNameFromId(code),
            graphs[code].getTotalCredits(this.users.getSubjects(userid))]);
        });
        return tuples;
    }

    /**
     * 
     * @param userid User's id.
     * 
     * @param args List of subjects to add to the player.
     */
    public addSubjects(userid: string, args: string[]): void {
        this.users.addSubjects(userid, Array.from(args));
    }

    /**
     * 
     * @param userid User's id.
     * 
     * @param args List of subjects that the user shouldn't have passed.
     */
    public removeSubjects(userid: string, args: string[]): void {
        this.users.removeSubjects(userid, args);
    }

    /**
     * 
     * @param userid User's id.
     * 
     * @returns Returns the subjects that the user has passed.
     */
    public showSubjects(userid: string): string {
        var subj: string[] = this.users.getSubjects(userid);
        if (subj.length === 0) {
            return " Aparentemente no aprobaste nada, ojo y fijate en fiubaconsultas eh";
        }
        return (" Usted robó las materias: \n" + subj.join(', '));
    }
}
