import java.util.TreeSet;
public class TreeSetImplementation {
    public static void main(String[] args){
        TreeSet<String> treeSet=new TreeSet<>();
        treeSet.add("Java");
        treeSet.add("SQL");
        treeSet.add("Spring Boot");
        treeSet.add("Java");
        treeSet.add("React");
        treeSet.add("Docker");
        treeSet.add("SQL");
        treeSet.add("AWS");

        System.out.println("Skills:"+treeSet);
        //task 3-check whether react exists
        System.out.println("React exists or not?"+treeSet.contains("React"));
        //task 4-remove docker
        treeSet.remove("Docker");
        System.out.println("After removal of Docker:"+treeSet);
        //task 5- size of the set
        System.out.println("Size:"+treeSet.size());

    }

}
