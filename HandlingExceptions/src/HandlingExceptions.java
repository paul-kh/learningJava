import java.lang.management.ThreadMXBean;

public class HandlingExceptions {

    public static void main(String[] args) {

        double[] prices = {5.90, 18.99, 64.0, 99.00, 79.50};

        int index = 5;

        System.out.println("Start of the program");

        try {
            System.out.format("\nThe price at index %s is %f\n", index, prices[index]);
        }
        catch (ArrayIndexOutOfBoundsException e) { // Catch a specific Exception

            System.out.println("An exception occurred: " + e.getClass());
        }

        System.out.println("End of the program");
    }

}
