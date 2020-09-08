package Template;

public class FootballGame extends Game {

    public FootballGame(String entity1, String entity2) {
        super(entity1, entity2);
    }

    @Override
    public void showResults() {

        System.out.println(entity1 + " " + Math.toIntExact((long) (Math.random() * 4)) +
                " - " + Math.toIntExact((long) (Math.random() * 4)) + " " + entity2);
    }
}
