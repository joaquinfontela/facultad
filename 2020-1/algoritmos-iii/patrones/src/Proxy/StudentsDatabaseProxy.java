package Proxy;

public class StudentsDatabaseProxy {

    private StudentsDatabase db;

    public StudentsDatabaseProxy(StudentsDatabase db) {
        this.db = db;
    }

    public void connect(User user) {

        if (user.getClass() == ProfessorUser.class) {
            db.connect();
        } else {
            System.out.println("YOU DON'T HAVE PERMITION TO ACCESS THE DATABASE.");
        }
    }

    public void showMarks() {
        db.showMarks();
    }
}
