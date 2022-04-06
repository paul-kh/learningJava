import java.util.Objects;

// Make the Product class implement Comparable interface
// So Product object becomes comparable and can be added to TreeSet
public class Product implements Comparable<Product> {

    private String name;
    private String category;

    public Product(String name, String category) {
        this.name = name;
        this.category = category;
    }

    @Override
    public String toString() {
        return String.format("\n{name=%s, category=%s}", name, category);
    }

    // We have to modify the .hashCode() method to allow HashSet identify the duplicate between 2 product objects
    @Override
    public int hashCode() {
        return Objects.hash(name, category);
    }

    // We also have to modify the .equal() method to allow HashSet identify the duplicate between 2 product objects
    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }

        if (!(other instanceof Product)) {
            return false;
        }

        Product otherProduct = (Product) other;

        if (otherProduct.name.equals(this.name) &&
                otherProduct.category.equals(this.category)) {
            return true;
        }

        return false;
    }

    // Make product object comparable and can be added to TreeSet
    // The "compareTo" is the single method in the "Comparable" interface
    @Override
    public int compareTo(Product o) {

        int compareName = this.name.compareTo(o.name);

        if (compareName != 0) {
            return compareName;
        }

        return this.category.compareTo(o.category);
    }
}
