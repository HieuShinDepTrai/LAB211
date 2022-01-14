
package j1.s.h204;

public class Main {
    public static void main(String[] args) {
        Client client = new Client("Personal Account ");
        FilteredAccount filteredAccount = new FilteredAccount(client);
        Transaction firstTransaction = new Transaction(true, 100);
        Transaction secondTransaction = new Transaction(true, 0);
        Transaction thirdTransaction = new Transaction(false,300);
        Transaction fourTransaction = new Transaction(true, 300);
        Transaction fifthTransaction = new Transaction(false, 0);
        
        filteredAccount.process(firstTransaction);
        filteredAccount.process(secondTransaction);
        filteredAccount.process(thirdTransaction);
        filteredAccount.process(fourTransaction);
        filteredAccount.process(fifthTransaction);
        
        System.out.println("Account Type: " + filteredAccount.getclient());
        System.out.println("First Transaction: "+filteredAccount.process(firstTransaction));
        System.out.println("Second Transaction: "+filteredAccount.process(secondTransaction));
        System.out.println("Third Transaction: "+filteredAccount.process(thirdTransaction));
        System.out.println("FourdTransaction: "+filteredAccount.process(fourTransaction));
        System.out.println("FifthTransaction: "+filteredAccount.process(fifthTransaction));
        
        System.out.printf("Percent Filtered: %.2f%s",filteredAccount.percentFiltered(), "%");
    }
}
