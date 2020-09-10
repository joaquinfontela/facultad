package State;

public class King extends PieceState {

    @Override
    public boolean canBeMovedTo(int xOrigin, int yOrigin, int xDestination, int yDestination) {

        return (destinationIsInTheBoard(xDestination, yDestination)
                && (horizontalMovement(yOrigin, yDestination)
                    || verticalMovement(xOrigin, xDestination)
                    || diagonalMovement(xOrigin, yOrigin, xDestination, yDestination))
                && (movementLengthEqualsOne(xOrigin, yOrigin, xDestination, yDestination))
        );
    }
}
