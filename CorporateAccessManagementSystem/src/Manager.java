public class Manager extends Employee implements Authenticatable,ReportAccessible{
    int teamSize;

    public void approveLeave(){
        System.out.println("Leave is approved for "+name+" with Employee code "+employeeCode);
    }
    public void conductTeamMeeting(){
        System.out.println(name+" is conducting meeting");
    }
    public void login(){
        System.out.println(name+" logged in successfully");
    }
    public void accessReports(){
        System.out.println(name+" is accessing reports");
    }

}
