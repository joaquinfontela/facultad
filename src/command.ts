export class Command {

    private description: string;
    public keyword: string;

    constructor(description: string, keyword: string) {
        this.description = description + "\n";
        this.keyword = keyword;
    }

    public getDescription(): string {
        return "[" + this.keyword + "] " + this.description;
    }
}