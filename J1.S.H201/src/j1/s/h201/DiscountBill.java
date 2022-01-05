/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.h201;

import java.util.List;

/**
 *
 * @author lanh0
 */
public class DiscountBill extends GroceryBill {

    private boolean isPerferredCustemor = false;

    public DiscountBill(Employee clerk, boolean preferred) {
        super(clerk);
        isPerferredCustemor = preferred;
    }

    public int getDiscountCount() {
        int retDiscount = 0;
        if (isPerferredCustemor) {
            for (int i = 0; i < itemList.size(); i++) {
                if (itemList.get(i).getDiscount() > 0) {
                    retDiscount++;
                }
            }
        }
        return retDiscount;
    }

    public double getDiscountAmount() {
        int retAmount = 0;
        if (isPerferredCustemor) {
            for (int i = 0; i < itemList.size(); i++) {
                retAmount += itemList.get(i).getDiscount();
            }
        }
        return retAmount;
    }

    public double getDiscountPercent() {
        double grossTotal = super.getTotal();
        return (getDiscountAmount() / grossTotal) * 100;
    }

    @Override
    public double getTotal() {
        if (!isPerferredCustemor) {
            return super.getTotal();
        }
        return super.getTotal() - getDiscountAmount();
    }

    @Override
    public void printReceipt() {
        System.out.println("\nBill for " + clerk.getName());
        System.out.printf("   %s %8s %12s\n", "Item Name", "Price", "Discount");
        for (int i = 0; i < itemList.size(); i++) {
            Item item = itemList.get(i);
            System.out.printf("%d) %s %10.2f %10.2f\n", (i+1), item.getName(), item.getPrice(), item.getDiscount());

        }
        System.out.printf("No.Discounted Items:%d \n", getDiscountCount());
        System.out.printf("Total Amount: %3.2f \n", super.getTotal());
        System.out.printf("Bill after Discount: %3.2f (%2.2f%%)\n", getDiscountAmount(), getDiscountPercent());
        
    }
}
