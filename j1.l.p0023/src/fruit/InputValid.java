/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruit;

import java.util.Scanner;

/**
 *
 * @author lanh0
 */
public class InputValid {

    private static final Scanner scanner = new Scanner(System.in);

    public static int checkInputRange(String mess, int min, int max) {
        int num;
        do {
            System.out.print(mess);
            try {
                num = Integer.parseInt(scanner.nextLine());
                if (num >= min && num <= max && min<=max) {
                    break;
                } else {
                    System.out.println("Out of range, plz enter in range (from " + min + " to " + max + ")");
                }
            } catch (Exception e) {
                System.out.println("Invalid input, accept integer number only!");
            }
        } while (true);
        return num;
    }

    public static String checkInputString(String mess) {
        while (true) {
            System.out.print(mess);
            String string = scanner.nextLine().trim();
            if (string.isEmpty()) {
                System.out.println("No enter empty, enter again");
            } else {
                return string;
            }
        }
    }

    public static double checkInputDouble(String mess) {
        double num;
        do {
            System.out.print(mess);
            try {
                num = Double.parseDouble(scanner.nextLine());
                if (num >= 0) {
                    break;
                } else {
                    System.out.println("Out of range, plz enter positive double number ");
                }
            } catch (Exception e) {
                System.out.println("Invalid input, accept double number only!");
            }
        } while (true);
        return num;
    }

    public static int checkInputInteger(String mess) {
        int num;
        do {
            System.out.print(mess);
            try {
                num = Integer.parseInt(scanner.nextLine());
                if (num >= 0) {
                    break;
                } else {
                    System.out.println("Out of range, plz enter positive integer number ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, accept integer number only!");
            }
        } while (true);
        return num;
    }

    public static boolean checkInputYN(String mess, String y, String n) {
        do {
            System.out.print(mess);
            String choose = scanner.nextLine();
            if (choose.toLowerCase().equals(y)) {
                return true;
            }
            if (choose.toLowerCase().equals(n)) {
                return false;
            }
            System.out.println("Plz enter " + y + "/" + n + ": ");
        } while (true);
    }
    public static String checkInputID(String mess, String regex){
        String text;
        do {
            System.out.println(mess);
            text = scanner.nextLine();
            if (text.matches(regex)) {
                break;
            }
            System.out.println("Invalid input, plz reenter by following: '" + regex + "'");
        } while (true);
        return text;
    }
}
