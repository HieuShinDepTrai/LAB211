
package j1.s.h204;

public class Account {

    private String accountType;

    public Account() {
    }

    public Account(Client c) {
        this.accountType = c.getClientType();
    }

    public boolean process(Transaction t){
        return t.isTransacionStatus();
    }
    
    public String getclient(){
        return accountType;
    }

}
