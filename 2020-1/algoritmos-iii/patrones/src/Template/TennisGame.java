package Template;

public class TennisGame extends Game {

    public TennisGame(String entity1, String entity2) {
        super(entity1, entity2);
    }

    @Override
    public void showResults() {

        System.out.println(entity1 + " defeats " + entity2 + " 7-5 4-6 6-2.");
    }
}
