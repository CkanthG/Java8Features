package classes.designpatterns.behavioral.template;

public abstract class Game {
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    // template definition
    public final void play() {
        initialize();
        startPlay();
        endPlay();
    }
}
