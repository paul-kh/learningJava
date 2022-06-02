package com.paulchheang.jsonparsing;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class JSON_ARRAY_WriteToFile {

    public static void main(String[] args) {

        System.out.println("**** Creating JSONArray of JSONObjects");

        JSONArray dinerList = new JSONArray();

        JSONObject diner1 = new JSONObject();
        diner1.put("name", "Jane Stark");
        diner1.put("age", 22);
        diner1.put("gender", "Female");
        diner1.put("isAllergic", false);
        diner1.put("amountSpent", 153.27);

        JSONObject diner2 = new JSONObject();
        diner2.put("name", "Jon Snow");
        diner2.put("age", 25);
        diner2.put("gender", "Male");
        diner2.put("isAllergic", false);
        diner2.put("amountSpent", 750.5);

        dinerList.add(diner1);
        dinerList.add(diner2);

        System.out.println(dinerList);

        try (FileWriter file = new FileWriter("diners.json")) {
            dinerList.writeJSONString(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("**** Writing out JSONArray of JSONObjects");
    }
}
