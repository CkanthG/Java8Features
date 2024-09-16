package classes.java8;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@FunctionalInterface
public interface UPIInterface {

    String doPayment(String source, String dest);

    default double getScratchCard() {
        return new Random().nextDouble();
    }

    static String datePattern(String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(new Date());
    }
}
