import java.util.*;
class InvalidCustomerNameException extends Exception{
    public InvalidCustomerNameException(String msg){
        super(msg);
    }
}
class InvalidMovieException extends Exception{
    public InvalidMovieException(String msg){
        super(msg);
    }
}
class InvalidTicketCountException extends Exception{
    public InvalidTicketCountException(String msg){
        super(msg);
    }
}
class InsufficientSeatsException extends Exception{
    public InsufficientSeatsException(String msg){
        super(msg);
    }
}
class PaymentFailedException extends Exception{
    public PaymentFailedException(String msg){
        super(msg);
    }
}
class CancellationNotAllowedException extends Exception{
    public CancellationNotAllowedException(String msg){
        super(msg);
    }
}

public class MovieBooking {
    String customerName;
    String movieName;
    int tickets;
    double pricePerTicket=200;
    int availableSeats=5;
    boolean isCancelled=false;

    void bookTicket(String name,String movie,int count,double payment)
            throws InvalidCustomerNameException, InvalidMovieException,
            InvalidTicketCountException, InsufficientSeatsException,
            PaymentFailedException {
        if(name==null||name.isEmpty()){
            throw new InvalidCustomerNameException("Customer name cannot be empty");
        }
        if(!(movie.equals("Leo")||movie.equals("Jailer")||movie.equals("Vikram"))){
            throw new InvalidMovieException("Invalid movie selected");
        }
        if(count<=0){
            throw new InvalidTicketCountException("Ticket count must be > 0");
        }
        if(count>availableSeats){
            throw new InsufficientSeatsException("Not enough seats available");
        }
        double totalAmount=count*pricePerTicket;
        if(payment<totalAmount){
            throw new PaymentFailedException("Insufficient payment");
        }
        customerName=name;
        movieName=movie;
        tickets=count;
        availableSeats-=count;
        System.out.println("Booking successful for " + customerName +
                " | Movie: " + movieName +
                " | Tickets: " + tickets);

    }
    void cancelBooking() throws CancellationNotAllowedException {
        if(isCancelled){
            throw new CancellationNotAllowedException("Booking already cancelled");
        }
        isCancelled=true;
        availableSeats+=tickets;
        System.out.println("Booking cancelled successfully");
    }


    }
