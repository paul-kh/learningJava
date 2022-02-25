public class Main {

    public static void main(String[] args) {

        // ****** BASE CLASS ****************************************************
        // Instances of the base class "Book"
        Book headFirstJava = new Book();
        System.out.println("headFirstJava: " + headFirstJava);

        Book effectiveJava = new Book("Effective Java");
        System.out.println("effectiveJava: " + effectiveJava);

        Book coreJava = new Book("Core Java", "Cay S. Horstmann");
        System.out.println("coreJava: " + coreJava);

        // ****** DERIVED CLASS ****************************************************
        // Instances of the derived class "SelfHelpBook"
        SelfHelpBook algorithmsToLiveBy = new SelfHelpBook();
        System.out.println("algorithmsToLiveBy: " + algorithmsToLiveBy);

        SelfHelpBook twoAwesomeHours = new SelfHelpBook("Two Awesome Hours");
        System.out.println("twoAwesomeHours: " + twoAwesomeHours);

        SelfHelpBook thePowerOfHabit = new SelfHelpBook("The Power of Habit", "Charles Duhigg", 450);
        System.out.println("thePowerOfHabit: " + thePowerOfHabit);


    }

}
