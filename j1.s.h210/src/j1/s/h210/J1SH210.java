/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.h210;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lanh0
 */
public class J1SH210 {
    public static void flipLines(List<String> readline) {
        for (int i = 0; i < readline.size() - 1; i += 2) {
            String temp = readline.get(i);
            readline.set(i, readline.get(i + 1));
            readline.set(i + 1, temp);
        }
        readline.forEach(n -> System.out.println(n));
    }

    public static void main(String args[]) {
        List<String> readline = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/j1/s/h210/lanh.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                readline.add(line);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error not found file");
        } catch (IOException ex) {
            System.out.println("Error do not read file");
        }
        flipLines(readline);
    }

}
