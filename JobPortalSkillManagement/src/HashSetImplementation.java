import java.util.HashSet;

public class HashSetImplementation {
    public static void main(String[] args){
        HashSet<String> hashSet=new HashSet<>();
        hashSet.add("Java");
        hashSet.add("SQL");
        hashSet.add("Spring Boot");
        hashSet.add("Java");
        hashSet.add("React");
        hashSet.add("Docker");
        hashSet.add("SQL");
        hashSet.add("AWS");

        System.out.println("Skills :"+hashSet);
        //task 3-check whether react exists
        System.out.println("React exists or not?"+hashSet.contains("React"));
        //task 4-remove docker
        hashSet.remove("Docker");
        System.out.println("After removal of Docker:"+hashSet);
        //task 5- size of the set
        System.out.println("Size:"+hashSet.size());

    }
}
