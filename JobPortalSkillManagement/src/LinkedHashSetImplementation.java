import java.util.LinkedHashSet;
public class LinkedHashSetImplementation {
    public static void main(String[] args){
        LinkedHashSet<String> linkedHashSet=new LinkedHashSet<>();
        linkedHashSet.add("Java");
        linkedHashSet.add("SQL");
        linkedHashSet.add("Spring Boot");
        linkedHashSet.add("Java");
        linkedHashSet.add("React");
        linkedHashSet.add("Docker");
        linkedHashSet.add("SQL");
        linkedHashSet.add("AWS");

        System.out.println("SKills:"+linkedHashSet);
        //task 3-check whether react exists
        System.out.println("React exists or not?"+linkedHashSet.contains("React"));
        //task 4-remove docker
        linkedHashSet.remove("Docker");
        System.out.println("After removal of Docker:"+linkedHashSet);
        //task 5- size of the set
        System.out.println("Size:"+linkedHashSet.size());
    }
}
