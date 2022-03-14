
import java.util.Scanner;

public class Main {

    static int checkInt(int min, int max) {
        Scanner sc = new Scanner(System.in);
        int ret = 0;
        String input = "";
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

    static int[] input() {
        System.out.print("Enter size of array: ");
        int size;
        while (true) {
            size = checkInt(1, Integer.MAX_VALUE);
            if (size % 2 == 0) {
                break;
            }
            System.out.println("Size must be even number!");
        }
        int[] elementData = new int[size];
        for (int i = 0; i < elementData.length; i++) {
            System.out.printf("Arr[%d] = ", i);
            if (i % 2 != 0) {
                elementData[i] = checkInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
            } else {
                elementData[i] = checkInt(0, Integer.MAX_VALUE);
            }
            System.out.println("");
        }
        return elementData;
    }

    public static void main(String[] args) {
        int[] elementData = input();
        ArrayIntList list = new ArrayIntList(elementData, elementData.length);
        ArrayIntList list2 = list.fromCount();
        System.out.println(list2.toString());
    }

}
