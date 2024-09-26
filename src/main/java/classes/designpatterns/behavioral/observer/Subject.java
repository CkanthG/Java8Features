package classes.designpatterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observers = new ArrayList<>();
    private String message;

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void sendMessage(String message) {
        this.message = message;
        notifyObservers();
    }
}
