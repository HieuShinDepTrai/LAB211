/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.h201;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lanh0
 */
public class GroceryBill {
    
    protected List<Item> itemList = new ArrayList<>();
    
    protected Employee clerk;

    public GroceryBill(Employee clerk) {
        this.clerk = clerk;
    }
    
    public void add(Item i){
        itemList.add(i);
    }
    
    public double getTotal(){
        double retTotal = 0;
        for(int i = 0; i<itemList.size();i++){
            retTotal += itemList.get(i).getPrice();
        }
        return retTotal;
    }
    
    public void printReceipt(){
        System.out.println("\nBill for " + clerk.getName());
        System.out.printf("   %s %8s %12s\n", "Item Name", "Price", "Discount");
        for (int i = 0; i < itemList.size(); i++) {
            Item item = itemList.get(i);
            System.out.printf("%d) %s %10.2f %10.2f\n", (i+1), item.getName(), item.getPrice(), item.getDiscount());

        }
    }
    
    
}
