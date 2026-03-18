public class Main2 {
    public static void main(String[] args) {
        Product product = new Product(120,"Laptop",50000,10,20);
        product.displayProductDetails();
        product.sellProduct(5);
        product.setPrice(55000);
        product.setDiscountPercentage(15);
        product.displayProductDetails();
    }
}
