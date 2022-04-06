import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/* Note: In case that we want to add an object to TreeSet but that object doesn't implement
the "Comparable" interface, and we don't have control over that object, we still can add
that object to TreeSet by specifying the "Comparator" in the TreeSet
 */

// Assume that we can't have control over the Product objet to implement "Comparable" interface
public class TreeSet_Comparator {
    public static void main(String[] args) {

        // Creating an anonymous class using "Comparator" interface
        Comparator<Product> productComparator = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                int compareName = o1.getName().compareTo(o2.getName());

                if (compareName != 0) {
                    return compareName;
                }

                return o1.getCategory().compareTo(o2.getCategory());
            }
        };

        // Specifying the "Comparator" in TreeSet
        SortedSet<Product> productSet = new TreeSet<>(productComparator);

        Product phone = new Product("iPhone", "Mobiles");
        Product tv = new Product("Samsung", "Electronics");
        Product jeans = new Product("Levis", "Apparel");
        Product watch = new Product("Rolex", "Accessories");

        productSet.add(phone);
        productSet.add(tv);
        productSet.add(jeans);
        productSet.add(watch);

        for (Product product : productSet) {
            System.out.println(product);
        }

        System.out.println();
    }
}
