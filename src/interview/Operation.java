package interview;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Operation {

    public static void addingTwoList() {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> list2 = Arrays.asList(7, 5, 4, 3, 0, 2, 1);

        List<Integer> collect = Stream.of(list1, list2).flatMap(e -> e.stream()).collect(Collectors.toList());

        System.out.println(collect);
    }

    public static void findFeqOfStringChar() {
        String string = "AppleIsSweet";
        Map<Character, Long> feqChar = string.toLowerCase().chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println(feqChar);

        //count special given char
        long count = string.toLowerCase().chars().mapToObj(c -> (char) c).filter(c -> c == 'e').count();
        System.out.println("count char: " + count);

        //find first repeated number
        char findFist = string.toLowerCase().chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting())).entrySet().stream().map(c -> c.getKey()).findFirst().get();

        System.out.println(findFist);

        //Sort char
        string.toLowerCase().chars().mapToObj(e -> (char) e).sorted((e1, e2) -> e2.compareTo(e1)).forEach((e) -> System.out.print(e));
        //or
        string.toLowerCase().chars().mapToObj(e -> (char) e);

    }

    public static void printPattern() {
        int row, i, j, space = 1;
        System.out.print("Enter the number of rows you want to print: ");
        Scanner sc = new Scanner(System.in);
        row = sc.nextInt();
        space = row - 1;
        for (j = 1; j <= row; j++) {
            for (i = 1; i <= space; i++) {
                System.out.print(" ");
            }
            space--;
            for (i = 1; i <= 2 * j - 1; i++) {
                System.out.print(j);
            }
            System.out.println();
        }
        space = 1;
        for (j = 1; j <= row - 1; j++) {
            for (i = 1; i <= space; i++) {
                System.out.print(" ");
            }
            space++;
            for (i = 1; i <= 2 * (row - j) - 1; i++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static boolean armStrongNumber(int n) {
        //todo I want to print 1 to 25000 armString number
        int originalNumber = n;
        int result = 0;
        int length = String.valueOf(n).length();
        while (n != 0) {
            int number = n % 10;//last disit
            result += Math.pow(number, length);
            n /= 10;
        }
        return result == originalNumber;

    }

    private static void printArmstrong() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter range to print: ");
        int number = sc.nextInt();
        for (int n = 1; n <= number; n++) {
            if (armStrongNumber(n)) {
                System.out.println(n);
            }
        }
    }


    // Method to print prime numbers in a given range
    public static void primeNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Range of Number: ");
        int range = sc.nextInt();

        System.out.println("Prime numbers up to " + range + ":");
        for (int i = 2; i <= range; i++) {
            if (checkPrimeNumber(i)) {
                System.out.println(i);
            }
        }
    }

    // Method to check if a number is prime
    private static boolean checkPrimeNumber(int number) {
        if (number <= 1) return false;// 1 and lower are not prime
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false; // If divisible by any number other than 1 and itself
            }
        }
        return true;
    }

    //todo : find palindrome number to given rang number
    public static boolean checkPalindrome(int number) {
        int originalNumber = number;
        int palindrome = 0;
        while (number != 0) {
            int lastDisitNumber = number % 10;
            palindrome =  palindrome*10+lastDisitNumber;
            number /= 10;
        }
        return originalNumber == palindrome;
    }

    private static void palindrome() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter range of number: ");
        int n = sc.nextInt();
        for (int i = 11; i <= n; i++) {
            if (checkPalindrome(i)) {
                System.out.print(i+" ");
            }
        }
    }



    public static void main(String[] args) {
        //addingTwoList();
        //findFeqOfStringChar();
        //printPattern();
        primeNumber();
        palindrome();


    }
}
