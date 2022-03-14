
package j1.s.h208;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J1SH208 {

    public static int inputInt(String msg, int min, int max){
        Scanner sc = new Scanner(System.in);
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
    // lẻ 34526 35462  chẵn 345621 -> 436512
    public static int SwapDigitPair(int n) {

        List<Integer> list = new ArrayList<>(); 
        while (n != 0) {
            list.add(n % 10);
            n = n / 10;
        }
        // 1234567 7654321
//        System.out.println(list.toString());
        int s= list.size();
        // 7654321 
        // 6754321
        // 6745321
        // 6745231
        // 123456
        // 214365
        // 4234567
        for (int i = 0; i < s - 1; i += 2) {
            int tg = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, tg);
        }
//        System.out.println(list.toString());
        int x = 1;
        for (Integer item : list) {
            n += item * x;
            x *= 10;
        }
        // 6 7 4 5 2 3 1
        // 6
        // 76
        // 476
        // 1325476
        // 1325476
        return n;
    }
    public static void main(String[] args) {
        int number = inputInt("Enter an positive number: ", 1, Integer.MAX_VALUE);
        System.out.println(SwapDigitPair(number));
    }

}
