package classes;

import classes.corejava.IterateArrayList;
import classes.java7.FutureExample;
import classes.java8.*;
import classes.sample.EvenAndOddNumberPrintingUsingThreads;
import classes.sample.Printing1to100;
import classes.java7.PrintEvenOrOddUsingThread;
import classes.functionalinterfaces.Functions;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static classes.java8.HiddenFeaturesInCollections.*;
import static java.lang.System.*;

public class Java8Features {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<String> names = List.of("Alice", "Bob", "Charlie");
        names.stream()
                .peek(name -> out.println("Processing: " + name))
                .forEach(out::println);

        out.println("StreamOfNullable");
        new StreamOfNullable().streamOfNullable();
        out.println("StreamIterate");
        new StreamIterate().streamIterate();
        out.println("CollectorsCollectingAndThen");
        new CollectorsCollectingAndThen().collectingAndThen();
        out.println("StreamTakeWhileAndDropWhile");
        new StreamTakeWhileAndDropWhile().takeWhileAndDropWhile();
        out.println("CollectorsTeeing");
        new CollectorsTeeing().teeing();
        out.println("StreamConcat");
        new StreamConcat().concat();
        out.println("CollectorsPartitioningBy");
        new CollectorsPartitioningBy().partitioningBy();
        out.println("IntStreamRangeAndRangeClosed");
        new IntStreamRangeAndRangeClosed().rangeAndRangeClosed();
        out.println("ComparatorExample");
        new ComparatorExample().comparatorUse();
        out.println("IterateArrayList Class Invoked from Java8Features");
        IterateArrayList.main(args);
        out.println("IterateArrayList Class Executed Successfully");
        String paytmPayment = new Paytm().doPayment("Germany", "India");
        out.println(paytmPayment);
        String amazonPayment = new AmazonPay().doPayment("India", "Germany");
        out.println(amazonPayment);
        new MapOperations().userStreamMapOperations();
        new MapOperations().userStreamFlatMapOperations();
        new CountRepeatedChars().countRepeatedCharacters("sreekanth");
        new MapOperations().findHighestSalary();
        out.println("Java Collections Hidden Features Start");
        nCopies();
        frequency();
        disJoint();
        singleton();
        rotate();
        out.println("Java Collections Hidden Features End");
        out.println("Functions Class Invoked from Java8Features");
        Functions.main(args);
        out.println("FutureExample Class Invoked from Java8Features");
        FutureExample.main(args);
        out.println("PrintEvenOrOddUsingThread Class Invoked from Java8Features");
        PrintEvenOrOddUsingThread.main(args);
        out.println("Printing1to100 Class Invoked from Java8Features");
        Printing1to100.main(args);
        out.println("EvenAndOddNumberPrintingUsingThreads Class Invoked from Java8Features");
        EvenAndOddNumberPrintingUsingThreads.main(args);


    }


}
