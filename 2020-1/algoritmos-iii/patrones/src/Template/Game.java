package Template;

public abstract class Game {

    String entity1;
    String entity2;
    boolean playing;

    public Game(String entity1, String entity2) {

        this.entity1 = entity1;
        this.entity2 = entity2;
    }

    private void start() throws InterruptedException {

        playing = true;
        Thread.sleep(5000);
        playing = false;
        System.out.println("GAME FINISHED");
    }

    protected abstract void showResults();

    public void simulate() {

        try {
            start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        showResults(); // template pattern is applied here, as the results depend on subclasses.
    }

}
