package classes.corejava;

public class FibonnociSeries {

    public void printFibonocci(int num) {
        int a,b=0;
        int c=1;
        for (int i=0;i<num;i++) {
            a = b;
            b = c;
            c = a + b;
            System.out.print(a + " ");
        }
    }

    public static void main(String[] args) {
        new FibonnociSeries().printFibonocci(10);
    }
}
