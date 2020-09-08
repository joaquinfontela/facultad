package State;

public class ChessPiece {

    private PieceState state;
    int posX;
    int posY;

    public ChessPiece(PieceState initialState, int posX, int posY) {

        state = initialState;
        this.posX = posX;
        this.posY = posY;
        showCoordinates();
    }

    public void moveTo(int newPosX, int newPosY) {

        if (state.canBeMovedTo(posX, posY, newPosX, newPosY)){

            posX = newPosX;
            posY = newPosY;
        }

        showCoordinates();
    }

    public void changeState(PieceState newState) {

        state = newState;
    }

    private void showCoordinates() {

        System.out.println("( " + posX + ", " + posY + " )");
    }
}
