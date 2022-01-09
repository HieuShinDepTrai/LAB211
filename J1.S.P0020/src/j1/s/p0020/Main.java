package j1.s.p0020;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        ValidateInput IntegerNumber = new ValidateInput();

        int n = IntegerNumber.CheckInt("Enter number of array: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        int[] a = new int[n];
        
        for (int i = 0; i < n; i++) {
            a[i] = IntegerNumber.CheckInt("Enter a[" + i + "]: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        System.out.print("Unsorted array: ");

        System.out.println(Arrays.toString(a));

        int temp;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }

        System.out.print("Sorted array: ");
        System.out.println(Arrays.toString(a));
    }
}
