package classes.java8;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.*;

public class HiddenFeaturesInCollections {

    public static void nCopies() {
        out.println("Collections.nCopies() example");
        //Collections.nCopies() will produce a mutable list with given object, we can use it in generate test data.
        List<String> nCopies = Collections.nCopies(5, "Sreekanth");
        out.println(nCopies);
        try {
            nCopies.set(0, "Gaddoju");
        } catch (UnsupportedOperationException e) {
            out.println("List is immutable, it can't be modify");
        }
    }

    public static void frequency() {
        out.println("Collections.frequency() example");
        //Collections.frequency() will help you to find the element occurence in given list
        List<Integer> list = Arrays.asList(1,2,3,4,5,3,4);
        int frequency = Collections.frequency(list, 3);
        out.println("3 occurred "+frequency+ " times in a given list");
        List<String> stringList = Arrays.asList("abc", "bcd", "abc", "xyz", "abc");
        int strFrequency = Collections.frequency(stringList, "abc");
        out.println("abc occurred "+strFrequency+ " times in a given list");
        // find each character occurrence in given list
        Map<Integer, Integer> integerMap = list.stream().collect(Collectors.toMap(
                        it -> it,
                        it -> Collections.frequency(list, it),
                        (existingValue, newValue) -> existingValue
                )
        );
        out.println(integerMap);
    }

    public static void disJoint() {
        out.println("Collections.disJoint() example");
        //Collections.disJoint() will help to find out common element is given two list objects.
        List<Integer> list1 = Arrays.asList(1,2,3,4,5);
        List<Integer> list2 = Arrays.asList(6,7,8,9,10);
        boolean disjoint = Collections.disjoint(list1, list2);
        if (disjoint) {
            out.println("There is no common element");
        } else {
            out.println("There is a common element");
        }
    }

    public static void singleton() {
        out.println("Collections.singleton() example");
        // Collections.singleton will create a singleton immutable set object.
        Set<String> set = Collections.singleton("Sreekanth");
        out.println(set);
        try {
            set.add("Gaddoju");
        } catch (UnsupportedOperationException e) {
            out.println("Set is immutable, it can't be modify");
        }
    }

    public static void rotate() {
        out.println("Collections.rotate() example");
        //Collections.rotate() will rotate a list with left(negative distance) or right(positive distance) positions
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        out.println("Original List "+list);
        Collections.rotate(list, 2);
        out.println("Rotated List from Right : "+list);
        list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Collections.rotate(list, -3);
        out.println("Rotate List from Left : "+list);
        list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Collections.rotate(list, list.size());
        out.println("Rotate List by Its Size : "+list);
        list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Collections.rotate(list, -15);
        out.println("Rotate List by -15 : "+list);
    }
}
