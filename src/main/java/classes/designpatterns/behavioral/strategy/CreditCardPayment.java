package classes.designpatterns.behavioral.strategy;

public class CreditCardPayment implements PaymentStrategy{
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using CreditCard.");
    }
}
