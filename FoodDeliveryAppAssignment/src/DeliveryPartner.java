public class DeliveryPartner extends AppUser{
    String vehicleType;
    public void acceptDelivery(){
        System.out.println(userName+"Order accepted for Delivery");
    }
    public void updateDeliveryStatus(){
        System.out.println(userName+" updated delivery status");
    }
}
