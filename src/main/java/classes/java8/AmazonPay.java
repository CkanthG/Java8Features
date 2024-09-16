package classes.java8;

public class AmazonPay implements UPIInterface{
    @Override
    public String doPayment(String source, String dest) {
        return "Transaction Was Done From "+source+" to "+dest;
    }
}
