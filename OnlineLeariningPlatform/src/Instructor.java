public class Instructor extends User {
    String subject;
    int yearsOfExperience;
    void uploadCourse(){
        System.out.println(name+" uploaded a course on "+subject);
    }
    void conductSession() {
        System.out.println(name+" is conducting a session");
    }
}