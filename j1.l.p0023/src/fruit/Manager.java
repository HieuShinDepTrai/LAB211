/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruit;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lanh0
 */
public class Manager {

    public void createFruit(List<Fruit> listFruit) {
        while (true) {
            listFruit.add(inputFruit(listFruit));
            System.out.println("Created fruit success!");
            boolean conti = InputValid.checkInputYN("Do you want to continue (Y/N)?\n"
                    + "Y: continues\n" + "N: display all Fruits created and returns main screen\n", "y", "n");
            if (conti == false) {
                break;
            }
        }
        displaysListFruit(listFruit);
    }
    public void createFruit(String fruitID,List<Fruit> listFruit) {
        while (true) {
            listFruit.add(inputFruit(fruitID));
            System.out.println("Created fruit success!");
            boolean conti = InputValid.checkInputYN("Do you want to continue (Y/N)?\n"
                    + "Y: continues\n" + "N: display all Fruits created and returns main screen\n", "y", "n");
            if (conti == false) {
                break;
            }
        }
        displaysListFruit(listFruit);
    }

    public void updateFruit(List<Fruit> listFruit) {
        displaysListFruit(listFruit);
        String fruitID = InputValid.checkInputID("->Input ID: ", "FR[0-9]+");
        Fruit fruit = searchFruitByID(fruitID, listFruit);
        if (null != fruit) {
            int fruitQuantity = InputValid.checkInputInteger("->Set quantity fruit: ");
            fruit.setQuantity(fruitQuantity);
        } else {
            System.out.println("The fruit does not exist!");
            boolean conti = InputValid.checkInputYN("Yes/No: User choices ‘Yes’ to go to option 1, ‘No’ returns main screenc\n. ", "yes", "no");
            if (conti == true) {
                createFruit(fruitID,listFruit);
            } else {
            }
        }
    }

    public void viewOrder(Hashtable<String, List<Fruit>> listShopping) {
        for (Map.Entry<String, List<Fruit>> entry : listShopping.entrySet()) {
            String key = entry.getKey(); 
            System.out.println(key.split("-", 2)[1].trim());
            List<Fruit> value = entry.getValue();
            displayOrderFruit(value);
            System.out.println();
        }
    }

    public void shopping(List<Fruit> listFruit, Hashtable<String, List<Fruit>> listShopping) {
        List<Fruit> listOrder = new ArrayList<>();
        while (true) {
            List<Fruit> listFruit1 = displaysListFruitForOrder(listFruit);
            int item = InputValid.checkInputRange("Enter Item: ", 1, listFruit1.size());
            System.out.println("You selected: " + listFruit1.get(item - 1).getName());
            int quantity = InputValid.checkInputRange("Please input quantity: ", 1, listFruit1.get(item - 1).getQuantity());
            int count = 0;
            for (Fruit order : listOrder) {
                if (order.getIDfruit().equals(listFruit1.get(item - 1).getIDfruit())) {
                    order.setQuantity(order.getQuantity() + quantity);
                    count++;
                }
            }
            if (count == 0) {
                listOrder.add(new Fruit(listFruit1.get(item - 1).getIDfruit(), listFruit1.get(item - 1).getName(),
                        listFruit1.get(item - 1).getPrice(),
                        quantity, listFruit1.get(item - 1).getOrigin()));
            }
            listFruit1.get(item - 1).setQuantity(listFruit1.get(item - 1).getQuantity() - quantity);
            boolean conti = InputValid.checkInputYN("Do you want to order now (Y/N) \nY: display bill\nN: continue ordering\n", "y", "n");
            if (conti) {
                break;
            }
        }
        displayOrderFruit(listOrder);
        String name = InputValid.checkInputString("Input your name: ");
        listShopping.put(listShopping.size() + "-" + name, listOrder);
        System.out.println("Add successfull");
    }
    public Fruit inputFruit(List<Fruit> listFruit){
        String ID = null;
        while(true){
            ID = InputValid.checkInputString("->Enter ID fruit: ");
            if(searchFruitByID(ID,listFruit)==null){
                break;
            } else System.out.println("ID exist! Enter Again");
        }
        String name = InputValid.checkInputString("->Enter name fruit: ");
        double price = InputValid.checkInputDouble("->Enter price fruit: ");
        int quantity = InputValid.checkInputInteger("->Enter quantity fruit: ");
        String origin = InputValid.checkInputString("->Enter origin fruit: ");
        return new Fruit(ID,name, price, quantity, origin);
    }
    public Fruit inputFruit(String ID) {
        String name = InputValid.checkInputString("->Enter name fruit: ");
        double price = InputValid.checkInputDouble("->Enter price fruit: ");
        int quantity = InputValid.checkInputInteger("->Enter quantity fruit: ");
        String origin = InputValid.checkInputString("->Enter origin fruit: ");
        return new Fruit(ID,name, price, quantity, origin);
    }

    public void displaysListFruit(List<Fruit> listFruit) {
        System.out.printf("|++%s++|++%s++|++%s++|++%s++|++%s++|\n", "Item", "ID", "Fruit Name", "Origin", "Price");
        int itemCount = 1;
        for (Fruit fruit : listFruit) {
            System.out.printf("    %-5d %-12s %-10s %-10s %-10s\n", itemCount++, fruit.getIDfruit(), fruit.getName(), fruit.getOrigin(), fruit.getPrice());
        }
    }

    public List<Fruit> displaysListFruitForOrder(List<Fruit> listFruit) {
        System.out.printf("|++%s++|++%s++|++%s++|++%s++|++%s++|\n", "Item", "ID", "Fruit Name", "Origin", "Price");
        List<Fruit> listOrder = new ArrayList<>();
        int itemCount = 1;
        for (Fruit fruit : listFruit) {
            if (fruit.getQuantity() > 0) {
                System.out.printf("    %-5d %-10s %-10s %-10s %-10s\n", itemCount++, fruit.getIDfruit(), fruit.getName(), fruit.getOrigin(), fruit.getPrice());
                listOrder.add(fruit);
            }
        }
        return listOrder;
    }

    public Fruit searchFruitByID(String ID, List<Fruit> listFruit) {
        for (Fruit fruit : listFruit) {
            if (fruit.getIDfruit().equals(ID)) {
                return fruit;
            }
        }
        return null;
    }

    void displayOrderFruit(List<Fruit> order) {
        System.out.printf("%s|%s|%s|%s\n", "Product", "Quantity", "Price ", "Amount");
        double total = 0;
        for (int i = 0; i < order.size(); i++) {
            System.out.printf("%s.%s %-5d %-7.2f$ %-7.2f\n", i + 1, order.get(i).getName(),
                    order.get(i).getQuantity(),
                    order.get(i).getPrice(),
                    order.get(i).getPrice() * order.get(i).getQuantity());
            total += order.get(i).getPrice() * order.get(i).getQuantity();
        }
        System.out.println(new String().format("Total: %.2f$", total));
    }
}
