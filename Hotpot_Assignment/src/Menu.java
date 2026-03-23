public class Menu {
    private int itemID;
    private String itemName;
    private String description;
    private String category;
    private double price;
    private boolean availability;
    private String foodType;

    public Menu(){
        this.itemID=0;
        this.itemName="Unknown";
        this.description="No description";
        this.category="Unknown";
        this.price=0.0;
        this.availability=false;
        this.foodType="Veg";
    }
    public Menu(int itemID,String itemName,String description,String category,double price,boolean availability,String foodType){
        setItemID(itemID);
        this.itemName=itemName;
        this.description=description;
        this.category=category;
        setPrice(price);
        this.availability=availability;
        this.foodType=foodType;
    }
    public int getItemID(){
        return itemID;
    }
    public void setItemID(int itemID) {
        if(itemID>0){
            this.itemID = itemID;
        }else{
            System.out.println("Item ID should be greater than 0");
        }
    }
    public String getItemName(){
        return itemName;
    }
    public void setItemName(String itemName){
        this.itemName=itemName;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public String getCategory(){
        return category;
    }
    public void setCategory(String category){
        this.category=category;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        if(price>0){
            this.price=price;
        }
        else{
            System.out.println("Invalid Price");
        }
    }
    public boolean isAvailability(){
        return availability;
    }
    public void setAvailability(boolean availability){
        this.availability=availability;
    }
    public String getFoodType(){
        return foodType;
    }
    public void setFoodType(String foodType){
        this.foodType=foodType;
    }
    public void displayItem() {
        System.out.println("Item ID:"+itemID);
        System.out.println("Item Name:"+itemName);
        System.out.println("Item description"+description);
        System.out.println("Item Category"+category);
        System.out.println("Item price:"+price);
    }
}
