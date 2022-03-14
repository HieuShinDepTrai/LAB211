
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Manager M = new Manager();
        Scanner sc = new Scanner(System.in);
        int option;

        while (true) {
            System.out.println("\nMenu--------- ");
            System.out.println("1. Add new Employee");
            System.out.println("2. Update employee");
            System.out.println("3. Remove employees");
            System.out.println("4. Search employees by name");
            System.out.println("5. Sort employees by salary");
            System.out.println("6. Display");
            System.out.println("0. Exit");
            System.out.print("Your option: ");

            option = Inputter.inputInt("", 0, 6);
            switch (option) {
                case 1:
                    M.addEmployee();
                    break;
                case 2:
                    M.updateEmployee();
                    break;
                case 3:
                    M.removeEmployee();
                    break;
                case 4:
                    M.searchByName();
                    break;
                case 5:
                    M.sortBySalary();
                    break;
                case 6:
                    M.Display();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Ko bit doc so ak");
                    break;

            }
        }
    }
}
