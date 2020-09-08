package Proxy;

public class Main {

    public static void main(String[] args){

        StudentsDatabaseProxy db = new StudentsDatabaseProxy(new StudentsDatabase());

        ProfessorUser professorUser = new ProfessorUser();
        StudentUser studentUser = new StudentUser();

        db.connect(studentUser);
        db.showMarks();

        db.connect(professorUser);
        db.showMarks();
    }
}
