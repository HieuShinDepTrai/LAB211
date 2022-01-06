
package j1.s.h204;

public class Transaction {
    private boolean transacionStatus;
    private int pennies;

    public Transaction(boolean transacionStatus, int pennies) {
        this.transacionStatus = transacionStatus;
        this.pennies = pennies;
        if(transacionStatus){
            value();
        }
    }
    public int value (){
        return pennies*100;
    }

    public boolean isTransacionStatus() {
        return transacionStatus;
    }

    public void setTransacionStatus(boolean transacionStatus) {
        this.transacionStatus = transacionStatus;
    }

    public int getPennies() {
        return pennies;
    }

    public void setPennies(int pennies) {
        this.pennies = pennies;
    } 
}
