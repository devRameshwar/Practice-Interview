package stringProblums;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class StringOperationClass {

    public static void main(String[] args) {

        //System.out.println("String Operation class..");
        //reverseString("Operation");
        //sortString("Operation");
        threadCreation();
       // executorService();
    }

    private static void executorService() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Thread(() -> {
            System.out.println("Thread is created....");
        }));
        //executorService.shutdown();


    }

    private static void threadCreation() {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread is created" + "\t" + i);
            }
            //System.out.println("Thread is created.");
        });
        thread.start();
    }

    private static void sortString(String string) {
        String sortedString = string.chars().mapToObj(s -> s).sorted((s1, s2) -> s2 - s1).map(s -> s + "  ").collect(Collectors.joining(""));

        System.out.println(sortedString);
    }

    private static void reverseString(String string) {
        String reverse = "";
        char[] chars = string.toUpperCase().toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            reverse = reverse + chars[i];
        }
        System.out.println("reverse String : " + reverse);
    }
}
