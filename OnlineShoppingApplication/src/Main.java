import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Product> products=new ArrayList<>();
        products.add(new Product(1,"iPhone 15", "Electronics", "Apple", 80000, 10, 4.8, 10, true));
        products.add(new Product(2,"Samsung TV", "Electronics", "Samsung", 45000, 5, 4.3, 15, true));
        products.add(new Product(3,"Shoes", "Fashion", "Nike", 3000, 0, 4.6, 20, false));
        products.add(new Product(4, "T-Shirt", "Fashion", "Puma", 1500, 20, 4.1, 5, true));
        products.add(new Product(5, "Laptop", "Electronics", "Dell", 65000, 7, 4.7, 12, true));
        products.add(new Product(6, "Rice Bag", "Grocery", "IndiaGate", 2500, 50, 4.0, 8, true));

        System.out.println("All products:");
        products.forEach(p -> System.out.println(p.productName));

        System.out.println("Products price greater than 5000:");
        products.stream().filter(p ->p.price>5000).forEach(System.out::println);

        System.out.println("Products belong to electronics category:");
        products.stream().filter(p->p.category.equals("Electronics")).forEach(System.out::println);

        System.out.println("Products in stock:");
        products.stream().filter(p->p.inStock).forEach(System.out::println);

        System.out.println("Price sorting in Ascending order");
        products.stream().sorted((p1,p2)->Double.compare(p1.price, p2.price)).forEach(System.out::println);

        System.out.println("Price sorting in descending order");
        products.stream().sorted((p1,p2)->Double.compare(p2.price,p1.price)).forEach(System.out::println);

        System.out.println("Rating High to Low:");
        products.stream().sorted((p1, p2)->Double.compare(p2.rating,p1.rating)).forEach(System.out::println);

        System.out.println("Alphabetical sorting:");
        products.stream().sorted((p1,p2)->p1.productName.compareTo(p2.productName)).forEach(System.out::println);

        System.out.println("Product above 70000: "+products.stream().anyMatch(p->p.price > 70000));

        System.out.println("Rating above 3.5:"+products.stream().allMatch(p->p.rating>3.5));

        System.out.println("Non medical:"+products.stream().noneMatch(p->p.category.equals("Medical")));

        System.out.println("Maximum price:");
        products.stream().max(Comparator.comparing(p->p.price)).ifPresent(System.out::println);

        System.out.println("Minimum price:");
        products.stream().min(Comparator.comparing(p->p.price)).ifPresent(System.out::println);

        System.out.println("Increase Electronics by 5%:");
        products.stream().filter(p->p.category.equals("Electronics")).forEach(p->p.price*=1.05);
        products.forEach(System.out::println);

        System.out.println("Extra 10% discount for Fashion:");
        products.stream().filter(p->p.category.equals("Fashion")).forEach(p->p.discountPercentage+=10);
        products.forEach(System.out::println);

        System.out.println("Mark stock 0 as out of stock");
        products.forEach(p->{if(p.stock==0) p.inStock=false;});
        products.forEach(System.out::println);

        long fashionCount=products.stream().filter(p->p.category.equals("Fashion")).count();
        System.out.println("Fashion count:"+fashionCount);

        long highRating=products.stream().filter(p->p.rating>4.5).count();
        System.out.println("Rating greater than 4.5:"+highRating);

        long outStock=products.stream().filter(p->!p.inStock).count();
        System.out.println("Out of stock count is :"+outStock);
    }
}
