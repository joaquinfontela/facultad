package Observer;

public interface Observable {

    void addObserver(Observer o);

    void notifyAllObservers();
}
