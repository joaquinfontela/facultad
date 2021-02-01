import { Credentials } from "./credentialsmanager";
import { Users } from "./user";
import { GraphFiller } from "./graphfiller";
import { SubjectGraph } from "./graph";

const COMMAND_HEADER = "\n```    +------ COMANDOS FIUBENSES DISPONIBLES ------+\n\n";
const COMMAND_FOOTER = "```";

export class Bot {

    private credentialsManager: Credentials = new Credentials();
    private filler: GraphFiller = new GraphFiller("./csv/");
    private users: Users = new Users();

    public addUser(id: string) { this.users.addUser(id); }

    public getCredentialManager(): Credentials {
        return this.credentialsManager;
    }

    public replyWithHelp(): string {
        return (COMMAND_HEADER + this.credentialsManager.getHelp() + COMMAND_FOOTER);
    }

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
                    reply += code + " " + graphs[id].getSubjectByCode(code).getName() + "\n";
                });
            }
            reply += "\n";
        });
        return reply;
    }

    public remainingSubjects(userid: string, careerCodes: number[], args: string[]): string {
        if (Array.from(args).length === 0) {
            return "Me tenes que pasar algún código para analizar master.";
        } else if (careerCodes.length === 0) {
            return "Te tenes que anotar en alguna materia (pst, andate a la utn si podes)";
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

    public sendCreds(userid: string): string {
        var graphs: SubjectGraph[] = this.filler.parseAllText();
        return ("\n" + graphs[11].getTotalCredits(this.users.getSubjects(userid)));
    }

    public addSubjects(userid: string, args: string[]): void {
        this.users.addSubjects(userid, Array.from(args));
    }

    public removeSubjects(userid: string, args: string[]): void {
        this.users.removeSubjects(userid, args);
    }

    public showSubjects(userid: string): string {
        var subj: string[] = this.users.getSubjects(userid);
        if (subj.length === 0) {
            return " Aparentemente no aprobaste nada, ojo y fijate en fiubaconsultas eh";
        }
        return (" Usted robó las materias: \n" + subj.join(', '));
    }
}