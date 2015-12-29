public interface Money {

    void addMoney() throws MoneyTransactionException;
    void getMoney() throws MoneyTransactionException;
    void showBalance();


}
