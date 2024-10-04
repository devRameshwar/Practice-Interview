package interview;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringOperation {



    private static void pattern() {
        int n = 5;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    //todo: reverse of a String
    public static void reverseString() {
        String string = "Banana";
        String reverse = "";
        for (int i = string.length() - 1; i >= 0; i--) {
            reverse = reverse + string.charAt(i);
        }
        System.out.println(reverse);
        //Todo: Using java 8
        string.chars().mapToObj(c -> (char) c).forEach(c -> {
        });
        System.out.println();
    }

    private static void printNumber() {
        //List<Integer> list = IntStream.range(1, 100).mapToObj(e -> (int) e).filter(e -> e % 2 == 0).toList();
        //System.out.println(list);
        //IntStream.iterate(1, i -> i +1).limit(10).forEach(e->System.out.print(e+" "));

        List<Integer> list = IntStream.iterate(1, i -> i + 1).limit(100).mapToObj(e -> e).filter(i -> {
            int count = 1;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            return count == 2;
        }).toList();
        System.out.println(list);
    }

    //todo: print in between 2 to 500 armstrong number
    private static void printArmStrongNumber() {
        List<Integer> list = IntStream.iterate(2, i -> i + 1).limit(500).mapToObj(i -> i).filter(i -> {
            int number = i;
            int length = String.valueOf(i).length();
            int armStrongNumber = 0;
            while (i != 0) {
                int lastDisit = i % 10;
                armStrongNumber += Math.pow(lastDisit, length);
                i /= 10;
            }
            return armStrongNumber == number;
        }).toList();
        System.out.println(list);//[2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407]
    }

    //todo: finding long length of word in String
    private static void longWordInString() {
        String string = "Ram is a Good Boy in the Class";
        String first = Arrays.stream(string.split(" ")).sorted((e1, e2) -> e2.length() - e1.length()).findFirst().get();
        //String[] split = string.split(" ");
        System.out.println(first);

    }

    public static void main(String[] args) {
        //printArmStrongNumber();
        pattern();
        //longWordInString();
        //reverseString();
        //printNumber();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
        String string = "Hello";
        /*String string1="Hello";

        System.out.println(string.hashCode());
        System.out.println(string1.hashCode());

        System.out.println(string1);*/

        string.chars().mapToObj(e -> (char) e).sorted((e1, e2) -> e2 - e1).forEach(e -> System.out.print(e));
        Map<Character, Long> collect = string.toLowerCase().chars().mapToObj(e -> (char) e).collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        System.out.println(collect);

        Optional<Map.Entry<Character, Long>> first = string.toUpperCase().chars().mapToObj(e -> (char) e).collect(Collectors.groupingBy(e -> e, Collectors.counting())).entrySet().stream().sorted((e1, e2) -> Math.toIntExact(e2.getValue() - e1.getValue())).findFirst();
        System.out.println(first.get());


    }
}
