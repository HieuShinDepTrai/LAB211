/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.h206;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author lanh0
 */
public class J1SH206 {
    public static void printSquare(int min, int max) {
        String str = "";
        for (int i = min; i <= max; i++) {
            str = str + Math.abs(i);
        }
        String maxStr = str.substring(0, 1);
        int vtmax = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i, i + 1).compareTo(maxStr) > 0) {
                maxStr = str.substring(i, i + 1);
                vtmax = i;
            } else if (str.substring(i, i + 1).compareTo(maxStr) == 0) {
                int vt1 = vtmax + 1;
                int vt2 = i + 1;
                while (str.charAt(vt1) == str.charAt(vt2) && vt1 < str.length() - 1 && vt2 < str.length() - 1) {
                    vt1 = vt1 + 1;
                    vt2 = vt2 + 1;
                }
                if (str.charAt(vt1) < str.charAt(vt2)) {
                    vtmax = i;
                }
            }
        }
        String minStr = str.substring(0, 1);
        int vtmin = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i, i + 1).compareTo(maxStr) < 0) {
                minStr = str.substring(i, i + 1);
                vtmin = i;
            } else if (str.substring(i, i + 1).compareTo(minStr) == 0) {
                int vt1 = vtmin + 1;
                int vt2 = i + 1;
                while (str.charAt(vt1) == str.charAt(vt2) && vt1 < str.length() - 1 && vt2 < str.length() - 1) {
                    vt1 = vt1 + 1;
                    vt2 = vt2 + 1;
                }
                if (str.charAt(vt1) < str.charAt(vt2)) {
                    vtmin = i;
                }
            }
        }

        String strMin = str.substring(vtmin) + str.substring(0, vtmin);
        String strMax = str.substring(vtmax) + str.substring(0, vtmax);
        System.out.println(strMin);
        for (int i = 0; i < strMin.length(); i++) {
            strMin = strMin.substring(1) + strMin.substring(0,1);
            System.out.println(strMin);
            if(strMin.equals(strMax)){
                break;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min;
        int max;
        while (true) {
            try {
                System.out.print("Input min: ");
                min = Integer.parseInt(scanner.nextLine());
                System.out.print("Input max: ");
                max = Integer.parseInt(scanner.nextLine());
                if (min > max) {
                    System.out.println("Min must be less than or by Max");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid number, please enter again! ");
            }
        }
        printSquare(min, max);
    }

}
