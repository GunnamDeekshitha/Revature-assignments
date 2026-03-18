public class Product{
    private int productId;
    private String productName;
    private double price;
    private double discountPercentage;
    private int stockQuantity;
    public Product(int productId,String productName,double price,double discountPercentage,int stockQuantity){
        this.productId = productId;
        this.productName=productName;
        this.price=price;
        this.discountPercentage=discountPercentage;
        this.stockQuantity=stockQuantity;
    }
    public int getProductId() {
        return this.productId;
    }
    public String getProductName() {
        return this.productName;
    }
    public void setProductName(String productName) {
        if(productName==null){
            System.out.println("Product name cannot be blank");
        }else{
            this.productName=productName;
        }
    }
    public double getPrice() {
        return this.price;
    }
    public void setPrice(double price) {
        if(price>0){
            this.price=price;
        }else{
            System.out.println("Price must be greater than 0");
        }
    }
    public double getDiscountPercentage() {
        return this.discountPercentage;
    }
    public void setDiscountPercentage(double discountPercentage){
        if(discountPercentage>=0 && discountPercentage<=60){
            this.discountPercentage=discountPercentage;
        }else{
            System.out.println("Discount should be between 0 and 60");
        }
    }
    public int getStockQuantity() {
        return this.stockQuantity;
    }
    public void setStockQuantity(int stockQuantity) {
        if(stockQuantity>=0){
            this.stockQuantity=stockQuantity;
        }else{
            System.out.println("Stock cannot be negative");
        }
    }
    public double calculateDiscountAmount() {
        return (this.price*this.discountPercentage)/100;
    }
    public double calculateFinalPrice() {
        return this.price-calculateDiscountAmount();
    }
    public void sellProduct(int qty) {
        if(qty<=0){
            System.out.println("Quantity must be positive");
        }else if(qty > this.stockQuantity) {
            System.out.println("Insufficient stock!");
        }else{
            this.stockQuantity-=qty;
            System.out.println(qty+" product sold.");
            System.out.println("Remaining stock: " + this.stockQuantity);
        }
    }
    public void displayProductDetails() {
        System.out.println("\nProduct Details");
        System.out.println("Product ID: " + this.productId);
        System.out.println("Product Name: " + this.productName);
        System.out.println("Original Price: " + this.price);
        System.out.println("Discount %: " + this.discountPercentage);
        System.out.println("Stock: " + this.stockQuantity);
        System.out.println("Discount Amount: " + calculateDiscountAmount());
        System.out.println("Final Price: " + calculateFinalPrice());
    }
}