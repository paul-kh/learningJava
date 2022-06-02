import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSON_Array_ReadFromFile {
    public static void main(String[] args) throws IOException {

        // Read file in byte stream
        String employeeString = new String(Files.readAllBytes(Paths.get("employeeArray.json")));

        JSONArray employeesJSON = new JSONArray(employeeString);

        for (int i=0 ; i < employeesJSON.length(); i++){
            JSONObject employeeJSON = employeesJSON.getJSONObject(i); //Get a JSON object inside JSON Array

            //Get key value of each JSON Object field - Common fields that exist in every JSON object of the array
            String name = employeeJSON.getString("name");
            String title = employeeJSON.getString("title");
            double salary = employeeJSON.getDouble("salary");

            System.out.format("\n***\n%s, %s, %.1f\n", name, title, salary);

            //Get key values which are of optional fields (some JSON objects don't have those fields)
            int age = employeeJSON.optInt("age");
            String gender = employeeJSON.optString("gender");

            System.out.format("%d, %s\n", age, gender);



        }


    }
}
