package j1.s.p0020;

import java.util.Scanner;

public class Main {

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
                    throw new Exception("Please input a positive decimal number: ");
                }
            } catch (NumberFormatException e) {
                System.err.println("Please input a positive decimal number: ");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

        //khoi tao va Nhap mang
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter a[" + i + "]: ");
            a[i] = inputInt();
        }

        //in ra mang chua sort
        System.out.print("\nUnsorted array: ");
        int i;
        for (i = 0; i < a.length - 1; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.print(a[i]);

        //ham Selection sort
        for (i = 0; i < n - 1; i++) {
            // tim so be nhat trong mang
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min_idx]) {
                    min_idx = j;
                }
            }

            // Swap vs phan tu dau tien
            int temp = a[min_idx];
            a[min_idx] = a[i];
            a[i] = temp;
        }
        System.out.println();
        System.out.print("Sorted array: ");
        for (i = 0; i < a.length - 1; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.println(a[i]);

    }

}
