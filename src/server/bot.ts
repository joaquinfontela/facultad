import { Credentials } from "./credentials";
import { Users } from "./users";
import { GraphFiller } from "./graphfiller";
import { Subject, SubjectGraph } from "./graph";

const COMMAND_HEADER = "\n +--------------------- COMANDOS FIUBENSES DISPONIBLES ---------------------+ \n\n";

export class Bot {

    private credentialsManager: Credentials;
    private filler: GraphFiller = new GraphFiller("./csv/");
    public users: Users = new Users();

    constructor(credentialsManager: Credentials) {
        this.credentialsManager = credentialsManager;
    }

    public getCareersFromUserid(userid: string): number[] {
        return this.users.getCareers(userid);
    }

    /**
     * 
     * @param id Creates new user with the given id.
     */
    public addUser(id: string) { this.users.addUser(id); }

    public updateUserCareer(userid: string, careerCodes: number[]): void {
        this.users.updateCareer(userid, careerCodes);
    }

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

    /** REFACTOR
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
     * @returns Dict that maps CareerID -> Subjects Available to Do from the given data.
     */
    public getAvailableSubjects(userid: string, careerCodes: number[]): { [career: number]: Subject[] } {
        var ans: { [career: number]: Subject[] } = [];
        var graphs: SubjectGraph[] = this.filler.parseAllText();
        careerCodes.forEach((id: number) => {
            var availables: string[] = graphs[id].subjectsICanDo(this.users.getSubjects(userid));
            ans[id] = [];
            availables.forEach((code: string) => {
                var subj: Subject | undefined = graphs[id].searchSubjectByCode(code);
                if (subj !== undefined) {
                    ans[id].push(subj);
                }
            });
        });

        return ans;
    }

    // Get remaming, done and to do subjects.

