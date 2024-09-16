package classes.functionalinterfaces;

import java.util.Random;

import static java.lang.System.*;

public class AmazonPay implements UPIPayment {
    @Override
    public String doPayment(String source, String dest) {
        String date = UPIPayment.datePatterns("yyyy-mm-dd");
        out.println("Date of transaction " + date);
        return "Successfully transaction done from "+source+" to "+dest+" on "+date;
    }

    @Override
    public double getScratchCard() {
        return new Random().nextDouble() + new Random().nextDouble();
    }
}
