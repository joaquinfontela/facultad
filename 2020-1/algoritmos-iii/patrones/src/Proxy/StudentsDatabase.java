package Proxy;

public class StudentsDatabase {

    private boolean connected;

    public StudentsDatabase() {
        connected = false;
    }

    public void connect() {
        connected = true;
    }

    public void showMarks() {

        if (connected) {
            System.out.println("Joaquin Fontela: 8");
            System.out.println("Other guy: 7");
            System.out.println("Fool guy: 2");
        } else {
            System.out.println("Database connection not found.");
        }
    }
}
