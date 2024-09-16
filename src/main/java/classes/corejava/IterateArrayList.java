package classes.corejava;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.lang.System.*;

public class IterateArrayList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("def");
        list.add("ghi");
        list.add("jkl");
        list.add("mnp");
        new IterateArrayList().findFibonocci(15);
        new IterateArrayList().primeNumber(15);
        new IterateArrayList().primeNumber(11);
        new IterateArrayList().iterateListWithWhile(list);
        new IterateArrayList().iterateListWithForLoop(list);
        new IterateArrayList().iterateListWithAdvancedForLoop(list);
    }
    public void iterateListWithAdvancedForLoop(List<String> list) {
        for (Object l : list) {
            out.println("iterateListWithAdvancedForLoop:" + l.toString());
        }
    }
    public void iterateListWithForLoop(List<String> list) {
        for(int i=0; i< list.size();i++) {
            out.println("iterateListWithForLoop:" + list.get(i));
        }
    }
    public void iterateListWithWhile(List<String> list) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            out.println("iterateListWithWhile:" + next);
        }
    }
    public void primeNumber(int num) {
        int n = 0;
        boolean flag = true;
        for (int i=2;i<num/2;i++) {
            n = num % i;
            if (n == 0) {
                flag = false;
                break;
            }
        }
        if(flag) {
            out.println(num + " is a prime number");
        } else {
            out.println(num + " is not a prime number");
        }
    }
    public void findFibonocci(int num) {
        int a,b=0;
        int c=1;
        out.print("finding Fibonocci number of : "+num+"  ->\t");
        for (int i=0;i<num;i++) {
            a=b;
            b=c;
            c=a+b;
            out.print(a + " ");
        }
        out.println();
    }
}
