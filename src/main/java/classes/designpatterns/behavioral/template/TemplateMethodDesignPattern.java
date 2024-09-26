package classes.designpatterns.behavioral.template;

public class TemplateMethodDesignPattern {
    public static void main(String[] args) {
        Game game = new Football();
        game.play();

        game = new Basketball();
        game.play();
    }
}
