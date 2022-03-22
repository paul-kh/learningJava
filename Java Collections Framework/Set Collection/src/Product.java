import java.util.Objects;
public class Product {

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
}
