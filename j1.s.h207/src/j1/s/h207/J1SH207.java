/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.h207;

import java.util.Scanner;

/**
 *
 * @author lanh0
 */
public class J1SH207 {

    /**
     * @param args the command line arguments
     */
    public static int secondHalfLetters(String str) {
        int min = (int) str.charAt(0);
        int max = (int) str.charAt(0);
        for (int i = 0; i < str.length(); i++) {
            if ((int) str.charAt(i) < min) {
                min = (int) str.charAt(i);
            }
            if ((int) str.charAt(i) > max) {
                max = (int) str.charAt(i);
            }
        }
        int mid = (min + max) / 2;
        String regex = "[^" + (char) mid + "-" + (char) max + "]";
        return str.replaceAll(regex, "").length();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if (!str.trim().isEmpty()) {
            System.out.println(secondHalfLetters(str.toLowerCase()));
        }

    }

}
