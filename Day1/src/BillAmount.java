//Day 1 assignment
import java.util.Scanner;
public class BillAmount {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your ID");
        String ID=sc.next();
        System.out.println("Enter your units consumed:");
        int units=sc.nextInt();
        double totalcost=0;
        if(units<=100){
            totalcost=units*5;
        }
        else if(units<=250){
            totalcost=(100*5)+(units-100)*8.5;
        }
        else if(units<=500){
            totalcost=(100*5)+(150*8.5)+(units-250)*12.5;
        }
        else{
            totalcost=(100*5)+(150*8.5)+(250*12.5)+(units-500)*15;
        }
        System.out.println("Total bill amount is :"+totalcost);
    }
}

