package classes.designpatterns.behavioral.strategy;

public class PaypalPayment implements PaymentStrategy{
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Paypal.");
    }
}
