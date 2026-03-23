import java.util.Scanner;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
     
        //For input 
        Scanner input = new Scanner(System.in);
        boolean account = true;


        //Bank account Object
        //BankAccount account = new BankAccount(0); //(This is for single account)
        ArrayList<BankAccount> accounts = new ArrayList<>();
        
        while (account) {

        System.out.println("1. Create account ");
        System.out.println("2. Select Account");
        System.out.println("3. Exit ");

        int choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Enter initial balane: ");
                double initial = input.nextDouble();

                BankAccount newAccount = new BankAccount(initial);
                accounts.add(newAccount);
                System.out.println("Account Created ID : " + (accounts.size() - 1));
                break;

            case 2:
                System.out.println(" Enter Account ID : ");
                int id = input.nextInt();

                if(id >= 0 && id < accounts.size()){

                    BankAccount selected = accounts.get(id);

                            boolean AccountMenu = true;

                            while (AccountMenu){

                                System.out.println(" \n ________Bank Menu_________");
                                System.out.println(" 1. Deposit");
                                System.out.println(" 2. Withdraw");
                                System.out.println(" 3. Check Balance");
                                System.out.println(" 4. Exit");

                                System.out.println(" Choose Option ");
                                int choice2 = input.nextInt();
                                input.nextLine(); // for clear buffer (AFTER EVERY NUMBER INPUT)

                                switch (choice2) {
                                    case 1:
                                        //User to deposit money()
                                        System.out.println(" Enter ammount to Deposit : ");
                                        double deposit = input.nextDouble();
                                        selected.deposit(deposit);   //method call with parameter 
                                        System.out.println("Current Balance : " + selected.getBalance());  
                                        break;

                                    case 2:
                                        //User Withdrow
                                        System.out.println("Enter ammount to withdrow : ");
                                        double withdraw = input.nextDouble();
                                        selected.withdraw(withdraw);
                                        System.out.println("Current Balance : " + selected.getBalance());
                                        break;

                                    case 3:
                                        System.out.println("Current Balance : " + selected.getBalance());
                                        break;

                                    case 4:
                                        AccountMenu = false;
                                        System.out.println("Exiting....");
                                        break;
                                
                                    default:
                                        System.out.println(" Invalid choice");
                                        break;
                                }

                                System.out.println("Current Balance : " + selected.getBalance());

                            }


                }else {
                    System.out.println(" Invalid Id ");
                }
                
                break;

            case 3:
                account = false;
                System.out.println("Exiting Bank System...");
                break;
        
            default:
                break;
        }
            
            
        }

        
        input.close();

    }
}