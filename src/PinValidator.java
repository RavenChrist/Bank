import java.util.Scanner;

public abstract class PinValidator {

    public static int pinValidator(CreditCard creditCard){

        //Method checking and calling itself until card blocks or pin check passing;
        //Returns 0 if card got blocked or simply to quit input attempt;
        //Returns 1 if pin check passed;

        String  usersPinInput;
        if(creditCard.getStatus().equals(Status.BLOCKED)){
            System.out.println("Sorry, but your card is blocked!");
            return 0;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your pin:");
        usersPinInput = sc.nextLine();

        if(usersPinInput.equals(creditCard.getPin())){
            creditCard.setPinInputAttemptCount(0);
            return 1;
        }else if(usersPinInput.equals("0")){
            return 0;

        }else{

            //Counting pin attempt and shows off how much attempts left (3 in total);

            creditCard.setPinInputAttemptCount(creditCard.getPinInputAttemptCount() + 1);
            System.out.println("Incorrect pin! Attempts left: " + (3 - creditCard.getPinInputAttemptCount()));
            if(creditCard.getPinInputAttemptCount()==3){
                System.out.println("Your card've been blocked! Please come to the bank point to unblock your card you loser!");
                creditCard.setStatus(Status.BLOCKED);
                return 0;
            }

            return pinValidator(creditCard);
        }

    }



}


