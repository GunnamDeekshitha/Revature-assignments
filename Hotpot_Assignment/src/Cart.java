public class Cart {
    private int cartID;
    private Menu item;
    private int quantity;
    private double totalPrice;

    public Cart(){
    }
    public Cart(int cartID,Menu item,int quantity){
        setCartId(cartID);
        this.item=item;
        setQuantity(quantity);
        calculateTotal();
    }
    public int getCartID(){
        return cartID;
    }
    public void setCartId(int cartID) {
        if (cartID> 0)
            this.cartID = cartID;
    }

    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        if(quantity>0){
            this.quantity=quantity;
        }else{
            System.out.println("Quantity must be greater than 0");
        }
    }
    public void calculateTotal(){
        totalPrice=item.getPrice()*quantity;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public void displayCart() {
        System.out.println("Cart ID: "+cartID);
        item.displayItem();
        System.out.println("Quantity:"+quantity);
        System.out.println("Total:"+totalPrice);
    }

}
