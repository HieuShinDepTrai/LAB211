
package j1.s.h205;

public class MinMaxAccount extends BankingAccount{
    private double minBalance;
    private double maxBalance;

    public MinMaxAccount(Startup s) {
        super(s);
        minBalance = getBalance();
        maxBalance = getBalance();
    }
    
    @Override
    public void credit(Credit c){
        super.credit(c);
        updateMax();
    }   
    
    @Override
    public void debit(Debit d){
        super.debit(d);
        updateMin();
    }
    public void updateMin(){
        if(getBalance() < minBalance){
            minBalance = getBalance();
        }
    }
    public void updateMax(){
        if(getBalance() > maxBalance){
            maxBalance = getBalance();
        }
    }
    public double getMin(){
        return minBalance;
    }
    public double getMax(){
        return maxBalance;
    }
}
