package classes.corejava;


import classes.models.Message;

import static java.lang.System.*;

public class NotifyProgram implements Runnable{
    final Message message;

    NotifyProgram(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        out.println(name+" started");

        try {
            Thread.sleep(2000);
            synchronized (message) {
                message.setMsg(name+" Notifier work done");
                message.notifyAll();
            }
        } catch (InterruptedException e) {
            err.println("Exception : " + e.getMessage());
        }
    }
}
