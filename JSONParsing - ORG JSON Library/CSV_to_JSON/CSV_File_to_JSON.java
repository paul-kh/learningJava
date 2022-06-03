import org.json.CDL;
import org.json.JSONArray;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CSV_File_to_JSON {

    public static void main(String[] args) {

        //* CSV file that has no header
        //**************************************************
        System.out.println("CSV File with No Header *****************************************");

        // 1. Create JSON array object containing headers
        JSONArray headersArray = new JSONArray();
        headersArray.put("Username");
        headersArray.put("Identifier");
        headersArray.put("First name");
        headersArray.put("Last name");

        // 2. Read from CSV file
        String commaDelimitedUsers = null;
        try {
            commaDelimitedUsers = new String(Files.readAllBytes(Paths.get("username_withoutHeader.csv")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 3. Convert CSV string (commaDelimitedList) to JSON array
        JSONArray usersJsonArray = CDL.toJSONArray(headersArray, commaDelimitedUsers);
        System.out.println(usersJsonArray.toString(2));

        // 4. Write JSON to file
        try (FileWriter file = new FileWriter("username_withoutHeader.json")){
            usersJsonArray.write(file, 2, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //* CSV file that has header at the first row
        //**************************************************
        System.out.println("CSV File with Header *****************************************");

        // 1. Read from CSV file
        String commaDelimitedUsers2 = null;
        try{
           commaDelimitedUsers2 = new String(Files.readAllBytes(Paths.get("username_withHeader.csv")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2. Convert to JSON array
        JSONArray usersJsonArray2 = CDL.toJSONArray(commaDelimitedUsers2); //CDL.toJSONArray() auto recognizes the first row as the header
        System.out.println(usersJsonArray2.toString(2));

        // 3. Write JSON to file
        try (FileWriter file = new FileWriter("username_withHeader.json")){
            usersJsonArray2.write(file, 2, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
