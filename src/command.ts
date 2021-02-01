export class Command {

    private description: string;
    public keyword: string;

    /**
     * 
     * @param description Descripción del comando. 
     * @param keyword Palabra clave que ejecuta el mismo.
     */
    constructor(description: string, keyword: string) {
        this.description = description + "\n";
        this.keyword = keyword;
    }

    /**
     * @returns Un string que contiene el keyword y descripción.
     */
    public getDescription(): string {
        return "[" + this.keyword + "] " + this.description;
    }
}