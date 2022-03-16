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

            // The file "myFile.txt" doesn't exist
            FileReader file = new FileReader("D:\\java\\ExploringExceptions\\data\\myfile.txt");
            // Note - Java will auto catch the exception and print exception stack.
            //        Next line of code will not be executed
            System.out.println("code execution here can't continues after the exception thrown");

    }
}
