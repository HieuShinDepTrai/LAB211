package j1.s.p0001;

import java.util.Scanner;

public class ValidateInput {

    Scanner sc = new Scanner(System.in);

    int CheckInt(String Mess, int Min, int Max) {
        int ret = 0;
        String input = "";
        do {
            System.out.print(Mess);
            try {
                input = sc.nextLine();
                ret = Integer.parseInt(input);
                if (ret >= Min && ret <= Max) {
                    break;
                }
                System.out.println("Out of range, please enter in range: " + Min + " - " + Max + ")");
            } catch (Exception e) {
                if (input.matches("\\-?\\d*")) {
                    System.out.println("Out of range of integer number");
                } else {
                    System.out.println("Invalid number input, please enter an integer number only");
                }
            }
        } while (true);
        return ret;
    }
}
