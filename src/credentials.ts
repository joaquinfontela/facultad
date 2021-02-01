/**
 * This interface must be implemented in order for the backend bot to work.
 */
export interface Credentials {

    /**
     * 
     * @returns Returns a string that helps the user learn the commands.
     */
    getHelp(): string;

    /**
     * 
     * @param id Number from 0 to 11 that represents the career to get.
     * 
     * @returns Returns the career name mapped to said id.
     */
    getCareerNameFromId(id: number): string;
}
