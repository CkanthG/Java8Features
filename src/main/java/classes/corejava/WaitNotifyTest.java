package classes.corejava;


import classes.models.Message;

public class WaitNotifyTest {
    public static void main(String[] args) {
        Message message = new Message("process it");
        WaitProgram waitProgram = new WaitProgram(message);
        new Thread(waitProgram, "waitProgram").start();

        WaitProgram waitProgram1 = new WaitProgram(message);
        new Thread(waitProgram1, "waitProgram1").start();

        NotifyProgram notifyProgram = new NotifyProgram(message);
        new Thread(notifyProgram, "notifyProgram").start();
    }
}
