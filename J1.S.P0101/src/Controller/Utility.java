package Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Utility {
    //------------Gom co-------------
    // Nhap so trong khoang min - max
    //nhap 1 so thuc
    //nhap 1 so nguyen
    //nhap xau nonBlank
    //nhap xau theo mau
    //nhap date theo dinh dang
    //check ID duplicate

    public static Scanner sc = new Scanner(System.in);

    // Nhap so trong khoang min - max
    public static int getInt(String msg, int min, int max) {
        if (min > max) {
            int t = min;
            min = max;
            max = t;
        }
        int data;
        do {
            System.out.print(msg);
            data = Integer.parseInt(sc.nextLine());
        } while (data < min || data > max);

        return data;
    }

    //nhap 1 so thuc
    public static double getDouble(String msg) {
        double data = 0;
        boolean check = false;
        System.out.print(msg);
        while (check == false) {
            try {
                data = Double.parseDouble(sc.nextLine());
                check = true;
            } catch (Exception e) {
                System.out.println("Please enter a number");
            }
        }
        return data;
    }

    //nhap 1 so ko am
    public static double getDoublePositive(String msg, String msg2) throws Exception {
        Scanner sc = new Scanner(System.in);
        double n = 0;
        boolean check = true;  // kiem tra xem nhap dung chua       
        System.out.println(msg);
        //Nhap kich thuowc mang
        while (check) {
            try {
                n = Integer.parseInt(sc.nextLine().trim());
                if (n >= 0) {
                    check = false;
                } else {
                    throw new Exception(msg2);
                }
            } catch (NumberFormatException e) {
                System.err.println(msg2);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return n;
    }

    //nhap 1 so nguyen
    public static int getInt(String msg) {
        int data = 0;
        boolean check = false;
        System.out.print(msg);
        while (check == false) {
            try {
                data = Integer.parseInt(sc.nextLine());
                check = true;
            } catch (Exception e) {
                System.out.println("Please enter a number");
            }
        }
        return data;
    }

    //nhap xau nonBlank
    public static String getNonBlankStr(String msg) {
        String data;
        do {
            System.out.print(msg);
            data = sc.nextLine().trim();
        } while (data.length() == 0);
        return data;
    }

    //nhap xau theo mau
    public static String getPattern(String msg, String msg2, String pattern) {
        String data;
        do {
            System.out.print(msg);
            data = sc.nextLine().trim();
            if (!data.matches(pattern)) {
                System.err.println(msg2);
            }
        } while (!data.matches(pattern));
        return data;
    }

    //nhap date theo dinh dang
    public static Date getDate(String msg) {
        Date d = null;
        SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
        SDF.setLenient(false);
        //true: 30/2 -> 1/3
        //false: 30/2 -> false
        System.out.println(msg);
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                d = SDF.parse(sc.nextLine());
                if (checkAge(d) == false) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.err.print("Invalid date, please input again: ");
            }
        }
        return d;
    }

    public static boolean checkAge(Date xDOB) throws ParseException {
        SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
        Date acceptAge = new Date(xDOB.getYear(), xDOB.getMonth(), xDOB.getDate());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        // LocalDateTime -> String theo format
        Date today = SDF.parse(dtf.format(now));
        //check xem cai ngay nhap vao no da qua chua
        if (today.after(acceptAge)) {
            return true;
        } else {
            return false;
        }
    }

    //check id duplicate
    public static boolean isIDDupplicated(String id, Manager m) {
        id = id.trim().toUpperCase();
        return m.search(id) != null; //neu id da ton tai thi tra ve true
    }

}
