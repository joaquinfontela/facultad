package Command;

public class Player {

    int xCoordinate;
    int yCoordinate;

    public Player(){

        xCoordinate = 0;
        yCoordinate = 0;
    }

    public void goUp() { yCoordinate++; showCoordinates(); }
    public void goDown() { yCoordinate--; showCoordinates(); }
    public void goRight() { xCoordinate++; showCoordinates(); }
    public void goLeft() { xCoordinate--; showCoordinates(); }

    private void showCoordinates() {

        System.out.println("( " + xCoordinate + ", " + yCoordinate + " )");
    }
}
