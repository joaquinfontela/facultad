import axios from 'axios'

export default class ApiHandler {

    async getStudentData(studentId: string) {
        return await axios.get(`http://localhost:2000/data/${studentId}`)
            .then(function (response) {
                return response.data;
            })
            .catch(function (error) {
                return error;
            });
    }

}