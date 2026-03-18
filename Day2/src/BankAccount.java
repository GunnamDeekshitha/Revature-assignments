//Day 2 Assignment
class BankAccount {
    private int accountNumber;
    private String customerName;
    private String accountType;
    private double balance;
    BankAccount(int accountNumber, String customerName, String accountType, double balance){
        this.accountNumber=accountNumber;
        this.customerName=customerName;
        this.accountType=accountType;
        this.balance=balance;
    }
    void displayAccountInfo(){
        System.out.println("Account Number: "+this.accountNumber);
        System.out.println("Customer Name: "+this.customerName);
        System.out.println("Account Type: "+this.accountType);
        System.out.println("Balance: "+this.balance);
    }
    void deposit(double amount){
        if(amount<=0){
            System.out.println("Deposit amount should be positive");
        }else{
            this.balance+=amount;
            System.out.println("Amount Deposited: "+amount);
            System.out.println("Updated Balance: "+this.balance);
        }
    }
    void withdraw(double amount){
        if(amount<=0){
            System.out.println("Withdrawal amount should be positive");
        }
        else if(this.balance-amount<1000){
            System.out.println("Insufficient balance,minimum balance of 1000 should be there");
        }
        else{
            this.balance-=amount;
            System.out.println("Amount Withdrawn: "+amount);
            System.out.println("Remaining Balance: "+this.balance);
        }
    }
}

