import java.util.Scanner;

public class CreditCard extends Account implements Money {

    private BankAccount bankAccount;
    private String pin;

    public String getPin() {
        return pin;
    }

    public int getPinInputAttemptCount() {
        return pinInputAttemptCount;
    }

    public BankAccount getBankAccount(){
        return bankAccount;
    }

    public void setPinInputAttemptCount(int pinInputAttemptCount) {
        this.pinInputAttemptCount = pinInputAttemptCount;
    }

    private int pinInputAttemptCount;


    public CreditCard(int id, Status status, BankAccount bankAccount, String  pin) {
        super(id, status);
        this.bankAccount = bankAccount;
        this.pin = pin;
        this.pinInputAttemptCount = 0;
    }

    public static CreditCard createCreditCard(){
        if(AccountMaps.bankAccountMap.isEmpty()){
            System.out.println("There's no bank accounts at all, please create at least one!");
            return null;
        }
        int baId;
        System.out.println("Please enter bank account id: ");
        Scanner sc = new Scanner(System.in);
        try {
            baId = sc.nextInt();
            if(AccountMaps.bankAccountMap.containsKey(baId)){
                return new CreditCard((AccountMaps.creditCardMap.size()+1),
                        Status.AVAILABLE, AccountMaps.bankAccountMap.get(baId),PinGenerator.pinGenerator());
            }else {
                throw new Exception();
            }
        }catch (Exception e){
            System.out.println("There's no such bank account with that id");
            return null;
        }

    }


    @Override
    public void addMoney() throws MoneyTransactionException {

        long usersAmountOfMoneyInput;

        System.out.println("How much money do you wanna add?");


        usersAmountOfMoneyInput = UsersInputAmountOfMoney.inputAmountOfMoney();

        if (usersAmountOfMoneyInput == 0) {
            return;
        }else if((Long.MAX_VALUE - bankAccount.getBankAccountBalance())<usersAmountOfMoneyInput){
            System.out.println("Sorry but balance limit is reached! Max value you can turn in is: "+
                    (Long.MAX_VALUE-bankAccount.getBankAccountBalance()));
            addMoney();
        }else {
            bankAccount.setBankAccountBalance(bankAccount.getBankAccountBalance()+usersAmountOfMoneyInput);
            System.out.println("Success!");
        }

    }



    @Override
    public void getMoney() throws MoneyTransactionException {

        if(PinValidator.pinValidator(this)==0){
            return;
        }

        if(getStatus().equals(Status.BLOCKED)){
            System.out.println("Sorry, but your card is blocked!");
            return;
        }
        if(bankAccount.getBankAccountBalance()==0){
            System.out.println("Your balance is 0");
            return;
        }

        long usersAmountOfMoneyInput;

        System.out.println("How much money do you wanna get?");

        usersAmountOfMoneyInput = UsersInputAmountOfMoney.inputAmountOfMoney();

        if (usersAmountOfMoneyInput == 0) {
            return;
        }else if((bankAccount.getBankAccountBalance()-usersAmountOfMoneyInput)<0){
            System.out.println("Sorry but you have not enough money, money left: "+
                    bankAccount.getBankAccountBalance());
            return;
        }else {
            bankAccount.setBankAccountBalance(bankAccount.getBankAccountBalance()-usersAmountOfMoneyInput);
            System.out.println("Success!");
        }
    }

    @Override
    public void showBalance() {

        if(PinValidator.pinValidator(this)==0){
            return;
        }


        System.out.println("Balance of ur credit card's account is: "+bankAccount.getBankAccountBalance());
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "bankAccount=" + bankAccount +
                ", pin='" + pin + '\'' +
                ", pinInputAttemptCount=" + pinInputAttemptCount +
                '}';


    }
}
