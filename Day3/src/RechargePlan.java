public class RechargePlan {
    private int planID;
    private String planName;
    private int validityDays;
    private double price;
    RechargePlan(int planID,String planName,int validityDays,double price){
        this.planID=planID;
        this.planName=planName;
        this.validityDays=validityDays;
        this.price=price;
    }
    RechargePlan(RechargePlan plan){
        this.planID=plan.planID;
        this.planName=plan.planName;
        this.validityDays=plan.validityDays;
        this.price=plan.price;
    }
    void displayPlanDetails() {
        System.out.println("Plan ID:"+this.planID);
        System.out.println("Plan Name:"+this.planName);
        System.out.println("Validity:"+this.validityDays);
        System.out.println("Price:"+this.price);
    }
    void setPrice(double price){
        this.price=price;
    }
    void setValidityDays(int days){
        this.validityDays=days;
    }
}
