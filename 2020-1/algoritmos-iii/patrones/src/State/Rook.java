package State;

public class Rook extends PieceState {


    @Override
    public boolean canBeMovedTo(int xOrigin, int yOrigin, int xDestination, int yDestination) {

        return (destinationIsInTheBoard(xDestination, yDestination)
                && (verticalMovement(xOrigin, xDestination) || horizontalMovement(yOrigin, yDestination)));
    }
}
