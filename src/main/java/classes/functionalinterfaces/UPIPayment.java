package classes.functionalinterfaces;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@FunctionalInterface
public interface UPIPayment {
    String doPayment(String source, String dest);

    default double getScratchCard() {
        return new Random().nextDouble();
    }

    static String datePatterns(String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(new Date());
    }
}
