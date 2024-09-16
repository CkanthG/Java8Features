package classes.java7;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);
        Future<List<Integer>> listFuture = service.submit(() -> {
            System.out.println("Thread Name : " + Thread.currentThread().getName());
//            System.out.println(10/0);
            return Arrays.asList(1, 2, 3, 4, 5);
        });
        List<Integer> list = listFuture.get();
        System.out.println(list);
    }
}
