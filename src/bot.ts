import { Command } from './command';

export class Bot {

    private commandList: Command[];

    constructor() {
        this.commandList = [];
        this.initializeCommands();
    }

    private initializeCommands() {
        this.commandList.push(new Command("Brinda información de los comandos disponibles.", "ayuda"));
        this.commandList.push(new Command("Desconecta al bot como si te piden que actives la cámara", "tomatela"));
        this.commandList.push(new Command("Brinda una lista de materias que se pueden cursar, en función de los códigos de materias aprobados dados", "disponibles"));
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

}