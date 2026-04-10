import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) {

        // For input
        Scanner input = new Scanner(System.in);

        // Bank account Object
        // Initialize Database Table
        TestDB.createTable();
        ArrayList<BankAccount> accounts = TestDB.loadAccounts();
        /*
         * File file = new File("accounts.txt");
         * 
         * try {
         * Scanner fileReader = new Scanner(file);
         * 
         * while (fileReader.hasNextLine()) {
         * double balance = Double.parseDouble(fileReader.nextLine());
         * accounts.add(new BankAccount(balance));
         * }
         * fileReader.close();
         * 
         * } catch (Exception e) {
         * System.out.println("No previous data found");
         * }
         */

        boolean account = true;
        while (account) {

            System.out.println("1. Create account ");
            System.out.println("2. Select Account");
            System.out.println("3. Exit ");

            // int choice = input.nextInt(); replace it with try_catch

            int choice;

            try {
                choice = input.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input ! Enter a number . ");
                input.nextLine(); // clear bad input
                continue; // restat loop
            }

            switch (choice) {
                case 1:
                    System.out.println("Enter initial balance: ");
                    // double initial = input.nextDouble();
                    double initial;
                    try {
                        initial = input.nextDouble();

                    } catch (Exception e) {
                        System.out.println(" invalid input");
                        input.nextLine();
                        continue;
                    }

                    BankAccount newAccount = TestDB.createNewAccount(initial);
                    if (newAccount != null) {
                        accounts.add(newAccount);
                        System.out.println("Account Created ID : " + newAccount.getId());
                    } else {
                        System.out.println("Failed to create account in DB.");
                    }
                    break;

                case 2:
                    System.out.println(" Enter Account ID : ");
                    // int id = input.nextInt();
                    int id;

                    try {
                        id = input.nextInt();
                    } catch (Exception e) {
                        System.out.println("Invalid input ...plz input number");
                        input.nextLine();
                        continue;
                    }

                    BankAccount selected = null;
                    for (BankAccount acc : accounts) {
                        if (acc.getId() == id) {
                            selected = acc;
                            break;
                        }
                    }

                    if (selected != null) {

                        boolean AccountMenu = true;

                        while (AccountMenu) {

                            System.out.println(" \n ________Bank Menu_________");
                            System.out.println(" 1. Deposit");
                            System.out.println(" 2. Withdraw");
                            System.out.println(" 3. Check Balance");
                            System.out.println(" 4. Exit");

                            System.out.println(" Choose Option ");
                            // int choice2 = input.nextInt();
                            // input.nextLine(); // for clear buffer (AFTER EVERY NUMBER INPUT)
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
                                    // User to deposit money()
                                    System.out.println(" Enter amount to Deposit : ");
                                    // double deposit = input.nextDouble();
                                    double deposit;

                                    try {
                                        deposit = input.nextDouble();
                                    } catch (Exception e) {
                                        System.out.println("Invalid input..");
                                        input.nextLine();
                                        continue;
                                    }

                                    selected.deposit(deposit); // method call with parameter
                                    System.out.println("Current Balance : " + selected.getBalance());
                                    break;

                                case 2:
                                    // User Withdraw
                                    System.out.println("Enter amount to withdraw : ");
                                    // double withdraw = input.nextDouble();

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

        /*
         * try {
         * PrintWriter writer = new PrintWriter(file);
         * 
         * for (BankAccount acc : accounts){
         * writer.println(acc.getBalance());
         * }
         * writer.close();
         * System.out.println("Data saved...");
         * } catch (Exception e) {
         * System.out.println("Error Saving data.");
         * }
         */

        TestDB.saveAccounts(accounts);
        System.out.println("Data saved to Database...");

        input.close();

    }
}