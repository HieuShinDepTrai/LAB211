package j1.s.p0001;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {

    public static void main(String[] args) {
        ValidateInput IntegerNumber = new ValidateInput();

        int n = IntegerNumber.CheckInt("Enter number of array: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        int[] a = new int[n];
        
        Random rd = new Random();
        for (int i = 0; i < n; i++) {
            a[i] = rd.nextInt(n + 1);
        }
        
        System.out.print("Unsorted array: ");
        System.out.println(Arrays.toString(a));

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
       
        System.out.print("Sorted array: ");
        System.out.println(Arrays.toString(a));
    }

}
