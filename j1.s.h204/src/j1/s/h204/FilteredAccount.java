
package j1.s.h204;

public class FilteredAccount extends Account {
    private double zeroCount;
    private double transactionsCount;
    public FilteredAccount(Client c) {
        super(c);
        zeroCount = 0;
        transactionsCount = 0;
    }
    
    @Override
    public boolean process(Transaction t){
        if(t.value()==0){
            zeroCount++;
            return false;
        } else if(t.value()>0 && t.isTransacionStatus()){
            transactionsCount++;
            return super.process(t);
        } else return false;
    }
    
    public double percentFiltered(){
        if(transactionsCount == 0){
            return 0.0;
        } else return (transactionsCount/(zeroCount+transactionsCount)*100);
    }

    public double getZero() {
        return zeroCount;
    }

    public void setZero(double zero) {
        this.zeroCount = zero;
    }

    public double getTransactionsCount() {
        return transactionsCount;
    }

    public void setTransactionsCount(double transactionsCount) {
        this.transactionsCount = transactionsCount;
    }
    

}
