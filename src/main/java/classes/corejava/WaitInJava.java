package classes.corejava;

import static java.lang.System.*;

public class WaitInJava {
    private static final Object LOCK = new Object();

    public static void main(String[] args) {
        new WaitInJava().waitMethod();
    }
    public void waitMethod() {
        try {
            Thread.sleep(1000);
            out.println(
                    "Thread '" + Thread.currentThread().getName() +
                            "' is woken after sleeping for 1 second");
            synchronized (LOCK) {
                LOCK.wait(10000);
                out.println("Object '" + LOCK + "' is woken after" +
                        " waiting for 10 second");
            }
        } catch (InterruptedException e) {
            err.println("Exception : " + e.getMessage());
        }
    }
}
