package j1.s.p0001;

import java.util.Scanner;

public class BubbleSort {

    public static void main(String[] args) {
        ValidateInput IntegerNumber = new ValidateInput();

        //khoi tao va Nhap mang
        int n = IntegerNumber.CheckInt("Enter number of array: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = IntegerNumber.CheckInt("Enter a[" + i + "]: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        //in ra mang chua sort
        System.out.print("Unsorted array: [");
        int i;
        for (i = 0; i < a.length - 1; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.println(a[i] + "]");

        //ham bubble sort
        for (i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
       
        System.out.print("Sorted array: [");
        for (i = 0; i < a.length - 1; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.println(a[i] + "]");
    }

}
