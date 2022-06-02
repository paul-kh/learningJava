import org.json.JSONObject;

public class JSON_AccumulateMethod {

    public static void main(String[] args) {

        JSONObject employeeJSON = new JSONObject();

        employeeJSON.put("name", "Paul");
        employeeJSON.put("age", 40);

        //Insert an array into JSON structure with the key "email"
        employeeJSON.accumulate("email", "paul@gmail.com");
        employeeJSON.accumulate("email", "paul@yahoo.com");
        employeeJSON.accumulate("email", "paul@hotmail.com");

        /*
        Note: .accumulate() will create array if used more than one times
        */

        System.out.println(employeeJSON.toString(2));

    }


}
