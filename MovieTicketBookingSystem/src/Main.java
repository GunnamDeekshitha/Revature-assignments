import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        MovieBooking mb=new MovieBooking();
        try {
            System.out.print("Enter name: ");
            String name=sc.nextLine();

            System.out.print("Enter movie (Leo/Jailer/Vikram): ");
            String movie=sc.nextLine();

            System.out.print("Enter tickets: ");
            int tickets=sc.nextInt();

            System.out.print("Enter payment: ");
            double payment=sc.nextDouble();
            mb.bookTicket(name, movie, tickets, payment);
            System.out.println("Cancelling booking");
            mb.cancelBooking();
            //cancel again
            mb.cancelBooking();
        }catch(InvalidCustomerNameException|
                 InvalidMovieException|
                 InvalidTicketCountException|
                 InsufficientSeatsException|
                 PaymentFailedException|
                 CancellationNotAllowedException e){
            System.out.println("Error: "+e.getMessage());
        }finally {
            System.out.println("Thank you");
        }
    }
}
