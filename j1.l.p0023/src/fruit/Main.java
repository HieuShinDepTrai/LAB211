
package fruit;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Fruit> list = new ArrayList<>();
        list.add(new Fruit("FR101","Coconut", 2, 30, "VN"));
        list.add(new Fruit("FR103","Orange", 3, 30, "US"));
        list.add(new Fruit("FR102","Apple", 4, 30, "Thailand"));
        list.add(new Fruit("FR100","Grape", 6, 30, "France"));
        Manager manager = new Manager();
        Hashtable<String, List<Fruit>> listShopping = new Hashtable<>();
        
        while (true) {
            int number = Menu.menu();
            switch (number) {
                case 1:
                    manager.createFruit(list);
                    break;
                case 2:
                    manager.updateFruit(list);
                    break;
                case 3:
                    manager.viewOrder(listShopping);
                    break;
                case 4:
                    manager.shopping(list,listShopping);
                    break;
                case 5:
                    return;
            }
        }
    }
}
