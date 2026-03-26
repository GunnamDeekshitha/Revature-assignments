public class RestaurantOwner extends AppUser{
    String restaurantName;
     public void addMenuItem(){
         System.out.println("Item added to"+restaurantName);
     }
    void updateOrderStatus() {
        System.out.println("Updated order status in "+restaurantName);
    }
}
