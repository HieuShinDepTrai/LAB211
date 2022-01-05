/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.h209;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

/**
 *
 * @author lanh0
 */
public class J1SH209 {

    public static void countCoins(String str) {
        String itemString[] = str.split("\\s+");

        double totalCents = 0;
        for (int i = 0; i < itemString.length - 1; i = i + 2) {
            try {
                int quantity = Integer.parseInt(itemString[i]);
                if (quantity > 0) {
                    String coin = itemString[i + 1];
                    if (coin.equals("pennies")) {
                        totalCents += quantity;
                    } else if (coin.equals("nickels")) {
                        totalCents += 5 * quantity;
                    } else if (coin.equals("dimes")) {
                        totalCents += 10 * quantity;
                    } else if (coin.equals("quarters")) {
                        totalCents += 25 * quantity;
                    }
                }
            } catch (Exception e) {
                System.out.println("quantity invalid");
                return;
            }
        }

        System.out.printf("Total money: $%.2f", totalCents / 100);
    }

    public static void main(String args[]) {
        String str = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/j1/s/h209/file.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                str = str + line + " ";
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error not found file");
        } catch (IOException ex) {
            System.out.println("Error do not read file");
        }
        countCoins(str.toLowerCase());
    }

}
