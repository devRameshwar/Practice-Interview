package interview;

public class Pattern {

    public static void main(String[] args) {
        //pattern1();
        //pattern2();
        //pattern3();
        //pattern4();
        pattern5();
        pattern6();

    }

    private static void pattern6() {

    }

    private static void pattern5() {
        int n = 5;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print("\t");
            }
            for (int k = 1; k < i * 2; k++) {
                System.out.print("*" + "\t");
            }
            System.out.println();
        }
        for (int i = 4; i >= 0; i--) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print("\t");
            }
            for (int k = 1; k < i * 2; k++) {
                System.out.print("*" + "\t");
            }
            System.out.println();
        }
    }

    private static void pattern4() {
        int n = 5;
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("\t");
            }
            for (int j = 1; j < 2 * n - i; j++) {
                System.out.print("*" + "\t");
            }
            System.out.println();
        }
    }

    private static void pattern3() {
        int n = 5;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print("\t");
            }
            for (int j = 1; j < 2 * i; j++) {
                System.out.print("*" + "\t");
            }
            System.out.println();
        }
    }

    private static void pattern2() {
        int n = 5;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                System.out.print("*" + "\t");
            }
            System.out.println();
        }
    }

    private static void pattern1() {
        int n = 5;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*" + "\t");
            }
            System.out.println();
        }
    }
}
