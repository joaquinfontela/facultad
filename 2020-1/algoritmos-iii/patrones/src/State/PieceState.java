package State;

public abstract class PieceState {

    public abstract boolean canBeMovedTo(int xOrigin, int yOrigin, int xDestination, int yDestination);

    protected boolean destinationIsInTheBoard(int xDestination, int yDestination) {

        return ((1 <= xDestination) && (xDestination <= 8) && (1 <= yDestination) && (yDestination <= 8));
    }

    protected boolean verticalMovement(int xOrigin, int xDestination) {

        return (xOrigin == xDestination);
    }

    protected boolean horizontalMovement(int yOrigin, int yDestination) {

        return (yOrigin == yDestination);
    }

    protected boolean diagonalMovement(int xOrigin, int yOrigin, int xDestination, int yDestination) {

        return (Math.abs(xDestination - xOrigin) == Math.abs(yDestination - yOrigin));
    }

    protected boolean movementLengthEqualsOne(int xOrigin, int yOrigin, int xDestination, int yDestination) {

        return ((Math.sqrt(
                Math.pow(Math.abs(xDestination - xOrigin), 2) + Math.pow(Math.abs(yDestination - yOrigin), 2))
        ) == 1);
    }
}
