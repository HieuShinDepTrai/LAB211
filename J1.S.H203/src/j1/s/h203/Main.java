package j1.s.h203;

import java.util.Scanner;

public class Main {

    public static String getString(String msg, boolean isLoop) {
        Scanner sc = new Scanner(System.in);
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

    public static void printReverse(String string) {
        String str = "";
        String[] src = string.split("\\s+");
        // nguyen van hieu. abc xyz? mzd
        // src : nguyen   van   hieu.    abc    xyz?    mzd
        for (int i = src.length - 1; i >= 0; i--) {
            str += src[i] + " ";
        }

        String[] src1 = str.split("\\s+");
        
        // src1: mzd    xyz?   abc   hieu.    van    nguyen

        str = "";
// nguyen van hieu. abc xyz? mzd
// nguyen | van | hieu. | abc | xyz? | mzd ----- src
// mzd | xyz? | abc | hieu. | van | nguyen   - src1
        for (int i = 0; i < src1.length; i++) {
            if (src1[i].endsWith(".") || src1[i].endsWith("?") || src1[i].endsWith("!")
                    || src1[i].endsWith(";") || src1[i].endsWith(",")) {
                src1[i] = src1[i].substring(0, src1[i].length() - 1);
            }
// mzd | xyz | abc | hieu | van | nguyen   - src1            
            if (src[i].endsWith(".") || src[i].endsWith("?") || src[i].endsWith("!") 
                    || src[i].endsWith(";") || src[i].endsWith(",")) {
                src1[i] = src1[i] + src[i].charAt(src[i].length() - 1);
            }
// mzd | xyz | abc. | hieu | van? | nguyen   - src1
            src1[i] = src1[i].toLowerCase();
        }
        src1[0] = src1[0].substring(0, 1).toUpperCase() + src1[0].substring(1);
        for (int i = 0; i < src1.length - 1; i++) {
            if (src1[i].endsWith(".") || src1[i].endsWith("?") || src1[i].endsWith("!")
                    || src1[i].endsWith(";")) {
                src1[i + 1] = src1[i + 1].substring(0, 1).toUpperCase() + src1[i + 1].substring(1).toLowerCase();
            }
        }
        for (int i = 0; i < src1.length; i++) {
            str += src1[i] + " ";
        }
        System.out.println(str.trim());
    }

    public static void main(String[] args) {
        String str = "";
        str = getString("Input a not-empty String: ", str.isEmpty() == true);
        System.out.print("The reversed string is: ");
        printReverse(str);
    }
}
