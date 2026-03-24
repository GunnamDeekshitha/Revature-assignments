public class SeniorInstructor extends Instructor {
    int mentorBatchCount;
    String specialization;
    void reviewContent(){
        System.out.println(name +"is reviewing content");
    }
    void assignInstructorTasks(){
        System.out.println(name +" assigned tasks");
    }
    void displayFullProfile(){
        displayUser();
        System.out.println("Subject:"+subject);
        System.out.println("Experience:"+yearsOfExperience +" years");
        System.out.println("Mentor Batch Count:"+mentorBatchCount);
        System.out.println("Specialization:"+specialization);
    }
}