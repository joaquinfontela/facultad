import { Command } from './command';

export class Credentials {

    // Maps each career from it's unicode id (1-12) to a [role id, name] tuple
    private careers: { [code: string]: [string, string] } = {};
    private careerIds: { [code: string]: number } = {};
    private commandList: Command[];

    constructor() {
        this.commandList = [];
        this.initializeCommands();
        this.initializeCareerCodes();
    }

    /**
     * Pushes and creates each command.
     */
    private initializeCommands() {
        this.addCommand(new Command("Brinda información de los comandos disponibles.", "ayuda"));
        this.addCommand(new Command("Desconecta al bot como, si te obligaran a activar la cámara.", "tomatela"));
        this.addCommand(new Command("Brinda una lista de materias que se pueden cursar, en función de los códigos de materias aprobadas dadas", "disponibles"));
        this.addCommand(new Command("Muestra que materias uno necesita tener aprobado para cursar una en particular", "restantes"));
        this.addCommand(new Command("Responde con la cantidad de créditos (robados) conseguidos", "creds"));
        this.addCommand(new Command("Guarda en el sistema las materias aprobadas", "aprobe"));
        this.addCommand(new Command("Quita materias aprobadas del sistema", "recurse"));
        this.addCommand(new Command("Muestra la lista de materias aprobadas", "siu"));
        this.addCommand(new Command("Envia un mensaje con el que cada fiubense puede elegir su rol de carrera. Si sos de letras te bannea", "carreras"));
    }

    /**
     * 
     * @param command Command instance to be pushed in the list.
     */
    public addCommand(command: Command): void {
        this.commandList.push(command);
    }

    /**
     * @returns Returns a string that concats each command description to its keyword.
     */
    public getHelp(): string {
        var help: string = "";
        this.commandList.forEach((c: Command) => { help += c.getDescription() + "\n" });
        return help;
    }

    /**
     * 
     * @param name Career emoji key. Unicode encoded. 
     * 
     * @returns Returns role id from said key.
     */
    public getRoleID(name: string): string {
        return this.careers[name][0];
    }

    /**
     * Initializes the dict with each career values.
     */
    private initializeCareerCodes(): void {
        this.careers['🌿'] = ['805497434896859156', 'agrimensura'];
        this.careers['🍎'] = ['805497533366534154', 'alimentos'];
        this.careers['🏦'] = ['805497587171459102', 'civil'];
        this.careers['⚡'] = ['805497633334362112', 'electrica'];
        this.careers['🔌'] = ['805497707778408448', 'electronica'];
        this.careers['🏭'] = ['805497753035472917', 'industrial'];
        this.careers['💾'] = ['805497795318251550', 'informatica'];
        this.careers['🛠️'] = ['805497827073064970', 'mecanica'];
        this.careers['⚓'] = ['805497878265069568', 'naval'];
        this.careers['⛽'] = ['805497925907251200', 'petroleo'];
        this.careers['🧪'] = ['805497970606604288', 'quimica'];
        this.careers['💻'] = ['805498041028313108', 'sistemas'];

        var i: number = 1;
        Object.keys(this.careers).forEach((emoji: string) => {
            this.careerIds[this.careers[emoji][0]] = i;
            i++;
        });
    }

    /**
     * 
     * @param id Career id. Number between 0 and 11.
     * 
     * @returns Return said career's name from the dict.
     */
    public getCareerNameFromId(id: number): string {
        id += 1;
        var roleid: string = "";
        var ans: string = "";
        Object.keys(this.careerIds).forEach((key: string) => {
            if (this.careerIds[key] === id) {
                roleid = key;
            }
        });
        Object.keys(this.careers).forEach((emoji: string) => {
            if (this.careers[emoji][0] === roleid) {
                ans = this.careers[emoji][1];
            }
        });
        return ans;
    }

    /**
     * 
     * @param id Career's role id.
     * 
     * @returns Returns the career id. Number between 0 and 11.
     */
    public getCarrerNumberFromRoleID(id: string): number {
        return this.careerIds[id];
    }

    /**
     * @returns Returns a string that maps every career's name to it's unicode key.
     */
    public getRolesMsg(): string {
        var ans: string = "Para obtener tu rol de carrera reacciona a este mensaje con su emoji correspondiente:\n";
        Object.keys(this.careers).forEach((key: string) => {
            ans += this.careers[key][1] + "  ⇒  " + key + "\n";
        });
        return ans;
    }

    /**
     * @returns Returns the dictionary of career ids.
     */
    public getCareerIds(): { [code: string]: number } { return this.careerIds; }
}    