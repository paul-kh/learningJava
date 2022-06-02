import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JSON_ReadFromFile {

    public static void main(String[] args) {

        // Read from file one line at a time
        try (BufferedReader reader = new BufferedReader(new FileReader("employee.json"))) {

            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            String lineSeparator = System.getProperty("line.separator");
            while ((line = reader.readLine()) != null ) {
                stringBuilder.append(line);
                stringBuilder.append(lineSeparator);
            }

            JSONObject employeeJSON = new JSONObject(stringBuilder.toString());

            String name = employeeJSON.getString("name");
            String title = employeeJSON.getString("title");
            double salary = employeeJSON.getDouble("salary");
            int age = employeeJSON.getInt("age");

            System.out.format("\n%s, %s, %.1f, %d\n", name, title, salary, age);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
