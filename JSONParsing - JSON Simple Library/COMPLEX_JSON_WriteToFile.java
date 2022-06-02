package com.paulchheang.jsonparsing;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class COMPLEX_JSON_WriteToFile {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        System.out.println("**** Creating JSONArray of JSONObjects");

        JSONObject dinerListObject = new JSONObject(); //JSON outer/container object

        JSONArray dinerList = new JSONArray(); // JSON Array object

        JSONObject diner1 = new JSONObject(); // JSON object
        diner1.put("name", "Jane Stark");
        diner1.put("age", 22);
        diner1.put("gender", "Female");
        diner1.put("isAllergic", false);
        diner1.put("amountSpent", 153.27);

        JSONArray contactList = new JSONArray();
        JSONObject contact1 = new JSONObject();

        contact1.put("type", "home");
        contact1.put("number", "212-555-1234");

        JSONObject contact2 = new JSONObject();

        contact2.put("type", "mobile");
        contact2.put("number", "646-555-4567");

        contactList.add( contact1);
        contactList.add( contact2);

        diner1.put("contact", contactList);

        dinerList.add(diner1);

        dinerListObject.put("diners", dinerList);

        System.out.println(dinerListObject);

        try (FileWriter file = new FileWriter("dinersComplexJSON.json")) {
            dinerListObject.writeJSONString(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("**** Writing out JSONArray of JSONObjects");
    }
}
