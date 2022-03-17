import java.lang.management.ThreadMXBean;

public class HandlingExceptions {

    public static void main(String[] args) {

        double[] prices = {5.90, 18.99, 64.0, 99.00, 79.50};

        int index = 5;

        System.out.println("Start of the program");

        try {
            System.out.format("\nThe price at index %s is %f\n", index, prices[index]);
        }
        catch (Exception e) { // Catch a generic Exception
            System.out.println("An exception occurred");
            // e.printStackTrace(); // print the call stack to show the involved classes
            // System.out.println(e);

            System.out.println("The Exception class: " + e.getClass());
            System.out.println("The Exception message: " + e.getMessage());
            System.out.println("The Exception localized message: " + e.getLocalizedMessage());
            System.out.println("The Exception cause: " + e.getCause());

            System.out.println("\nExploring more about the Exception object ===========================");
            System.out.println("Is e an Object? " + (e instanceof Object));
            System.out.println("Is e a Throwable? " + (e instanceof Throwable));
            System.out.println("Is e an Exception? " + (e instanceof Exception));
            System.out.println("Is e a RuntimeException? " + (e instanceof RuntimeException));
            System.out.println("Is e an ArrayIndexOutOfBoundsException? " + (e instanceof ArrayIndexOutOfBoundsException));

            System.out.println("Is e an ArithmeticException? " + (e instanceof ArithmeticException));
            System.out.println("Is e a StringIndexOutOfBoundsException? " + (e instanceof StringIndexOutOfBoundsException));

        }

        System.out.println("End of the program");
    }

}
