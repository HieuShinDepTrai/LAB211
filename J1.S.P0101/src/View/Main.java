package View;

import Controller.Utility;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Inputter I = new Inputter();
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

            option = Utility.getInt("");
            switch (option) {
                case 1:
                    I.addEmployee();
                    break;
                case 2:
                    I.updateEmployee();
                    break;
                case 3:
                    I.removeEmployee();
                    break;
                case 4:
                    I.searchByName();
                    break;
                case 5:
                    I.sortBySalary();
                    break;
                case 6:
                    I.Display();
                    break;
                case 0:
                    return;
                default:
                    System.err.println("Ko bit doc so ak");
                    break;

            }
        }

    }
}
