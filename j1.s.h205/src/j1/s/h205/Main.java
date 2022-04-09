
package j1.s.h205;

public class Main {

    public static void main(String[] args) {    
        Validation v = new Validation();
        
        double initialBalance = v.inputDouble("Nhap so du ban dau: ", 0, Double.MAX_VALUE);
        Startup s = new Startup(initialBalance);
        MinMaxAccount minMaxAccount = new MinMaxAccount(s);
        
        int choice;
        
        while (true) {            
            System.out.println("1. Nhap credit");
            System.out.println("2. Nhap debit");
            System.out.println("3. Quit");
            System.out.print("Enter your choice: ");
            choice = v.inputInt("", 1, 3);
            switch(choice) {
                case 1:
                    double creditAmount = v.inputDouble("Nhap creditAmount: ", 0, Double.MAX_VALUE);
                    Credit cr = new Credit(creditAmount);
                    minMaxAccount.credit(cr);
                    minMaxAccount.printInfo();
                    break;
                case 2:
                    double debitAmount = v.inputDouble("Nhap debitAmount: ", 0, Double.MAX_VALUE);
                    Debit db = new Debit(debitAmount);
                    minMaxAccount.debit(db);
                    minMaxAccount.printInfo();
                    break;
                case 3: 
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}
