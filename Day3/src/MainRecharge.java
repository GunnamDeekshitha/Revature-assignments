public class MainRecharge {
    public static void main(String[] args){
        RechargePlan plan1=new RechargePlan(100,"Base plan",28,199);
        RechargePlan plan2=new RechargePlan(plan1);
        System.out.println("Original Plan details");
        plan1.displayPlanDetails();
        System.out.println("Copied Plan details");
        plan2.displayPlanDetails();
        plan2.setPrice(250);
        plan2.setValidityDays(40);
        System.out.println("After modification of copy plan");
        plan2.displayPlanDetails();
    }
}
