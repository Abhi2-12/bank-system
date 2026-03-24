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

        //int choice = input.nextInt();  replace it with try_catch

        int choice;

        try {
            choice = input.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input ! Enter a number . ");
            input.nextLine();  //clear bad input
            continue; //restat loop
        }


        switch (choice) {
            case 1:
                System.out.println("Enter initial balane: ");
                //double initial = input.nextDouble();
                double initial;
                try {
                    initial = input.nextDouble();
                    
                } catch (Exception e) {
                    System.out.println(" invalid input");
                    input.nextLine();
                    continue;
                }

                BankAccount newAccount = new BankAccount(initial);
                accounts.add(newAccount);
                System.out.println("Account Created ID : " + (accounts.size() - 1));
                break;

            case 2:
                System.out.println(" Enter Account ID : ");
                //int id = input.nextInt();
                int id;
                
                try {
                    id = input.nextInt();
                } catch (Exception e) {
                    System.out.println("Invalid input ...plz input number");
                    input.nextLine();
                    continue;
                }
                

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
                                //int choice2 = input.nextInt();
                                //input.nextLine(); // for clear buffer (AFTER EVERY NUMBER INPUT)
                                int choice2;
                                try {
                                    choice2 = input.nextInt();
                                } catch (Exception e) {
                                    System.out.println("Invalid input..");
                                    input.nextLine();
                                    continue;
                                }

                                switch (choice2) {
                                    case 1:
                                        //User to deposit money()
                                        System.out.println(" Enter ammount to Deposit : ");
                                        //double deposit = input.nextDouble();
                                        double deposit;

                                        try {
                                            deposit = input.nextDouble();
                                        } catch (Exception e) {
                                            System.out.println("Invalid input..");
                                            input.nextLine();
                                            continue;
                                        }

                                        selected.deposit(deposit);   //method call with parameter 
                                        System.out.println("Current Balance : " + selected.getBalance());  
                                        break;

                                    case 2:
                                        //User Withdrow
                                        System.out.println("Enter ammount to withdrow : ");
                                        //double withdraw = input.nextDouble();

                                        double withdraw;
                                        try {
                                            withdraw = input.nextDouble();
                                        } catch (Exception e) {
                                            System.out.println("Invalid Input");
                                            input.nextLine();
                                            continue;
                                        }
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


                            }


                }
                
                
                else {
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