import { Command } from './command';

export class Bot {

    private commandList: Command[];

    constructor() {
        this.commandList = [];
        this.initializeCommands();
    }

    private initializeCommands() {
        this.commandList.push(new Command("Brinda información de los comandos disponibles.", "help"));
        this.commandList.push(new Command("Desconecta al bot.", "disconnect"));
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