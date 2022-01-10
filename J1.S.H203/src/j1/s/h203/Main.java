package j1.s.h203;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static String getString(String msg, boolean isLoop) {
        String result = "";

        do {
            System.out.print(msg);

            try {
                result = sc.nextLine();
                if (result.trim().isEmpty()) {
                    System.err.println("You must enter a not empty string");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.err.println("You must enter a string");
            }
        } while (isLoop);

        return result;
    }

    public static String toSentence(String s) {
        int len = s.length();
        if (len == 0) {
            return "";
        }

        return Character.toUpperCase(s.charAt(0)) + (len == 1 ? "" : s.toLowerCase().substring(1));
    }

    public static void printReverse(String s) {
        final String NGAT_CAU = ".?!;";

        String[] sentences = s.split("[" + NGAT_CAU + "]\\s*");
        ArrayList<Character> abc = new ArrayList<>();

        for (Character c : s.toCharArray()) {
            //c.toString().matches("[.?!;]")
            if (NGAT_CAU.contains(c.toString())) {
                abc.add(c);
            }
        }

        int i = sentences.length - 1;
        int j = abc.size() - 1;

        if (s.endsWith(sentences[sentences.length - 1])) {
            // chữ trước
            while (i >= 0 || j >= 0) {
                if (i >= 0) {
                    System.out.print(toSentence(sentences[i].trim()));
                }

                if (j >= 0) {
                    System.out.print(abc.get(j) + " ");
                }

                i--;
                j--;
            }
        } else {
            // dấu trước 
            while (i >= 0 || j >= 0) {
                if (j >= 0) {
                    System.out.print(abc.get(j) + " ");
                }

                if (i >= 0) {
                    System.out.print(toSentence(sentences[i].trim()));
                }

                i--;
                j--;
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = "";
        s = getString("Enter a String: ", s.isEmpty() == true);
        printReverse(s);
    }

}
