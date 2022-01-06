
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ValidateInput {

    Scanner sc = new Scanner(System.in);

    Date CheckDate(String Mess, String format) {
        SimpleDateFormat SDF = new SimpleDateFormat(format);
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
