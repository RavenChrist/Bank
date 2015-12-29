import java.util.*;

/**
 * Created by Lenovo on 23.12.2015.
 */
public class AccountMaps {

    //Static maps /w id as a key;

    public static Map<Integer, BankAccount> bankAccountMap = new HashMap<>();
    public static Map<Integer, CreditCard> creditCardMap = new HashMap<>();

    public static void addNewBankAccount() throws MoneyTransactionException {
        BankAccount buff = BankAccount.createBankAccount();

        bankAccountMap.put(buff.getId(), buff);

        System.out.println("Success!");
        System.out.println("Bank account #"+buff.getId()+" have been added!");
    }

    public static void addNewCreditCard(){
        CreditCard buff = CreditCard.createCreditCard();
        if(buff!=null){
            creditCardMap.put(buff.getId(), buff);

            System.out.printf("Success!");
            System.out.println("Credit Card #"+buff.getId()+" pin is: \""+buff.getPin()+"\";");
        }

    }

    public static void showBalance(){
        try{
        if(creditCardMap.isEmpty()){
            System.out.println("There's no credit cards;");
            return;
        }
        System.out.println("Enter credit card's id: ");
        Scanner sc = new Scanner(System.in);
        int idInput;

            idInput = sc.nextInt();
            creditCardMap.get(idInput).showBalance();
        }catch (Exception e){
            System.out.println("There's no such credit card o;");
        }
    }

    public static void addMoney(){
        try{
            if(creditCardMap.isEmpty()){
                System.out.println("There's no credit cards;");
                return;
            }
            System.out.println("Enter credit card's id: ");
            Scanner sc = new Scanner(System.in);
            int idInput;

            idInput = sc.nextInt();
            creditCardMap.get(idInput).addMoney();
        }catch (Exception e){
            System.out.println("There's no such credit card o;");
        }
    }

    public static void getMoney(){
        try{
            if(creditCardMap.isEmpty()){
                System.out.println("There's no credit cards;");
                return;
            }
            System.out.println("Enter credit card's id: ");
            Scanner sc = new Scanner(System.in);
            int idInput;

            idInput = sc.nextInt();
            creditCardMap.get(idInput).getMoney();
        }catch (Exception e){
            System.out.println("There's no such credit card o;");
        }
    }

    public static void showCardsByBankAccount(){
        if(creditCardMap.isEmpty() || bankAccountMap.isEmpty()){
            System.out.println("There's no credit cards or bank accounts at all;");
            return;
        }
        System.out.println("Enter Bank Account num: ");
        Scanner sc = new Scanner(System.in);
        boolean isAnyCreditCard = false;
        int idInput;
        try{
            idInput = sc.nextInt();
            List<CreditCard> creditCardList = new ArrayList<>(creditCardMap.values());
            for(CreditCard creditCard: creditCardList){
                if(creditCard.getBankAccount().getId()==idInput){
                    System.out.println("Credit card #"+creditCard.getId()+" bounded to "+idInput+" Bank Account;");
                    isAnyCreditCard = true;
                }
            }
            if(!isAnyCreditCard){
                throw new Exception();
            }
        }catch (Exception e){
            System.out.println("There's no such bank account!"+e);
        }
    }



    //SUKA YA HZ ETI SORTIROVKI
    //BUDU DROCHIT IH, KOMPARATORI, ITERATORI V ROT EBAL

    public static void sortBankAccounts(){
        if(bankAccountMap.isEmpty()){
            System.out.println("There's no bank accounts!");
            return;
        }else {
            List<BankAccount> bankAccountList = new ArrayList<>(bankAccountMap.values());
            BankAccount baArray[] = new BankAccount[bankAccountList.size()];
            baArray = bankAccountList.toArray(baArray);
            for (int i = 0; i < baArray.length; i++) {
                for (int j = i+1; j < baArray.length; j++) {
                    if(baArray[i].getBankAccountBalance()<baArray[j].getBankAccountBalance()){
                        BankAccount buf = baArray[i];
                        baArray[i] = baArray[j];
                        baArray[j] = buf;
                    }
                }
            }
            for(BankAccount bankAccount: baArray){
                System.out.println(bankAccount.toString());
            }
        }
    }

}
