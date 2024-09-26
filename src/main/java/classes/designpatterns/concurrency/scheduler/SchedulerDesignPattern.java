package classes.designpatterns.concurrency.scheduler;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class SchedulerDesignPattern extends TimerTask {
    public void run() {
        System.out.println("Task performed on : " + new Date());
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask timerTask = new SchedulerDesignPattern();
        timer.schedule(timerTask, 1000, 2000);
    }
}
