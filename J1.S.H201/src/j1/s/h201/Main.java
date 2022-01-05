/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.h201;

/**
 *
 * @author lanh0
 */
public class Main {
    public static void main(String[] args) {
        Item i1 = new Item("Shampoo", 10.0, 0.0);
        Item i2 = new Item("Tomatoes", 5.0, 2.0);
        
        DiscountBill dbill1 = new DiscountBill(new Employee("John"), true);
        
        dbill1.add(i1);
        dbill1.add(i2);
        
        DiscountBill dbill2 = new DiscountBill(new Employee("Bob"), false);
        
        dbill2.add(i1);
        dbill2.add(i2);
        
        dbill1.printReceipt();
        dbill2.printReceipt();
        
    }
}
