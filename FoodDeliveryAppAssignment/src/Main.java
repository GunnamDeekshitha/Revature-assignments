public class Main {
    public static void main(String[] args){
        Customer customer=new Customer();
        customer.userId=1;
        customer.userName="Deekshitha";
        customer.phoneNo="9876543211";
        customer.deliveryAddress="Chennai";
        customer.login();
        customer.placeOrder();
        customer.viewOrderHistory();
        customer.logout();

        DeliveryPartner deliveryPartner=new DeliveryPartner();
        deliveryPartner.userId=2;
        deliveryPartner.userName="Krishna";
        deliveryPartner.phoneNo="9988776655";
        deliveryPartner.vehicleType="Bike";
        deliveryPartner.login();
        deliveryPartner.acceptDelivery();
        deliveryPartner.updateDeliveryStatus();
        deliveryPartner.logout();

        RestaurantOwner restaurantOwner=new RestaurantOwner();
        restaurantOwner.userId=3;
        restaurantOwner.userName="Bhargav";
        restaurantOwner.phoneNo="9888776655";
        restaurantOwner.restaurantName="Ambrocious";
        restaurantOwner.login();
        restaurantOwner.addMenuItem();
        restaurantOwner.updateOrderStatus();
        restaurantOwner.logout();
    }
}
