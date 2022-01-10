
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ValidateInput {

    Scanner sc = new Scanner(System.in);

    Date CheckDate(String Mess, String format) {
        // parse 1 String -> Date
        SimpleDateFormat SDF = new SimpleDateFormat(format);
        // Nếu nhập sai ngày như 30/02 thì sẽ báo sai và phải nhập lại
        SDF.setLenient(false);
        Date ret;
        do {
            System.out.print("\n" + Mess);
            try {
                ret = SDF.parse(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Invalid date input, please try again!");
            }
        } while (true);
        return ret;
    }
}
