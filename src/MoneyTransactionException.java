/**
 * Created by Lenovo on 18.12.2015.
 */
public class MoneyTransactionException extends Exception {
    private long detail;

    MoneyTransactionException(long detail){
        this.detail = detail;
    }

    public String toString(){
        return "Incorrect amount of money: " + detail + "!;";
    }
}
