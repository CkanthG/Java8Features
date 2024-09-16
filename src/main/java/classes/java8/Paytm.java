package classes.java8;

public class Paytm implements UPIInterface{
    @Override
    public String doPayment(String source, String dest) {
        String transactionDate = UPIInterface.datePattern("MM-dd-YYYY");
        return "Transaction Was Done From "+source+" to "+dest+" on "+transactionDate;
    }

    @Override
    public double getScratchCard() {
        return UPIInterface.super.getScratchCard();
    }
}
