import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
     
        //For input 
        Scanner input = new Scanner(System.in);

        //Bank account Object
        BankAccount account = new BankAccount(0);

        //User to deposit money()
        System.out.println(" Enter ammount to Deposit : ");
        double deposit = input.nextDouble();
        account.deposit(deposit);   //method call with parameter

        //User Withdrow
        System.out.println("Enter ammount to withdrow : ");
        double withdrow = input.nextDouble();
        account.withdrow(withdrow);

        System.out.println("Current Balance : " + account.getBalance());
        input.close();

    }
}