
package fruit;

public class Fruit {
    private String IDfruit;
    private String name;
    private double price;
    private int quantity;
    private String origin;

    public Fruit() {
    }


    public Fruit(String IDfruit, String name, double price, int quantity, String origin) {
        this.IDfruit = IDfruit;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

    public String getIDfruit() {
        return IDfruit;
    }

    public void setIDfruit(String IDfruit) {
        this.IDfruit = IDfruit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
    
    
}
