import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExploringExceptions {
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
}
