public class Main {
    public static void main(String[] args){
        Manager manager=new Manager();
        manager.personId=001;
        manager.name="Deekshitha";
        manager.department="Development";
        manager.employeeCode="EMP001";
        manager.teamSize=5;

        manager.displayPersonInfo();
        manager.accessEmployeePortal();
        manager.approveLeave();
        manager.conductTeamMeeting();
        manager.login();
        manager.accessReports();
    }
}
