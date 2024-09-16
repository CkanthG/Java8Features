package classes.functionalinterfaces;

public class Paytm implements UPIPayment {
    @Override
    public String doPayment(String source, String dest) {
        String date = UPIPayment.datePatterns("yyyy-mm-dd");
        System.out.println("Date of transaction " + date);
        return "Successfully transaction done from "+source+" to "+dest+" on "+date;
    }

    @Override
    public double getScratchCard() {
        return UPIPayment.super.getScratchCard();
    }
}
