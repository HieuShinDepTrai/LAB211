

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Inputter {
    //------------Gom co-------------
    // Nhap so trong khoang min - max
    //nhap 1 so thuc
    //nhap 1 so nguyen
    //nhap xau nonBlank
    //nhap xau theo mau
    //nhap date theo dinh dang
    
    public static Scanner sc = new Scanner(System.in);
    // Nhap so trong khoang min - max
    public static int inputInt(String msg, int min, int max){
        int ret = 0;
        String input = "";
        System.out.print(msg);
        do {
            try {
                input = sc.nextLine();
                ret = Integer.parseInt(input.trim());
                if (ret >= min && ret <= max) {
                    break;
                }
                System.out.println("Out of range, please enter in range: " + "(" + min + " - " + max + ")");
            } catch (NumberFormatException e) {
                if (input.matches("\\-?\\d+")) {
                    System.out.println("Out of range of integer number");
                } else {
                    System.out.println("Invalid number input, please enter an integer number only");
                }
            }
        } while (true);
        return ret;
    }
    
    //nhap 1 so ko am
    public static double inputDouble(String msg, double min, double max){
        double ret = 0;
        String input = "";
        System.out.print(msg);
        do {
            try {
                input = sc.nextLine();
                ret = Double.parseDouble(input.trim());
                if (ret >= min && ret <= max) {
                    break;
                }
            } catch (NumberFormatException e) {
                    System.out.println("Invalid number input, please enter an double number only");
            }
        } while (true);
        return ret;
    }
    
    //nhap xau nonBlank
    public static String inputNonBlankStr(String msg){
        String data;
        do{
            System.out.print(msg);
            data = sc.nextLine().trim();
        }
        while (data.length()==0);
        return data;
    }
    
    //nhap xau theo mau
    public static String inputPattern(String msg,String msg2, String pattern){
        String data;
        do{
            System.out.print(msg);
            data = sc.nextLine().trim();
            if(!data.matches(pattern))
                System.err.println(msg2);
        }
        while(!data.matches(pattern));
        return data;
    }
    
    //nhap date theo dinh dang
    public static Date getDate(String msg) {
        Date d = null;
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false); 
        System.out.print(msg);
        while (true) {
            try {
                d = df.parse(sc.nextLine().trim());
                if(checkAge(d)==true) {
                    break;
                }
                System.err.print("This date is in the future, please input again: ");
            } catch (Exception e) {
                System.err.print("Invalid date, please input again: ");
            }
        }
        return d;
    }
    
    public static boolean checkAge(Date xDOB) throws ParseException {
        SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy"); // parse Str -> Date SDF.parse("String)
                                                                   //SDF.format(Date) tra ve String
        Date acceptAge = new Date(xDOB.getYear() , xDOB.getMonth(), xDOB.getDate());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        // LocalDateTime -> String theo format
        Date today = SDF.parse(dtf.format(now));
        return today.after(acceptAge);
    } 
}
