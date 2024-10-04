package interview;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class String4YearsSolution {

    private static void reverseWordInString(){
        String string="The sky is Blue";
        //todo: Blue is sky The
        String[] split = string.split(" ");
        for (int i = split.length-1; i >=0 ; i--) {
            System.out.print(split[i]+" ");
        }
        //Using Java 8
        List<String> stringList = Arrays.asList(string.split(" "));
        Collections.reverse(stringList);

        String reverseWord = stringList.stream().collect(Collectors.joining(" "));
        System.out.println("-> "+reverseWord);
    }

    //todo to check String is Anagrams
    private static void anagrams(){
        String string1="Listen";
        String string2="Silent";
        //remove extra space and convert LowerCase
        String lowerCase1 = string1.replaceAll("\\s", "").toLowerCase();
        String lowerCase2 = string2.replaceAll("\\s", "").toLowerCase();

        //check length is same or note both string
        if(lowerCase1.length()!=lowerCase2.length()){
            System.out.println("Both are not an Anagrams-----");
        }
        //change both String in charArrays
        char[] string1CharArray = lowerCase1.toCharArray();
        char[] string2CharArray = lowerCase2.toCharArray();

        //sort both arrays
        Arrays.sort(string1CharArray);
        Arrays.sort(string2CharArray);
        //Check both are equal or note

        boolean equals = Arrays.equals(string1CharArray, string2CharArray);
        System.out.println(equals);
        if(equals){
            System.out.println("Both String are Anagrams");
        }else {
            System.out.println("Both are not an Anagrams");
        }
        //Todo using java 8
        String collect = string1.replaceAll("\\s", "").toLowerCase()
                .chars()
                .mapToObj(c -> (char) c).sorted()
                .map(e -> e + "").collect(Collectors.joining(""));

        String collect1 = string2.replaceAll("\\s", "").toLowerCase()
                .chars()
                .mapToObj(c -> (char) c)
                .sorted().map(e -> e + "")
                .collect(Collectors.joining(""));

        System.out.println(collect1+"-------"+collect);

        if(collect1.equals(collect)){
            System.out.println("java 8: Both are anagrams");
        }else {
            System.out.println("java 8 Both are not an anagrams");
        }

    }
    private static void longestPalindromeInGivenString(){
        String string="babad";
    }
    private static void stringCompression(){
        String string="aabcccccdddd";
        //todo: output- a2b1c5d4
        String collect = string.replaceAll("\\s", "")
                .chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet()
                .stream()
                .map(e -> e.getKey() + "" + e.getValue())
                .collect(Collectors.joining(""));

        System.out.println(collect);

    }


    public static void main(String[] args) {
        //reverseWordInString();
        //anagrams();
        //stringCompression();
    }
}
