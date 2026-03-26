import java.util.*  ;

public class Product {
    int productId;
    String productName;
    String category;
    String brand;
    double price;
    int stock;
    double rating;
    double discountPercentage;
    boolean inStock;

    public Product(int productId,String productName,String category,String brand,double price,int stock,double rating,double discountPercentage,boolean inStock){
        this.productId=productId;
        this.productName=productName;
        this.category=category;
        this.brand=brand;
        this.price=price;
        this.stock=stock;
        this.rating=rating;
        this.discountPercentage=discountPercentage;
        this.inStock=inStock;
    }
    @Override
    public String toString() {
        return productName+"| ₹" + price+"| "+category +"| Rating: "+rating;
    }

}
