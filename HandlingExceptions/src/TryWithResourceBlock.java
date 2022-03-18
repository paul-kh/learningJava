import java.io.*;

public class TryWithResourceBlock {
    public static void main(String[] args) {

        File fileIn = new File("C:\\Users\\352905\\OneDrive - MAXIMUS\\dev\\java\\Error and Exceptions Handling\\HandlingExceptions\\data\\myFile.txt");
        File fileOut = new File("C:\\Users\\352905\\OneDrive - MAXIMUS\\dev\\java\\Error and Exceptions Handling\\HandlingExceptions\\data\\myFileCopy.txt");

        // Try-with-resourcesBlock to auto close all open objects - br.close(); bw.close()
        try (
                BufferedReader br = new BufferedReader(new FileReader(fileIn)); // Resource 1
                BufferedWriter bw = new BufferedWriter(new FileWriter(fileOut)) // Resource 2
        ) {

            bw.write("This is another copy! \n");

            String st = null;

            while ((st = br.readLine()) != null ) {
                System.out.println(st);

                bw.write(st + "\n");
            }
        }
        catch (IOException ex) {
            System.out.println("Catch and handle Exception: " + ex);
        }
    }
}
