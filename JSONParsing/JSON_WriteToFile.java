package com.paulchheang.jsonparsing;

import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class JSON_WriteToFile {

    @SuppressWarnings("unchecked") // To avoid warning on using raw Map for JSONObject
    public static void main(String[] args) {

        System.out.println("**** Creating JSONObject");

        // JSONObject class derived from Map class; it's non-generic Map - it's a raw Map
        JSONObject diner = new JSONObject();

        diner.put("name", "Jane Stark");
        diner.put("age", 22);
        diner.put("gender", null);
        diner.put("isAllergic", false);
        diner.put("amountSpent", 153.27);

        System.out.println(diner.toJSONString());

        // Write JSON to file
        try (FileWriter file = new FileWriter("diner.json")) {
            diner.writeJSONString(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("**** Writing out JSONObject");
    }
}
