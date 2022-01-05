/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.P0011;

import java.util.Scanner;

/**
 *
 * @author lanh
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        do {
            int fromRadix = Convert.inputRadix("Input from radix: ");
            int toRadix = Convert.inputRadix("Input to radix: ");
            String number = Convert.inputNumber("Input number: ", fromRadix);
            System.out.println("Output number: " + Convert.convertBignumber(number, fromRadix, toRadix));
        } while (inputYesNo("Do u want to continue? (Y/N): ") == true);
    }

    public static boolean inputYesNo(String message) {
        String c;
        System.out.print(message);
        Scanner sc = new Scanner(System.in);
        c = sc.nextLine();
        if (c.equalsIgnoreCase("y") || c.equalsIgnoreCase("yes")) {
            return true;
        } else if (c.equalsIgnoreCase("n") || c.equalsIgnoreCase("no")) {
            return false;
        } else {
            System.out.println("Please input Y or N!");
            return inputYesNo(message);
        }
    }
    
}
