package interview;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Demo {


    public static void main(String[] args) {
        //fizzBuzz();
        //ganarateRandomeNumber();
        //fizzBuzz8();
        margeList();
    }

    private static void margeList() {

        List<Integer> integers = Arrays.asList(1, 23, 3, 4, 5, 6, 7, 8, 89, 9);
        List<Character> characters = Arrays.asList('1', 'A', 's', 'N', 'q');

        Set<? extends Serializable> collected = Stream.of(integers, characters).flatMap(e -> e.stream()).collect(Collectors.toSet());

        System.out.println(collected);

    }

    private static void fizzBuzz8() {
        IntStream.iterate(1, i -> i + 1).limit(15).mapToObj(i -> i).map(i -> {
            if (i % 3 == 0 & i % 5 == 0) {
                return "fizzBuzz";
            } else if (i % 3 == 0) {
                return "fizz";
            } else if (i % 5 == 0) {
                return "Buzz";
            }
            return i;
        }).forEach(System.out::println);
    }

    private static void ganarateRandomeNumber() {
        List<Integer> list = IntStream.generate(() -> (int) (Math.random() * 3)).limit(10).mapToObj(n -> n).toList();
        System.out.println(list);

    }

    private static void fizzBuzz() {

        for (int i = 1; i <= 15; i++) {

            if (i % 3 == 0 & i % 5 == 0) {
                System.out.println("fizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }

        }
    }
}
