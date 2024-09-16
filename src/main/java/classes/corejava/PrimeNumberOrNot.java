package classes.corejava;

import static java.lang.System.*;

public class PrimeNumberOrNot {

    public void findPrimeNumber(int a) {
        int tmp;
        boolean isPrime = true;
        for(int i=2; i<a/2 ; i++) {
            out.println(i +" - "+a/2+" - "+(a%i));
            tmp = a % i;
            if (tmp == 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime) {
            out.println(a+" is prime number");
        } else {
            out.println(a+" is not prime number");
        }
    }
    public static void main(String[] args) {
        new PrimeNumberOrNot().findPrimeNumber(15);
    }
}
