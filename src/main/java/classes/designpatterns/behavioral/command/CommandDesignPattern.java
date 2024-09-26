package classes.designpatterns.behavioral.command;

public class CommandDesignPattern {
    public static void main(String[] args) {
        Light light = new Light();
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);

        RemoteControl remote = new RemoteControl();
        remote.setCommand(lightOnCommand);
        remote.pressButton();
        remote.setCommand(lightOffCommand);
        remote.pressButton();
    }
}
