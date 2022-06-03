import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;

public class CustomObject_to_JSON {
    public static void main(String[] args) {

        EmployeeBean employeeBean = new EmployeeBean(
                BigInteger.valueOf(1234567), "Paul", "Java Developer", 100000, 40
        );

        // Serialize Bean object to JSON
        JSONObject employeeJson = new JSONObject(employeeBean);

        System.out.println(employeeJson.toString(2));

        // Write the serialized Bean object with JSON format to file
        try(FileWriter file = new FileWriter("customObject_employee.json")) {
            employeeJson.write(file, 2, 0);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
