
package j1.s.h201;

public class Item {
   private String name;
   private double price = 0.0;
   private double discount = 0.0;

    public Item(String name, double price, double discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    } 
}
