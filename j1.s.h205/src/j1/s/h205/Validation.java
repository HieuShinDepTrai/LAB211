
package j1.s.h205;

import java.util.Scanner;

public class Validation {
    public static Scanner sc = new Scanner(System.in);
    
    public static double inputDouble(String msg, double min, double max){
        double ret = 0;
        String input = "";
        System.out.print(msg);
        do {
            try {
                input = sc.nextLine();
                ret = Double.parseDouble(input.trim());
                if (ret >= min && ret <= max) {
                    break;
                }
            } catch (NumberFormatException e) {
                    System.out.println("Invalid number input, please enter an double number only");
            }
        } while (true);
        return ret;
    }
    
    public static int inputInt(String msg, int min, int max){
        int ret = 0;
        String input = "";
        System.out.print(msg);
        do {
            try {
                input = sc.nextLine();
                ret = Integer.parseInt(input.trim());
                if (ret >= min && ret <= max) {
                    break;
                }
                System.out.println("Out of range, please enter in range: " + "(" + min + " - " + max + ")");
            } catch (NumberFormatException e) {
                if (input.matches("\\-?\\d+")) {
                    System.out.println("Out of range of integer number");
                } else {
                    System.out.println("Invalid number input, please enter an integer number only");
                }
            }
        } while (true);
        return ret;
    }
}
