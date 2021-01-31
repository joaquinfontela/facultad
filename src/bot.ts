import { Command } from './command';

export class Bot {

    // Maps each career from it's unicode id (1-12) to a [unique id, role id] tuple
    private careers: { [code: string]: [number, string] } = {};
    private commandList: Command[];

    constructor() {
        this.commandList = [];
        this.initializeCommands();
        this.initializeCareerCodes();
    }

    private initializeCommands() {
        this.commandList.push(new Command("Brinda información de los comandos disponibles.", "ayuda"));
        this.commandList.push(new Command("Desconecta al bot como si te piden que actives la cámara", "tomatela"));
        this.commandList.push(new Command("Brinda una lista de materias que se pueden cursar, en función de los códigos de materias aprobados dados", "disponibles"));
        this.commandList.push(new Command("Muestra que materias uno necesita tener aprobado para cursar una en particular", "restantes"));
        this.commandList.push(new Command("Responde con la cantidad de créditos (robados) conseguidos", "creds"));
        this.commandList.push(new Command("Guarda en el sistema las materias aprobadas", "aprobe"));
        this.commandList.push(new Command("Quita materias aprobadas del sistema", "recurse"));
        this.commandList.push(new Command("Muestra la lista de materias aprobadas", "siu"));
        //this.commandList.push(new Command("Asigna rol de carrera a usuario. Si sos de letras te bannea", "carrera"));
    }

    public addCommand(command: Command): void {
        this.commandList.push(command);
    }

    public getHelp(): string {
        var help: string = "";

        for (var i = 0; i < this.commandList.length; i++) {
            help += this.commandList[i].getDescription();
        }

        return help;
    }


    public getRole(name: string): string {
        return this.careers[name][1];
    }

    private initializeCareerCodes(): void {
        this.careers['🌿'] = [1, '805497434896859156'];
        this.careers['🍎'] = [2, '805497533366534154'];
        this.careers['🏦'] = [3, '805497587171459102'];
        this.careers['⚡'] = [4, '805497633334362112'];
        this.careers['🔌'] = [5, '805497707778408448'];
        this.careers['🏭'] = [6, '805497753035472917'];
        this.careers['💾'] = [7, '805497795318251550'];
        this.careers['🛠️'] = [8, '805497827073064970'];
        this.careers['⚓'] = [9, '805497878265069568'];
        this.careers['⛽'] = [10, '805497925907251200'];
        this.careers['🧪'] = [11, '805497970606604288'];
        this.careers['💻'] = [12, '805498041028313108'];
    }

}