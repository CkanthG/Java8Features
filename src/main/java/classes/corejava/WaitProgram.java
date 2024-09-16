package classes.corejava;


import classes.models.Message;

import static java.lang.System.*;

public class WaitProgram implements Runnable{

    private final Message message;

    WaitProgram(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (message) {
            try {
                out.println(name+" waiting to get notified at time:"+ currentTimeMillis());
                message.wait();
            } catch (InterruptedException e) {
                err.println("Exception : " + e.getMessage());
            }
            out.println(name+" waiter thread got notified at time:"+ currentTimeMillis());
            //process the message now
            out.println(name+" processed: "+message.getMsg());
        }
    }
}
