package classes.designpatterns.behavioral.template;

public class Basketball extends Game{
    @Override
    void initialize() {
        System.out.println("Initialized Basketball Game.");
    }

    @Override
    void startPlay() {
        System.out.println("Basketball Game Started.");
    }

    @Override
    void endPlay() {
        System.out.println("Basketball Game Ended.");
    }
}
