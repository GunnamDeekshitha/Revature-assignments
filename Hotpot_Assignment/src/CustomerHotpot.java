public class CustomerHotpot {
    private int customerID;
    private String customerName;
    private String emailID;
    private String phoneNo;
    private String address;

    public CustomerHotpot(){
        this.customerID=0;
        this.customerName="Unknown";
        this.emailID="Not Available";
        this.phoneNo="Not Available";
        this.address="Not Available";
    }

    public CustomerHotpot(int customerID, String customerName, String emailID, String phoneNo, String address) {
        this.customerID=customerID;
        this.customerName=customerName;
        this.emailID=emailID;
        this.phoneNo=phoneNo;
        this.address=address;
    }
    public int getCustomerID() {
        return customerID;
    }
    public void setCustomerID(int customerID) {
        if(customerID>0){
            this.customerID = customerID;
        }else{
            System.out.println("Customer ID should be greater than 0");
        }
    }
    public String getCustomerName(){
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getEmailID(){
        return emailID;
    }
    public void setEmailID(String emailID){
        if(emailID!=null && emailID.contains("@")){
            this.emailID=emailID;
        }else{
            System.out.println("Email ID must contain '@'");
        }
    }
    public String getPhoneNo(){
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo){
        if(phoneNo!=null && phoneNo.length()==10){
            this.phoneNo = phoneNo;
        }else{
            System.out.println("Phone number must be exactly 10 digits");
        }
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public void displayCustomer() {
        System.out.println("Customer ID:"+customerID ) ;
        System.out.println("Customer Name:"+customerName);
        System.out.println("Customer email:"+emailID);
        System.out.println("Phone number:"+phoneNo);
        System.out.println("Address:"+address);
    }

}
