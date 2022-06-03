import java.math.BigInteger;

import org.json.JSONArray;
import java.util.ArrayList;
import java.util.List;

import java.io.FileWriter;
import java.io.IOException;

/*  Note: The org.json can serialize and convert bean object to JSON by using the "get__", "set__", and "is__" methods
           defined in the object
 */

public class NestedObjectsArrays_Bean_ORGdotJSON {
    public static void  main(String[] args){

        // Add list of employees in JSON format to JSONArray
        EmployeeBean employeeBean1 = new EmployeeBean(BigInteger.valueOf(1234568), "Peter", "CEO", 150000, 30);
        employeeBean1.setCommitteeList(new CommitteeBean("Management", 5), new CommitteeBean("Food", 20));

        EmployeeBean employeeBean2 = new EmployeeBean();
        employeeBean2.setId(BigInteger.valueOf(1234569));
        employeeBean2.setName("Peter");
        employeeBean2.setTitle("CFO");
        employeeBean2.setActive(true);
        employeeBean2.setCommitteeList(new CommitteeBean("Management", 5), new CommitteeBean("Administration", 10));

        EmployeeBean employeeBean3 = new EmployeeBean();
        employeeBean3.setId(BigInteger.valueOf(1234570));
        employeeBean3.setName("Tana");

        //Create an array list to contain all employeeBean objects
        List<EmployeeBean> employeeBeanList = new ArrayList<>();
        employeeBeanList.add(employeeBean1);
        employeeBeanList.add(employeeBean2);
        employeeBeanList.add(employeeBean3);

        //Create a JSON array to serialize and contain all employeeBean objects
        JSONArray employeeJsonList = new JSONArray(employeeBeanList);

        System.out.println(employeeJsonList.toString(2)); //Pretty print JSON to console

        //Write JSON array with nested object to file "NestedObjectJSON_employee.json"
        try(FileWriter file = new FileWriter("NestedObjectJSON_employee.json")) {
            employeeJsonList.write(file, 2, 0); //Pretty print to write to file
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
