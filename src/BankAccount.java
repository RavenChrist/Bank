import java.util.Scanner;

public class BankAccount extends Account {

    private long BankAccountBalance;

    public BankAccount(int id, Status status, long bankAccountBalance) {
        super(id, status);
        BankAccountBalance = bankAccountBalance;
    }

    public static BankAccount createBankAccount() throws MoneyTransactionException {
        System.out.println("Please enter balance for your account!");

        return new BankAccount((AccountMaps.bankAccountMap.size()+1),
                Status.AVAILABLE, UsersInputAmountOfMoney.inputAmountOfMoney());

    }

    @Override
    public String toString() {
        return "Bank account #"+getId()+" balance: "+getBankAccountBalance();
    }

    public long getBankAccountBalance() {
        return BankAccountBalance;
    }

    public void setBankAccountBalance(long bankAccountBalance) {
        BankAccountBalance = bankAccountBalance;
    }
}
