
import java.util.Scanner;

// In ra menu và nhận vào giá trị option từ người dùng
public class Menu {

    public static int menu() {
        System.out.println("COURSE MANAGEMENT SYSTEM");
        System.out.println("1. A list of all available courses in the system");
        System.out.println("2. Search and display information of a course by course id");
        System.out.println("3. Record/Add information of course");
        System.out.println("4. Sort all courses by number of credit as ascending");
        System.out.println("5. Update information of a specific course (by course id)");
        System.out.println("0. Exit");

        return Validation.getInt("Select your choice: ", 0, 5);
    }
}
