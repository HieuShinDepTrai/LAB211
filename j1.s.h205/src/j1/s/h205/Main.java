
package j1.s.h205;

public class Main {

    public static void main(String[] args) {
        Startup s = new Startup(1000);
        Credit cr1 = new Credit(1500);
        Credit cr2 = new Credit(500); 
        Debit db1 = new Debit(500);  
        Debit db2 = new Debit(2000); 

        MinMaxAccount minMaxAccount = new MinMaxAccount(s);
        minMaxAccount.credit(cr1); 
        //2500
        minMaxAccount.debit(db1); 
        //2000
        minMaxAccount.credit(cr2); 
        //2500
        minMaxAccount.debit(db2); 
        //500

        System.out.println("Minimum Balance in the Bank Account: $" + minMaxAccount.getMin());
        System.out.println("Maximum Balance in the Bank Account: $" + minMaxAccount.getMax());
        System.out.println("Current Balance in the Bank Account: $" + minMaxAccount.getBalance());

    }
}
