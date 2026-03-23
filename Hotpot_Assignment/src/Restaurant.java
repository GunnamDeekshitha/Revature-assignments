public class Restaurant {
    private int restaurantID;
    private String restaurantName;
    private String restaurantLocation;
    private String contactNumber;

    public Restaurant(){
        this.restaurantID=0;
        this.restaurantName="Unknown";
        this.restaurantLocation="Not Available";
        this.contactNumber="Not given";
    }
    public Restaurant(int restaurantID,String restaurantName,String restaurantLocation,String contactNumber){
        setRestaurantID(restaurantID);
        this.restaurantName=restaurantName;
        this.restaurantLocation=restaurantLocation;
        this.contactNumber=contactNumber;
    }
    public int getRestaurantID(){
        return restaurantID;
    }
    public void setRestaurantID(int restaurantID) {
        if(restaurantID>0){
            this.restaurantID = restaurantID;
        }else{
            System.out.println("Restaurant ID should be greater than 0");
        }
    }
    public String getRestaurantName(){
        return restaurantName;
    }
    public void setRestaurantName(String restaurantName){
        this.restaurantName=restaurantName;
    }
    public String getRestaurantLocation(){
        return restaurantLocation;
    }
    public void setRestaurantLocation(String restaurantLocation){
        this.restaurantLocation=restaurantLocation;
    }
    public String getContactNumber(){
        return contactNumber;
    }
    public void setContactNumber(String contactNumber){
        this.contactNumber=contactNumber;
    }
    public void displayRestaurantDetails(){
        System.out.println("Restaurant ID:"+restaurantID);
        System.out.println("Restaurant Name:"+restaurantName);
        System.out.println("Restaurant Location:"+restaurantLocation);
        System.out.println("Restaurant Contact Number:"+contactNumber);
    }

}
