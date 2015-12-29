import java.util.InputMismatchException;
import java.util.Scanner;

//Class which includes the only method that returns amount of money, no matter to add or to get 'em;

public class UsersInputAmountOfMoney {



    public static long inputAmountOfMoney() throws MoneyTransactionException{

        long usersInput;


        try{

            System.out.println("Enter amount of money, or '0' for exit;");

            Scanner sc = new Scanner(System.in);
            usersInput = sc.nextLong();
            if(usersInput==0){
                return 0;
            }
            if(usersInput<0){

                throw new MoneyTransactionException(usersInput);
            }
            return usersInput;

        } catch (InputMismatchException e){
            System.out.println("Please enter only numbers and not bigger than 9 quintillions o: "+ e);
            return inputAmountOfMoney();
        } catch (MoneyTransactionException e) {
            System.out.println("You cant input negative amount! " + e);
            return inputAmountOfMoney();
        }


    }




}
