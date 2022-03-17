public class MultipleExceptions {

    public static void main(String[] args) {

        System.out.println("Start of the program");

        int index = 10;

        String[] products = {"Power Bank", "USB Cable", "Phone Charger", "Laptop Charger", "HDMI Cable", null};

        try {
            System.out.format("\nThe product at index %s is %f\n", index, products[index]);
            System.out.println("Is the last product a mouse? "
                    + products[products.length -1].equalsIgnoreCase("mouse"));

            float firstPrice = Float.parseFloat(products[0]);
        }
        // Catching a specific Exception
        catch (ArrayIndexOutOfBoundsException ex) { // Catch a specific Exception
            System.out.println("The bounds of the array have been exceeded.");
        }
        // Catching a specific Exception
        catch (NullPointerException ex) { // Catch a specific Exception
            System.out.println("A null value was being accessed.");
        }
        // Catching a generic Exception
        catch (Exception ex) {
            System.out.println("An Exception has been raised: " + ex.getClass());
        }

        // NOTES - When there are specific and generic Exceptions, the catching block of the specific one
        //        must be written first. If all Exceptions are specific, line order doesn't matter

        System.out.println("End of the program");
    }
}
