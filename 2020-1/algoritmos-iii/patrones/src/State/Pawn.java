package State;

public class Pawn extends PieceState {

    @Override
    public boolean canBeMovedTo(int xOrigin, int yOrigin, int xDestination, int yDestination) {

        return (destinationIsInTheBoard(xDestination, yDestination) && (xOrigin == xDestination)
                && (yOrigin + 1 == yDestination));
    }
}
