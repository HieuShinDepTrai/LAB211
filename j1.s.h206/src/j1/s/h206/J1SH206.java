package j1.s.h206;

import java.util.Scanner;

public class J1SH206 {

    public static Scanner sc = new Scanner(System.in);

    public static int CheckInt(int Min, int Max) {
        int ret = 0;
        String input = "";
        do {
            try {
                input = sc.nextLine();
                ret = Integer.parseInt(input.trim());
                if (ret >= Min && ret <= Max) {
                    break;
                }
                System.out.println("Out of range, please enter in range: " + "(" + Min + " - " + Max + ")");
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

    public static void printSquare(int min, int max) {  
        // min=1 max=5
        // i = 1 j=1->5: 12345 |
        // i = 2 j=2->5: 2345 | 1
        // i = 3 j=3->5: 345 | 12
        // i = 4 j=4->5: 45 | 123
        // i = 5 j=5 : 5 | 1234
        
        // min=2 max=5
        // i = 2 j=2->5 : 2345 |
        // i = 3 j = 3 -> 5 : 345 | 2
        // i = 4 j = 4 -> 5: 45 | 23
        // i = 5 j = 5 : 5 | 234
        for (int i = min; i <= max; i++) {
            for (int j = i; j <= max; j++) {
                System.out.print(j);
            }
            for (int k = 0; k < i - min; k++) {
                System.out.print(min + k);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int min = CheckInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
        int max = CheckInt(min, Integer.MAX_VALUE);
        printSquare(min, max);
    }
}
