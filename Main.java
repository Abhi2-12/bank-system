import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
     
        //For input 
        Scanner input = new Scanner(System.in);

        //Bank account Object
        BankAccount account = new BankAccount(0);

        boolean running = true;

        while (running){

            System.out.println(" \n ________Bank Menu_________");
            System.out.println(" 1. Deposit");
            System.out.println(" 2. Withdraw");
            System.out.println(" 3. Check Balance");
            System.out.println(" 4. Exit");

            System.out.println(" Choose Option ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    //User to deposit money()
                    System.out.println(" Enter ammount to Deposit : ");
                    double deposit = input.nextDouble();
                    account.deposit(deposit);   //method call with parameter   
                    break;

                case 2:
                    //User Withdrow
                    System.out.println("Enter ammount to withdrow : ");
                    double withdraw = input.nextDouble();
                    account.withdraw(withdraw);
                    break;

                case 3:
                    System.out.println("Current Balance : " + account.getBalance());
                    break;

                case 4:
                    running = false;
                    System.out.println("Exiting....");
                    break;
            
                default:
                    System.out.println(" Invalid choice");
                    break;
            }

            System.out.println("Current Balance : " + account.getBalance());

        }


        input.close();

    }
}