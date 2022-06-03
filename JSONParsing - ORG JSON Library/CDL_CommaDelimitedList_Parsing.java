/*
    - Use .rowToJSONArray of CDL (Comma Delimited List) class to parse a token string (contains commas) to JSON Field Array:
       Token filed string: "Peter, Jane, Bob, Nora, Hannah"
       Converted to JSON Fields Array: ["Peter", "Jane", "Bob", "Nora", "Hannah"]
    - Use CDL.rowToJSONObject(JSONFieldsArray, new JSONTokener("fieldValue1,fieldValue2,fieldValue3")) to construct JSON object:
      JSONField: ["name","title","age"]
      JSONToken String (mostly in CSV file): "Paul,Java Developer,40"
      => CDL.rowToJSONObject creates JSON: {"name": "Paul", "title": "Java Developer", "age": 40}
 */

import org.json.CDL;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.JSONArray;

public class CDL_CommaDelimitedList_Parsing {

    public static void main(String[] args) {

        String tokenFieldStr = "name, title, age";
        String tokeValueStr = "Paul, Java Developer, 40";

        //Create JSON Array of field name
        JSONArray fieldNamesArray = CDL.rowToJSONArray(new JSONTokener(tokenFieldStr)); //auto trimming the white space of the token string
        System.out.println(fieldNamesArray);

        //Create JSON of field-value pair from token strings
        JSONObject employeeJson = CDL.rowToJSONObject(fieldNamesArray, new JSONTokener(tokeValueStr));
        System.out.println(employeeJson.toString(2));

        // *****************************************************************************************
        //Create array of JSON objects from header string and comma delimited text (CSV file)
        JSONArray headerArray = new JSONArray();
        headerArray.put("name");
        headerArray.put("age");
        headerArray.put("gender");

        //Mimic a form of CSV file
        String commaDelimitedText = "Peter, 42, Male \n" +
                                    "Jane, 22, Female \n" +
                                    "Bob, 34, Male";

        // Convert to array of JSON objects
        JSONArray JsonArray = CDL.toJSONArray(headerArray, commaDelimitedText);

        System.out.println(JsonArray.toString(2));

    }
}
