public class BankAccount {

    private int id;
    private double balance;  //account balance (Encapsulation data hiding)

    //Constructor to set initial balance
    public BankAccount(int id, double initialBalance){
        this.id = id;
        this.balance = initialBalance;
    }

    public int getId() {
        return id;
    }

    //Deposit Method
    public void deposit(double amount){
        balance += amount;
        System.out.println("Deposit : " + amount);
    }
    
    //Withdraw method
    public void withdraw(double amount){
        if(balance < amount){       
            System.out.println(" Not Enough Balance");    //balance less than amount 
        } else {
            balance -= amount;
            System.out.println(" Withdraw : " + amount);
        }
    }

    public double getBalance(){
        return balance;
    }

}
