package streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<String> stream1 = Stream.generate(() -> "abc").limit(50);
        Stream<String> stream2 = Stream.iterate("abc", (i) -> i).limit(2);
        System.out.println(stream1.collect(Collectors.toList()));
        System.out.println(stream2.collect(Collectors.toList()));


        Stream<Integer> intStream = Stream.of(1, 2, 3, 4);
        List<Integer> intList = intStream.collect(Collectors.toList());
        System.out.println(intList); //prints [1, 2, 3, 4]

        intStream = Stream.of(1, 2, 3, 4); //stream is closed, so we need to create it again
        Map<Integer, Integer> intMap = intStream.collect(Collectors.toMap(i -> i, i -> i + 10));
        System.out.println(intMap); //prints {1=11, 2=12, 3=13, 4=14}


        Stream<List<String>> namesOriginalList = Stream.of(
                List.of("Pankaj"),
                Arrays.asList("David", "Lisa"),
                List.of("Amit"));
//flat the stream from List<String> to String stream
        Stream<String> flatStream = namesOriginalList
                .flatMap(Collection::stream);

        flatStream.forEach(System.out::println);

        Stream<List<Integer>> streamListInt = Stream.of(
                Arrays.asList(1,2,3),
                Arrays.asList(5,2),
                Arrays.asList(1,10));
//        streamListInt.forEach(System.out::println);
        Stream<Integer> streamInt = streamListInt
                .flatMap(Collection::stream)
                .sorted(Comparator.reverseOrder()).reduce((a,b)-> a*b).stream();
        streamInt.forEach(System.out::println);
    }
}
