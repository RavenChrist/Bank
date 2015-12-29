import java.util.Scanner;

/**
 * Created by Lenovo on 18.12.2015.
 */
public class BankMain {
    public static void main(String[] args) throws MoneyTransactionException {

        int userChoice;
        int userChoiqce;

        do{
            System.out.println("Enter what you want: ");
            System.out.println("1. Add new bank account;");
            System.out.println("2. Add new credit card;");
            System.out.println("3. Add money;");
            System.out.println("4. Get money;");
            System.out.println("5. Show all sorted bank accounts;");
            System.out.println("6. Show all credit cards of bank account;");
            System.out.println("7. Show credit card balance;");
            System.out.println("0. Exit;");

            Scanner sc = new Scanner(System.in);


            if(sc.hasNextInt()){
                userChoice = sc.nextInt();
            }else {
                userChoice = -1;
            }

            switch (userChoice){
                case 1:
                    AccountMaps.addNewBankAccount();
                    break;
                case 2:
                    AccountMaps.addNewCreditCard();
                    break;
                case 3:
                    AccountMaps.addMoney();
                    break;
                case 4:
                    AccountMaps.getMoney();
                    break;
                case 5:
                    AccountMaps.sortBankAccounts();
                    break;
                case 6:
                    AccountMaps.showCardsByBankAccount();
                    break;
                case 7:
                    AccountMaps.showBalance();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Please choose correctly or press '0' to exit;");
                    break;
            }

        }while (userChoice!=0);

        System.out.println("Ciao!");











    }
}
