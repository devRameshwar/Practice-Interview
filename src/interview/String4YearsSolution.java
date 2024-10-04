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
    private static void RotationOfAnOtherString(){
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        if(s2.length()==s1.length() && s1.length()>0){
           String string= s1+s1;
           if(s1.contains(s2));
            System.out.println(s1+" is rotation of "+s2);
        }else {
            System.out.println(s1+" is not rotation of "+s2);
        }
    }

    //todo remove dublicate of a String
    private static void removedDoblicate(){
        String string="asdffdsaweasd";
        String collect = string.replaceAll("\\s", "").toLowerCase()
                .chars().mapToObj(e -> (char) e)
                .distinct().map(e -> e + "")
                .collect(Collectors.joining());
        System.out.println(collect);
    }

    //todo find first Non-repeated character
    private static void findNonRepeatedCharacter(){
        String string= "Swiss";
        //output: w
        Character c = string.replaceAll("\\s", "").toLowerCase()
                .chars().mapToObj(e -> (char) e).collect(Collectors.groupingBy(e -> e, Collectors.counting())).entrySet()
                .stream()
                .sorted((e1, e2) -> Math.toIntExact(e1.getValue() - e2.getValue())).map(e -> e.getKey()).findFirst().get();
        System.out.println(c);
    }
    private static void findFirstRepetedNumber(){
        String string="Swissi";
        string.replaceAll("\\s","").toLowerCase();
        for (int i = 0; i <string.length()-1; i++) {
            //System.out.println(string.charAt(i));
            for (int j = i+1; j <string.length()-1; j++) {
                if (string.charAt(i)==string.charAt(j)){
                    //System.out.print(string.charAt(i));
                    break;
                }
            }
        }
    }


    public static void main(String[] args) {
        //reverseWordInString();
        //anagrams();
        //stringCompression();
        //RotationOfAnOtherString();
        //removedDoblicate();
        //findNonRepeatedCharacter();
        findFirstRepetedNumber();
    }
}
