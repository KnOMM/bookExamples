package functionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,3,4,5,2));

        // anonymous class example
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        };
        list.sort(comparator);
        System.out.println(list);

        // lambda expression - an anonymous function that takes in parameters and returns a value. Doesn't require a name
        int sum = list.stream().reduce(0,(a,b) -> a + b);
        int sum2 = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);
    }
}
