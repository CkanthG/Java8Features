package classes.designpatterns.behavioral.strategy;

public class StrategyDesignPattern {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        paymentStrategy.pay(amount);
    }

    public static void main(String[] args) {
        StrategyDesignPattern strategyDesignPattern = new StrategyDesignPattern();
        strategyDesignPattern.setPaymentStrategy(new CreditCardPayment());
        strategyDesignPattern.checkout(1000);

        strategyDesignPattern.setPaymentStrategy(new PaypalPayment());
        strategyDesignPattern.checkout(2000);
    }
}
