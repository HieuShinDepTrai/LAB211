/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0057;

import java.util.Scanner;

/**
 *
 * @author lanh0
 */
public class CheckValidation {

    public static final Scanner scanner = new Scanner(System.in);

    public static int checkRange(String mess, int min, int max) {
        int num;
        do {
            System.out.print(mess);
            try {
                num = Integer.parseInt(scanner.nextLine());
                if (num >= min && num <= max) {
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

    public static String checkString(String mess, String regex, String messCondition) {
        String text;
        do {
            System.out.println(mess);
            text = scanner.nextLine();
            if (text.matches(regex)) {
                break;
            } else {
                System.out.println(messCondition);
            }
        } while (true);
        return text;
    }

}
