
package fruit;

public class Menu {

    public static int menu() {
        System.out.println("==================================");
        System.out.println("1.	Create Fruit");
        System.out.println("2.	Update Fruit");
        System.out.println("3.	View orders");
        System.out.println("4.	Shopping (for buyer)");
        System.out.println("5.	Exit");
        int number = InputValid.checkInputRange("> Choose: ", 1, 5);
        return number;
    }
}
