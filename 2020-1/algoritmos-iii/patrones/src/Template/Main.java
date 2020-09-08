package Template;

public class Main {

    public static void main(String[] args) {

        Game footballGame = new FootballGame("Barcelona", "Manchester United");
        Game tennisGame = new TennisGame("Federer", "Nadal");

        footballGame.simulate();
        tennisGame.simulate();
    }
}
