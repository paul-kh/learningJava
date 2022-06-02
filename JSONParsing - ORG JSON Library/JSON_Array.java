import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class JSON_Array {
    public static void main(String[] args){

        //Instantiate a json object - employeeJSON1
        JSONObject employeeJSON1 = new JSONObject();

        //Initialize json object
        employeeJSON1.put("name", "Paul");
        employeeJSON1.put("age", 40);
        employeeJSON1.put("gender", JSONObject.NULL);
        employeeJSON1.put("title", "Java Developer");
        employeeJSON1.put("salary", 120000 );

        //Instantiate a json object - employeeJSON2
        JSONObject employeeJSON2 = new JSONObject();

        //Initialize json object
        employeeJSON2.put("name", "Tana");
        employeeJSON2.put("title", "Tech Lead");
        employeeJSON2.put("salary", 150000 );

        //Instantiate JSONArray Object "employeeArray"
        JSONArray employeeArray = new JSONArray();

        //Add JSON objects in JSON Array
        employeeArray.put(employeeJSON1);
        employeeArray.put(employeeJSON2);

        //Display the JSON Array on console
        System.out.println(employeeArray.toString(2));

        //Write JSON Array to file
        try (FileWriter file = new FileWriter("employeeArray.json")) {
            employeeArray.write(file, 2, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }





    }
}
