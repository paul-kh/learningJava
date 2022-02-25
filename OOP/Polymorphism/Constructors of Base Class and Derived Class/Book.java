import javax.annotation.processing.SupportedSourceVersion;

public class Book {

    private String name = "unknown";
    private String author = "unknown";

    public String getName() {
        return this.name;
    }

    // Default no-argument constructor
    public Book() {
        System.out.println("Book()");
    }

    // Parameterized constructor
    public Book(String name) {
        this.name = name;

        System.out.println("Book(String name)");
    }

    // Parameterized constructor
    public Book(String name, String author){
        this(name);
        this.author = author;

        System.out.println("Book(String name, String author)");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void checkOutBook() {
        System.out.format("The book: %s has been checked out successfully!", name);
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Author: %s", name, author);
    }
}
