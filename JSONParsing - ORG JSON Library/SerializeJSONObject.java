import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class SerializeJSONObject {

    public static void main(String[] args) {

        //Instantiate a JSON object
        JSONObject employeeJSON = new JSONObject();

        //Initialize a JSON object
        employeeJSON.put("name", "Paul");
        employeeJSON.put("age", 40);
        employeeJSON.put("gender", JSONObject.NULL);
        employeeJSON.put("title", "Java Developer");
        employeeJSON.put("salary", 120000);

        /*
            Note: The key of .put() is always in string format whereas the value can be of any type
        */

        System.out.println("Employee JSON object: " + employeeJSON.toString(2)); //Pretty printing

        //Write JSON object to file
        try(FileWriter file = new FileWriter("employee.json")){
            employeeJSON.write(file,2,0); //Pretty printing feature of org.json lib
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

