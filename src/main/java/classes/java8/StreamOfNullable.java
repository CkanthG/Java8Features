package classes.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This class is used to handle null values inside a stream, this feature was introduced in java9
 */
public class StreamOfNullable {

    /**
     * This method is used to handle null values inside a stream.
     */
    public void streamOfNullable() {
        List<String> strings = Arrays.asList("Sree", "Dev", null, "Sow", null);
        List<String> streamList = strings.stream()
                .flatMap(Stream::ofNullable)
                .collect(Collectors.toList());
        System.out.println(streamList);
    }
}
