public class Order {
    private int orderID;
    private CustomerHotpot customer;
    private Restaurant restaurant;
    private Cart cart;
    private String orderStatus;
    public Order(){
        this.orderID=0;
        this.customer=null;
        this.restaurant=null;
        this.cart=null;
        this.orderStatus="Not known";
    }
    public Order(int orderID, CustomerHotpot customer, Restaurant restaurant, Cart cart){
        setOrderID(orderID);
        this.customer=customer;
        this.restaurant=restaurant;
        this.cart=cart;
        this.orderStatus="Order Placed";
    }
    public int getOrderID(){
        return orderID;
    }
    public void setOrderID(int orderID){
        if(orderID>0){
            this.orderID=orderID;
        }else{
            System.out.println("Order ID should be greater than 0");
        }
    }
    public String getOrderStatus() {
        return orderStatus;
    }
    public void updateStatus(String status) {
        this.orderStatus = status;
    }
    public void displayOrder() {
        System.out.println("Order ID: " + orderID);
        customer.displayCustomer();
        restaurant.displayRestaurantDetails();
        cart.displayCart();
        System.out.println("Status: "+orderStatus);
        System.out.println("Final Amount: "+cart.getTotalPrice());
    }
}
