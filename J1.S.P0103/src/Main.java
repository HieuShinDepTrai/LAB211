
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the first date: ");
        String firstdate = sc.nextLine();
        DateFormat formatter1 = new SimpleDateFormat("MMM/dd/yyyy");
        Date date1 = formatter1.parse(firstdate);

        System.out.print("Please enter the first date: ");
        String seconddate = sc.nextLine();
        DateFormat formatter2 = new SimpleDateFormat("dd/mm/yyyy");
        Date date2 = formatter2.parse(seconddate);

        if (date1.compareTo(date2) > 0) {
            System.out.println("Date1 is after Date2");
        } else if (date1.compareTo(date2) < 0) {
            System.out.println("Date1 is before Date2");
        } else {
            System.out.println("Date1 is equal to Date2");
        }
    }

}
