public class Main1 {
    public static void main(String[] args){
        Employee employee=new Employee(5018,"Deekshitha",80000,20000,5);
        employee.displaySalarySlip();
        employee.setBasicSalary(100000);
        employee.setTaxPercentage(7);
        employee.displaySalarySlip();
    }

}
