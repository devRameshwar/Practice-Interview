package interview;

import java.util.Objects;

public class FibonacciSeries {

    public static void fibonacciSeries(int start, int range) {
        int a = 0, b = 1, next;

        //find first Fibonacci  number to start
        while (b < start) {
            next = a + b;
            a = b;
            b = next;
        }
        //print next count number Fibonacci  number
        System.out.print("Fibonacci series:");
        for (int i = 0; i < range; i++) {
            System.out.print(b + "\t");
            next = a + b;
            a = b;
            b = next;
        }
        System.out.println();
    }

    //check String is palendronate or not
    public static void palendrome(String string) {
        String temp = "";
        if (string.charAt(0) == string.charAt(string.length() - 1)) {
            for (int i = string.length() - 1; i >= 0; i--) {
                temp = temp + string.charAt(i);
                System.out.println("=====");
            }
            System.out.println(temp);
            System.out.println(temp == string);
            System.out.println(temp.equals(string));
            if (temp.equals(string)) {
                System.out.println("Given string Pallyndrome: " + temp);
            }
        } else {
            System.out.println("Not a pallyndrome: ");
        }
    }

    public static void palendrome1(String str) {
        if (new StringBuilder(str).reverse().toString().equals(str)) {
            System.out.println("Given string is a Palindrome: " + str);
        } else {
            System.out.println("Not a Palindrome: " + str);
        }
    }

    public static void main(String[] args) {
        //fibonacciSeries(3,8);
       // palendrome1("poop");

        Google google = new Google(101);

        System.out.println(google.getGoogleId());


    }
}
final class Google{
    private  final Integer googleId;

    public Google(Integer googleId) {
        this.googleId=googleId;
    }



    @Override
    public int hashCode() {
        return Objects.hashCode(googleId);
    }

    public Integer getGoogleId() {
        return googleId;
    }
}
