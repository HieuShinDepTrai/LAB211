
import java.util.Scanner;

public class Validation {

    // Scanner
    public static String getString(String msg) {
        System.out.print(msg);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    
    // Xử lí ngoại lệ, nhập sai option trong menu từ 0 - 5
    // Nếu nhập quá thì thông báo Out of Range
    // Nếu nhập sai kiểu dữ liệu thì thông báo Wrong Format
    public static int getInt(String msg, int min, int max) {
        int result = 0;

        while (true) {
            try {
                System.out.print(msg);

                Scanner sc = new Scanner(System.in);
                result = sc.nextInt();

                if (result < min || result > max) {
                    System.out.println("Out of Range!");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Wrong fomart!");
            }
        }

        return result;
    }
}
