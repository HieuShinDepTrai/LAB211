package j1.s.p0001;

import java.util.Scanner;

public class BubbleSort {

    private static int inputInt() {
        //loop until user input correct
        Scanner sc = new Scanner(System.in);
        int n = 0;
        boolean check = true;
        //Nhap kich thuowc mang
        while (check) {
            try {
                n = Integer.parseInt(sc.nextLine().trim());
                check = false;
            } catch (NumberFormatException e) {
                System.err.println("Please input a number: ");
            }
        }
        return n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        boolean check = true;
        //Nhap kich thuowc mang
        System.out.println("Input size of array(positive decimal number): ");
        while (check) {
            try {
                n = Integer.parseInt(sc.nextLine().trim());
                if (n > 0) {
                    check = false;
                } else {
                    System.out.println("Please input a positive decimal number: ");
                };
            } catch (NumberFormatException e) {
                System.err.println("Please input a positive decimal number: ");
            }
        }

        //khoi tao va Nhap mang
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter a[" + i + "]: ");
            a[i] = inputInt();
        }

        //in ra mang chua sort
        System.out.print("Unsorted array: ");
        int i;
        for (i = 0; i < a.length - 1; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.println(a[i]);

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
        System.out.println();
        System.out.print("Sorted array: ");
        for (i = 0; i < a.length - 1; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.println(a[i]);
    }

}
