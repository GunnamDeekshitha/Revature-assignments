//Day 3 Assignment
public class Employee {
    private int employeeID;
    private String employeeName;
    private double basicSalary;
    private double allowance;
    private double taxPercentage;
    public Employee(int employeeID, String employeeName, double basicSalary, double allowance, double taxPercentage) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.basicSalary = basicSalary;
        this.allowance = allowance;
        this.taxPercentage = taxPercentage;
    }
    public int getEmployeeID() {
        return this.employeeID;
    }
    public String getEmployeeName() {
        return this.employeeName;
    }
    public void setEmployeeName(String employeeName) {
        if(employeeName==null){
            System.out.println("Employee name should not be blank");
        }
        else{
            this.employeeName = employeeName;
        }
    }
    public double getBasicSalary(){
        return this.basicSalary;
    }
    public void setBasicSalary(double basicSalary){
        if (basicSalary<0){
            System.out.println("Basic salary should not be negative");
        }else{
            this.basicSalary=basicSalary;
        }
    }
    public double getTaxPercentage() {
        return this.taxPercentage;
    }
    public void setTaxPercentage(double taxPercentage) {
        if (taxPercentage>0.0 && taxPercentage<30.0){
            this.taxPercentage=taxPercentage;
        }
        else{
            System.out.println("Tax percentage should be between 0 and 30");
        }
    }
    public double calculateGrossSalary(){
        return this.basicSalary+this.allowance;
    }
    public double calculateTaxAmount(){
        return (calculateGrossSalary()*this.taxPercentage)/100;
    }
    public double calculateNetSalary(){
        return calculateGrossSalary()-calculateTaxAmount();
    }
    public void displaySalarySlip(){
        System.out.println("\nSalary Slip");
        System.out.println("Employee ID:"+this.employeeID);
        System.out.println("Employee Name:"+this.employeeName);
        System.out.println("Basic Salary:"+this.basicSalary);
        System.out.println("Allowance:"+this.allowance);
        System.out.println("Tax %:"+this.taxPercentage);
        System.out.println("Gross Salary:"+calculateGrossSalary());
        System.out.println("Tax Amount:"+calculateTaxAmount());
        System.out.println("Net Salary:"+calculateNetSalary());
    }
}
