package State;

public class Bishop extends PieceState {

    @Override
    public boolean canBeMovedTo(int xOrigin, int yOrigin, int xDestination, int yDestination) {

        return (destinationIsInTheBoard(xDestination, yDestination)
                && diagonalMovement(xOrigin, yOrigin, xDestination, yDestination)
        );
    }
}
