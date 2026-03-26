import java.util.*;

public class Appointments {
    public static void main(String[] args){
        List<String> appointments=new ArrayList<>();
        appointments.add("Krishna");
        appointments.add("Raju");
        appointments.add("Ram");
        appointments.add("Rakesh");
        appointments.add("Ram");

        System.out.println("Appointments:"+appointments);

        appointments.add(1,"Bheem");
        System.out.println("After Emergency Entry: "+appointments);

        appointments.set(2,"Rajesh");
        System.out.println("After Update: "+appointments);

        appointments.remove("Krishna");
        System.out.println("After appointment cancellation:"+appointments);

        System.out.println("Is Ramu present?"+appointments.contains("Ramu"));

        System.out.println("Total Appointments: "+appointments.size());

        System.out.println("First occurence of Ram:"+appointments.indexOf("Ram"));
        System.out.println("Last occurence of Ram:"+appointments.lastIndexOf("Ram"));

        System.out.println("Traversing List:");
        for(String patient:appointments){
            System.out.println(patient);
        }

        appointments.clear();
        System.out.println("After clearing all appointments:"+appointments);





    }
}
