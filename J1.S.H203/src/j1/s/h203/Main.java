package j1.s.h203;

import java.util.Scanner;

public class Main {

    public static String getString(String msg, boolean isLoop) {
        Scanner sc = new Scanner(System.in);
        String result = null;

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

    public static String printReverse(String string) {
        String str = "", str1 = "";
        String[] words = string.trim().split("\\s+");
        for (int i = words.length - 1; i >= 0; i--) {
            str += (words[i] + " ");
        }

        String[] words1 = str.trim().split("\\s+");

        for (int i = 0; i < words1.length; i++) {
            if (words[i].endsWith(".") || words[i].endsWith("?")
                    || words[i].endsWith("!") || words[i].endsWith(";") || words[i].endsWith(",")) {
                if (words1[i].endsWith(".") || words1[i].endsWith("?")
                        || words1[i].endsWith("!") || words1[i].endsWith(";") || words1[i].endsWith(",")) {
                    words1[i] = words1[i].substring(0, words1[i].length() - 1) + words[i].charAt(words[i].length() - 1);
                } else {
                    words1[i] = words1[i] + words[i].charAt(words[i].length() - 1);
                }
            }
        }

        str = "";
        for (int i = 0; i < words1.length; i++) {
            if (i == 0) {
                words1[i] = words1[i].substring(0, 1).toUpperCase() + words1[i].substring(1, words1[i].length());
            }
            if (words1[i].endsWith(".") || words1[i].endsWith("?")
                    || words1[i].endsWith("!")) {
                words1[i + 1] = words1[i + 1].substring(0, 1).toUpperCase() + words1[i + 1].substring(1, words1[i + 1].length());
            }
            str += (words1[i] + " ");
        }

        return str.trim();
    }

    public static void main(String[] args) {
        String str = "";
        str = getString("Input a not-empty String: ", str.isEmpty() == true);
        System.out.println("The reverse of the string is : " + printReverse(str));
    }
}
