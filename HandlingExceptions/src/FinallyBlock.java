// "Finally" block is used to clear the resources after being used, especially in the try-catch block

import java.io.*;

public class FinallyBlock {

    public static void main(String[] args) {

        BufferedReader br = null;
        try {
            File file = new File("D:\\dev\\GitHub Repos\\learningJava\\HandlingExceptions\\data\\myFile.txt");

            br = new BufferedReader(new FileReader(file));
            String st = br.readLine();
            while (st != null) {
                System.out.println(st);
                st = br.readLine();
            }

            br.close();
        }
        catch (FileNotFoundException ex) {
            System.out.println("Exception caught: " + ex);
        }
        catch (IOException ex) {
            System.out.println("Exception caught: " + ex);
        }
        finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Closed the buffered reader in the finally block");
            } else {
                System.out.println("The buffered reader was never opened");
            }
        }
        // Note - Finally block can exist even without the catch block

    }

}
