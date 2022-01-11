package j1.s.p0020;

import java.util.Arrays;

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

        int i, j, min_idx, temp;
        // Move the boundaries of sorted and unsorted arrays
        for (i = 0; i < n - 1; i++) {
            // Find smallest element in unsorted array
            min_idx = i;
            for (j = i + 1; j < n; j++) {
                if (a[j] < a[min_idx]) {
                    min_idx = j;
                }
            }

            // Swap the smallest element with the first element
            temp = a[min_idx];
            a[min_idx] = a[i];
            a[i] = temp;
            
//            System.out.println(Arrays.toString(a));
        }

        System.out.print("Sorted array: ");
        System.out.println(Arrays.toString(a));
    }
}
