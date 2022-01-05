/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.h208;

import java.util.Scanner;

/**
 *
 * @author lanh0
 */
public class J1SH208 {
    private static final Scanner scanner = new Scanner(System.in);

    public static int checkNumber() {
        int number;
        while (true) {
            try {
                number = Integer.parseInt(scanner.nextLine().trim()); 
                if(number < 0) System.out.println("Please input number >= 0");
                else  break;
            } catch (Exception e) {
                System.out.println("Invalid number, please enter again! ");

            }
        }
        return number;
    }
    // lẻ 34526 35462  chẵn 345621 -> 436521
    public static int swapDigitPairs(int number) {
        int numberswap = 0;
        int count = 0;
        while(number > 0){ 
            int number1 = number %10;   //34526 -> swap :( 6*10+2 )*10^0
            number = number / 10;   // number : 345 -> swap = 62 + 54*10^2
            if(number == 0){     // number = 3  -> 10^4*3 + 5462 -> 35463
                numberswap += Math.pow(10, count)*number1;
                break;
            }
            int number2 = number %10;
            number = number /10;
            numberswap  += (number1*10 + number2)*Math.pow(10, count);
            count += 2;
        }
        return numberswap;
    }
    public static void main(String[] args) {
        int number = checkNumber();
        System.out.println(swapDigitPairs(number));
    }

}
