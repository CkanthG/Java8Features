package classes.designpatterns.behavioral.observer;

public class ObserverDesignPattern implements Observer{
    private String name;

    public ObserverDesignPattern(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println(name + " received messge : " + message);
    }

    public static void main(String[] args) {
        Subject subject = new Subject();

        Observer observer1 = new ObserverDesignPattern("Observer1");
        Observer observer2 = new ObserverDesignPattern("Observer2");

        subject.attach(observer1);
        subject.attach(observer2);

        subject.sendMessage("Hello, Observers! How are you today!");
    }
}
