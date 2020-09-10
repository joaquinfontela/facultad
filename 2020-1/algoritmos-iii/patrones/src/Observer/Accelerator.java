package Observer;

import java.util.ArrayList;

public class Accelerator implements Observable {

    private ArrayList<Observer> observers;
    private int secondsPressed;

    public Accelerator() {
        observers = new ArrayList<>();
        secondsPressed = 0;
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void notifyAllObservers() {
        observers.forEach( o -> o.update() );
    }

    public void press(int seconds) {
        secondsPressed = seconds;
        notifyAllObservers();
        secondsPressed = 0;
    }

    public int getSecondsPressed() {
        return secondsPressed;
    }
}
