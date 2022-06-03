import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

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


        // Add list of employees in JSON format to JSONArray
        EmployeeBean employeeBean1 = new EmployeeBean(BigInteger.valueOf(1234568), "Peter", "CEO", 150000, 30);

        EmployeeBean employeeBean2 = new EmployeeBean();
        employeeBean2.setId(BigInteger.valueOf(1234569));
        employeeBean2.setName("Peter");
        employeeBean2.setTitle("CEO");

        EmployeeBean employeeBean3 = new EmployeeBean();
        employeeBean3.setId(BigInteger.valueOf(1234570));
        employeeBean3.setName("Tana");

        List<EmployeeBean> employeeBeanList = new ArrayList<>();
        employeeBeanList.add(employeeBean1);
        employeeBeanList.add(employeeBean2);
        employeeBeanList.add(employeeBean3);

        JSONArray employeeJsonList = new JSONArray(employeeBeanList);

        System.out.println(employeeJsonList.toString(2));

    }
}
