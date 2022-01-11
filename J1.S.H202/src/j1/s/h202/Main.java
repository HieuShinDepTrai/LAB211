package j1.s.h202;

import java.util.Scanner;

public class Main {

//    public static void clearBuffer() {
//        sc = new Scanner(System.in);
//    }
//    public static String getString(String msg, boolean isLoop) {
//        String result = null;
//
//        do {
//            System.out.print(msg);
//            clearBuffer();
//
//            try {
//                result = sc.nextLine();
//                if (result.trim().isEmpty()) {
//                    System.err.println("You must enter a not empty string");
//                } else {
//                    break;
//                }
//            } catch (Exception e) {
//                System.err.println("You must enter a string");
//            }
//        } while (isLoop);
//
//        return result;
//    }
    public static String printReverse(String S) {
        String result = "";
        for (int i = S.length() - 1; i >= 0; i--) {
            result += S.charAt(i);
        }
        return result;
//        StringBuilder str = new StringBuilder(S);
////        System.out.println(str.reverse());
//        return str.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = "";
//        s = getString("Enter a String: ", s.isEmpty() == true);
        System.out.print("Enter a String: ");
        s = sc.nextLine();
        if (s.trim().isEmpty()) {
            return;
        }
        System.out.println(printReverse(s));
    }

}
