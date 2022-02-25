public class Book extends Object { //To explicitly inherit from the java.lang.Object

    private String bindingType = "Paperback";

    public String getBindingType() {
        return bindingType;
    }

    public void setBindingType(String bindingType) {
        this.bindingType = bindingType;
    }

    public void checkOutBook() {
        System.out.println("The book has been checked out successfully!");
    }
}
