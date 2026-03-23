public class MainHotpot{
    public static void main(String[] args){
        CustomerHotpot customer=new CustomerHotpot(1,"Deekshitha","deekshithag@gmail.com","9876543211","Hyderabad");
        Restaurant restaurant=new Restaurant(101,"Hotpot","Chennai","9876543217");
        Menu m1=new Menu(1,"Burger","Zinger chicken burger","Snack",200,true,"NonVeg");
        Menu m2=new Menu(2,"Sandwich","Veg Sandwich with cheese","Snack",100,true,"Veg");
        Menu m3=new Menu(3,"Chicken Biryani","Chicken hyderabadi dum biryani","Main course",300,true,"Nonveg");
        Cart cart=new Cart(1 ,m1, 2);
        cart.displayCart();
        Order order=new Order(201,customer,restaurant,cart);


    }
}