    /** REFACTOR
     * 
     * @param userid User's id.
     * 
     * @param careerCodes List of the career codes that the user is enrolled in.
     * 
     * @param wanted Subject code to analyze.
     * 
     * @returns Returns the information of the needed subjects to pass before taking up said courses. 
     */
    public remainingSubjects(userid: string, careerCodes: number[], wanted: string): string {
        if (wanted.length === 0) {
            return "Me tenes que pasar algún código para analizar master.";
        } else if (careerCodes.length === 0) {
            return "Te tenes que anotar en alguna carrera (pst, andate a la utn si podes)";
        }
        var graphs: SubjectGraph[] = this.filler.parseAllText();
        var ans: string = "";
        careerCodes.forEach((id: number) => {
            ans += "\n⇒ En la carrera de " + this.credentialsManager.getCareerNameFromId(id) + " ";
            if (graphs[id].searchSubjectByCode(wanted) === undefined) {
                ans += "no existe la materia de código: " + wanted;
            } else if (this.users.getSubjects(userid).includes(wanted)) {
                ans += "ya aprobó la materia."
            } else {
                var aCursar: string[] = graphs[id].subjectCodesNeededFor(wanted).filter(
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

    /** REFACTOR
    * 
    * @param userid User's id.
    * 
    * @param careerCodes List of the career codes that the user is enrolled in.
    * 
    * @param wanted Subject code to analyze.
    * 
    * @returns A dict mapping CareerId -> Subjects codes needed on each career to do the wanted one. 
    */
    public getRemainingSubjects(userid: string, careerCodes: number[], wanted: string): { [career: number]: string[] } {
        var ans: { [career: number]: string[] } = [];
        var graphs: SubjectGraph[] = this.filler.parseAllText();
        careerCodes.forEach((id: number) => {
            ans[id] = [];
            if (graphs[id].searchSubjectByCode(wanted) !== undefined && // The subject must exist
                !this.users.getSubjects(userid).includes(wanted)) { // The subject must still be doable
                var aCursar: string[] = graphs[id].subjectCodesNeededFor(wanted).filter(
                    (s: string) => !this.users.getSubjects(userid).includes(s));
                if (aCursar.length !== 0) { // If the subjects exist
                    ans[id] = aCursar;
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
        var subj: string[] = this.getPassedSubjects(userid);
        if (subj.length === 0) {
            return " Aparentemente no aprobaste nada, ojo y fijate en fiubaconsultas eh";
        }
        return (" Usted robó las materias: \n" + subj.join(', '));
    }

    /**
     * 
     * @param userid User's id.
     * 
     * @returns List of passed subjects.
     */
    public getPassedSubjects(userid: string): string[] {
        return this.users.getSubjects(userid);
    }

    /**
     * 
     * @param userID User's ID
     * 
     * @returns User's data, meant to be written in a JSON file. Contains passed, available, and remaining subjects of the user's career or careers, as well as the total credits obtained in each one.
     */
    public getUserDataFile(userID: string): string {
        var userData: { [data: string]: { [career: string]: any } } = this.getUserData(userID);
        var userDataFile: string = JSON.stringify(userData);
        return userDataFile;
    }

    /**
     * 
     * @param userID User's ID
     * 
     * @returns User's data, which contains passed, available, and remaining subjects of the user's career or careers, as well as the total credits obtained in each one.
     */
    private getUserData(userID: string): { [data: string]: { [career: number]: { [careerData: string]: any } } } {
        var userData: { [data: string]: { [career: number]: any } } = { "data": {} };
        var userCareers: number[] = this.users.getCareers(userID);
        var allGraphs: SubjectGraph[] = this.filler.parseAllText();
        console.log("HOLA: " + userID);
        userCareers.forEach((career: number) => {
            userData["data"][career] = this.getUserCareerData(userID, career, allGraphs);
        });
        return userData;
    }

    /**
     * 
     * @param userID User's ID
     * 
     * @param careerID ID of one of the user's careers.
     * 
     * @param allGraphs List containing all subject graphs of each career.
     * 
     * @returns User's career data, which contains passed, available, and remaining subjects of the user's career, as well as the total credits obtained in it.
     * 
     */
    private getUserCareerData(userID: string, careerID: number, allGraphs: SubjectGraph[]): { [careerData: string]: any } {
        var userData: { [careerData: string]: any } = {};
        var careerGraph: SubjectGraph = allGraphs[careerID];
        var passedSubjects: string[] = this.users.getSubjects(userID);
        var availableSubjects: string[] = careerGraph.subjectsICanDo(passedSubjects);

        userData["available"] = [];
        availableSubjects.forEach((subjectCode: string) => {
            userData["available"].push(this.getSubjectInfo(subjectCode, careerGraph));
        });

        userData["left"] = {};
        careerGraph.getAllSubjectCodes().forEach((subjectCode: string) => {
            if (!passedSubjects.includes(subjectCode)) {
                userData["left"][subjectCode] = careerGraph.subjectCodesNeededFor(subjectCode).filter((neededSubjectCode: string) => {
                    return !passedSubjects.includes(neededSubjectCode);
                }).map((neededSubjectCode: string) => {
                    return this.getSubjectInfo(neededSubjectCode, careerGraph);
                });
            }
        });

        userData["credits"] = careerGraph.getTotalCredits(passedSubjects);

        userData["passed"] = [];
        passedSubjects.forEach((subjectCode: string) => {
            userData["passed"].push(this.getSubjectInfo(subjectCode, careerGraph));
        });

        return userData;
    }

    /**
     * 
     * @param subjectCode Subject's code you want to get information about.
     * 
     * @param careerGraph Subject graph of one of the careers.
     * 
     * @returns Subject information related to the given career graph. Contains code, name, and credits of said subject.
     */
    private getSubjectInfo(subjectCode: string, careerGraph: SubjectGraph): { [info: string]: string | number } {
        var subject: Subject | undefined = careerGraph.searchSubjectByCode(subjectCode);
        var subjectInfo: { [info: string]: string | number } = {}
        if (subject !== undefined) {
            subjectInfo["code"] = subject.getCode();
            subjectInfo["name"] = subject.getName();
            subjectInfo["credits"] = subject.getCredits();
        }
        return subjectInfo;
    }
}
