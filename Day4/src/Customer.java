public class Customer {
    protected int customerID;
    protected String customerName;
    protected String customerEmail;
    public void registerCustomer(int id, String name, String email) {
        this.customerID=id;
        this.customerName=name;
        this.customerEmail=email;
    }
    public void displayCustomer(){
        System.out.println("Customer ID:"+customerID);
        System.out.println("Customer Name:"+customerName);
        System.out.println("Customer email:"+customerEmail);
    }


}
