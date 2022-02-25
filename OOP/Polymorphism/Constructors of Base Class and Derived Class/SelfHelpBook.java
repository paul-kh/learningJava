public class SelfHelpBook extends Book {

    private int numberOfPages = -1;

    // Default no-argument constructor. It will invoke the base class's no-argument constructor
    public SelfHelpBook() {
        super();// optional - Java will auto invoke super()
        System.out.println("SelfHelpBook())");
    }

    // Parameterized constructor which will invoke the base class's parameterized constructor
    public SelfHelpBook(String name) {
        super(name);

        System.out.println("SelfHelpBook(String name)");
    }

    // Parameterized constructor which will invoke the base class's parameterized constructor
    public SelfHelpBook(String name, String author) {
        super(name, author);

        System.out.println("SelfHelpBook(String name, String author)");
    }

    // Parameterized constructor which will invoke the base class's parameterized constructor
    public SelfHelpBook(String name, String author, int numberOfPages) {
        super(name, author);
        this.numberOfPages = numberOfPages;

        System.out.println("SelfHelpBook(String name, String author, int numberOfPages)");
    }

}
