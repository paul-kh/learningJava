import org.json.JSONObject;

public class JSON_appendMethod {

    public static void main(String[] args) {

        JSONObject employeeJSON = new JSONObject();

        employeeJSON.put("name", "Paul");
        employeeJSON.put("age", 40);

        //Insert an array into JSON structure with the key "email"
        employeeJSON.append("email", "paul@gmail.com");
        employeeJSON.append("email", "paul@yahoo.com");
        employeeJSON.append("email", "paul@hotmail.com");

        /*
        Note: The difference between .append() and .accumulate() is that .append() always creates
              an array to store the value of the json key even it's invoked just 1 time.
        */

        System.out.println(employeeJSON.toString(2));

    }


}
