public class Main {
    public static void main(String[] args) {
        SeniorInstructor seniorInstructor = new SeniorInstructor();
        seniorInstructor.userID=5018;
        seniorInstructor.name="Deekshitha";
        seniorInstructor.subject="Java";
        seniorInstructor.yearsOfExperience=5;
        seniorInstructor.mentorBatchCount=30;
        seniorInstructor.specialization="Backend Development";

        seniorInstructor.login();//user level
        seniorInstructor.displayUser();// user level
        seniorInstructor.uploadCourse();// Instructor level
        seniorInstructor.conductSession();// Instructor level
        seniorInstructor.reviewContent();// SeniorInstructor level
        seniorInstructor.assignInstructorTasks(); // SeniorInstructor level
        seniorInstructor.displayFullProfile();
    }
}
