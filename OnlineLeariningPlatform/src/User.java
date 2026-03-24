public class User {
    int userID;
    String name;
    void login(){
        System.out.println(name + " has logged in.");
    }
    void displayUser(){
        System.out.println("User ID: "+userID);
        System.out.println("Name: "+name);
    }
}
