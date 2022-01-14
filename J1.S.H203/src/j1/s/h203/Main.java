package j1.s.h203;

import java.util.Arrays;
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
        String str = "";
        String[] src = string.split("\\s+"); 
        
        for (int i = src.length - 1; i >= 0; i--) {
            str += src[i] + " ";
        }
        
        String[] src1 = str.split("\\s+"); 
        
        str = "";
        
        for (int i = 0; i < src1.length; i++) {
            if(src1[i].endsWith(".")) {
                src1[i] = src1[i].substring(0, src1[i].length() - 1);
            }
            if (src[i].charAt(src[i].length()-1) == '.') {
                src1[i] = src1[i] + src[i].charAt(src[i].length()-1);
            }
            
            src1[i] = src1[i].substring(0, 1).toUpperCase() + src1[i].substring(1).toLowerCase();
            str += src1[i] + " ";
        }
        return str.trim();
    }

    public static void main(String[] args) {
        String str = "";
        str = getString("Input a not-empty String: ", str.isEmpty() == true);
        System.out.println("The reverse of the string is: " + printReverse(str));
    }
}
