package State;

public class Knight extends PieceState {

    @Override
    public boolean canBeMovedTo(int xOrigin, int yOrigin, int xDestination, int yDestination) {

        return (destinationIsInTheBoard(xDestination, yDestination)
                && ((Math.abs(xDestination - xOrigin) == 2) && (Math.abs(yDestination - yOrigin) == 1))
                   || ((Math.abs(xDestination - xOrigin) == 1) && (Math.abs(yDestination - yOrigin) == 2)));
    }
}
