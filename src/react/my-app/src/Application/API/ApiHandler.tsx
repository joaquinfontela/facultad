import axios from 'axios'

export default class ApiHandler {

    async getStudentData(studentId: string): Promise<string> {
        return await axios.get(`http://localhost:2000/data/${studentId}`)
            .then(response =>
                response.data
            )
            .catch(error =>
                error
            );

    }

    async validateStudentId(studentId: string): Promise<boolean> {
        return await axios.get(`http://localhost:2000/data/${studentId}`)
            .then(() => {
                return true;
            })
            .catch((error) => {
                return false;
            });
    }

    async sendData(studentId: string, studentData: object) {
        return await axios.post(`http://localhost:2000/data/${studentId}/${JSON.stringify(studentData)}`);
    }

}