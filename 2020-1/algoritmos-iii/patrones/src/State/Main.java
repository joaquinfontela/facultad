package State;

public class Main {

    public static void main(String[] args) {

        ChessPiece myChessPiece = new ChessPiece(new Pawn(), 3, 2);
        
        myChessPiece.moveTo(3,3);
        myChessPiece.moveTo(3,4);
        myChessPiece.moveTo(3,3); //X
        myChessPiece.moveTo(2, 4); //X
        myChessPiece.moveTo(4,5); //X
        myChessPiece.moveTo(3,5);
        myChessPiece.moveTo(3,6);
        myChessPiece.moveTo(3, 7);
        myChessPiece.moveTo(3,8);
        myChessPiece.changeState(new Queen());
        myChessPiece.moveTo(7, 4);
        myChessPiece.moveTo(7,7);
        myChessPiece.moveTo(4,5); //X
    }
}

