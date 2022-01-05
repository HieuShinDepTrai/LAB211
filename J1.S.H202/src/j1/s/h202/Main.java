package j1.s.h202;

public class Main {
//    String ValidateInput(String Mess, String reg) {
//        Scanner SC = new Scanner(System.in);
//        String ret = "";
//        do {
//            System.out.println("Mess");
//            ret = SC.nextLine();
//            if(ret.matches(reg)) {
//                break;
//            }
//            System.out.println("Something went wrong, please try again!");
//        } while (true);
//        return reg;
//    }
    
    public static String printReverse(String S) {
        StringBuilder str = new StringBuilder(S);
//        System.out.println(str.reverse());
        return str.reverse().toString();
    }
    
    public static void main(String[] args) {
        String s = "Hello There!";
        System.out.println(printReverse(s));
    }
 
}
