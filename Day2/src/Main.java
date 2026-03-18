//Day 2 Assignment
import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Account Number:");
        int accountNumber=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Customer Name:");
        String customerName=sc.nextLine();
        System.out.println("Enter Account Type:");
        String accountType=sc.nextLine();
        System.out.println("Enter Initial Balance:");
        double balance=sc.nextDouble();
        BankAccount obj=new BankAccount(accountNumber,customerName,accountType,balance);
        System.out.println("\nAccount Details");
        obj.displayAccountInfo();
        System.out.println("\nEnter deposit amount:");
        double dep=sc.nextDouble();
        obj.deposit(dep);
        System.out.println("\nEnter withdrawal amount:");
        double wd=sc.nextDouble();
        obj.withdraw(wd);
        sc.close();
    }
}