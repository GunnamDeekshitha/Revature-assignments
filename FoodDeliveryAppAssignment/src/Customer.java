public class Customer extends AppUser{
    String deliveryAddress;
    public void placeOrder(){
        System.out.println(userName+" placed order to "+deliveryAddress);
    }
    public void viewOrderHistory(){
        System.out.println(userName+" viewing orders");
    }

}
