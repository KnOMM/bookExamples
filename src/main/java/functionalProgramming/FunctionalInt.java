package functionalProgramming;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@FunctionalInterface
interface Concatenator {
    String concat(String s1, String s2);
}

public class FunctionalInt {

    static Concatenator concatenator = ((s1, s2) -> s1 + s2); // anonymous function

    private static int sum(int a, int b) {
        System.out.printf("sumReferential: Adding %d and %d%n", a, b);
        return a + b;
    }

    private static int sumReferential(int a, int b) {
        return a + b;
    }

    public static int factorial(int n){
        if (n == 1) return 1;
        return n*factorial(n-1);
    }

    static Integer sum(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

    public static void main(String[] args) {
        //Concatenator concatenator = ((s1, s2) -> s1 + s2);
        System.out.println(concatenator.concat("a", "b"));

        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        Stream<Integer> stream = list.stream().filter(value -> { // lazy initialization
            System.out.println("checking " + value);
            return value % 2 == 0;
        });
        System.out.println("starting filtering...");
        System.out.println(stream.collect(Collectors.toList()));

        sumReferential(1, sumReferential(2, 3));
        sum(1, sum(2, 3));

        // Predicate examples (or, negate)
        Predicate<Integer> isDivisibleByTwo = value -> value % 2 == 0;
        Predicate<Integer> isDivisibleByFive = value -> value % 5 == 0;
        System.out.println("==and()==");
        Predicate<Integer> isDivisibleByTwoAndFive = isDivisibleByTwo.and(isDivisibleByFive);
        System.out.println("10 is divisible by 2 and 5: " + isDivisibleByTwoAndFive.test(10));
        System.out.println("4 is divisible by 2 and 5: " + isDivisibleByTwoAndFive.test(4));
        System.out.println("Tony equals Stark: " + Predicate.isEqual("Tony").test("Stark"));

        // Function examples
        Function<String, String> appendX = value -> value + "-X";
        Function<String, String> appendY = value -> value + "-Y";

        Function<String, String> appendXAndAppendY = appendX.andThen(appendY);
        Function<String, String> appendYAndAppendX = appendX.compose(appendY);
        System.out.println(appendXAndAppendY.apply("A"));
        System.out.println(appendYAndAppendX.apply("A"));

        // Monad example
        Optional<String> concat = Optional.of("A")
                .flatMap(value ->  Optional.of("B")
                        .flatMap(value2 -> Optional.of(value + value2)));
        System.out.println(concat.get());

        // Currying example
        Function<String, Function<String,String>> curried = a -> b -> a + b;
        System.out.println(curried.apply("A").apply("B"));

        // factorial
        System.out.println(factorial(5));


        // new sort
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 10, 0, -1, -20));
        numbers.sort(Comparator.naturalOrder());
        System.out.println(numbers);

        System.out.println(sum(numbers));
    }
}
