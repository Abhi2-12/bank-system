public class BankAccount {

    private double balance;  //account balance (Encapsulation data hiding)

    //Constructor to set initial balance
    public BankAccount(double initialBalance){
        balance = initialBalance;
    }

    //Deposit Method   and perameter passing
    public void deposit(double ammount){
        balance += ammount;
        System.out.println("Deposit : " + ammount);
    }
    
    //Withdrow method
    public void withdraw(double ammount){
        if(balance < ammount){       
            System.out.println(" Not Enought Balance");    //balance less than ammount 
        } else {
            balance -= ammount;
            System.out.println(" Withdrow : " +ammount);
        }
    }

    public double getBalance(){
        return balance;
    }

    
}
