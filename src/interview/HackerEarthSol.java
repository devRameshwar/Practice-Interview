package interview;

import java.util.Optional;
import java.util.stream.Collectors;

public class HackerEarthSol {

    private static void findIndex() {
        String string = "Hello";//output is ll -2 index

        Character c1 = string.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet().stream().sorted((e1, e2) -> Math.toIntExact(e2.getValue() - e1.getValue()))
                .map(c -> c.getKey())
                .findFirst()
                .get();
        System.out.println(c1);
    }
    private static void palindromeString() {
        String string = "Nitin";
        char[] chars = string.toLowerCase().toCharArray();

        String reverseString="";
        for (int i = chars.length-1; i <=0 ; i--) {
            reverseString +=chars[i];
        }
        if(reverseString.equalsIgnoreCase(string)){
            System.out.println(string+ " is palindrome ");
        }else {
            System.out.println(string+" is not palindrome ");
        }

        String reverse = new StringBuffer(string.toLowerCase()).reverse().toString();
        System.out.println(reverse);

    }
    public static Optional<String> nullCheck( ){
        return  Optional.ofNullable(null);
    }

    public static void main(String[] args)   {
        //findIndex();
       // palindromeString();
        String string;
        string = nullCheck().orElse("getting Null pointer exception");

        System.out.println(string);
        System.out.println(new NullHandler().getMessage());
    }
}
class NullHandler extends NullPointerException{

    public String message;

    public NullHandler(String message) {
        System.out.println("Null pointer exception object created.");
        this.message = message;
    }
    public NullHandler( ) {
        System.out.println("Null pointer exception default method called.");
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
