import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExploringExceptions {

    /* Exception handling using try-catch block
    public static void main(String[] args) {

        try {
            // The file "myFile.txt" doesn't exist
            FileReader file = new FileReader("D:\\\java\\ExploringExceptions\\data\\myfile.txt");

        }
        catch (FileNotFoundException e) {
            System.out.println("code execution still continues after the exception thrown");
            e.printStackTrace(); // print out Exception stack
        }
    }

     */

    // Exception handling by throwing exception in the method signature
    public static void main(String[] args) throws FileNotFoundException {

            try {
                // The file "myFile.txt" doesn't exist
                FileReader file = new FileReader("D:\\java\\ExploringExceptions\\data\\myfile.txt");

            }
            catch (FileNotFoundException e) {
                System.out.println("\nThe file not found.");
            }
        // try-catch block exception handling take precedence over
        // the handling in method signature - thus Exception Stack will not auto printed
        // Next line of code in this method will be executed as well.
        System.out.println("code execution is complete");
    }
}
