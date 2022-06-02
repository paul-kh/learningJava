package com.paulchheang.jsonparsing;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue; // so we can get value from JSON object

import java.io.FileReader;
import java.io.IOException;

public class JSON_ARRAY_ReadFromFile {

    public static void main(String[] args) {

        System.out.println("**** Reading JSON");

        try (FileReader reader = new FileReader("diners.json")){

            JSONArray dinerList = (JSONArray) JSONValue.parse(reader);
            System.out.println(dinerList);

            for (Object object : dinerList) {
                JSONObject diner = (JSONObject) object;

                System.out.println("\n**** Diner");

                String name = (String) diner.get("name");
                System.out.println("\ndiner name: " + name);

                String gender = (String) diner.get("gender");
                System.out.println("diner gender: " + gender);

                long age = (long) diner.get("age");
                System.out.println("diner age: " + age);

                double amountSpent = (double) diner.get("amountSpent");
                System.out.println("diner spending: " + amountSpent);

                Boolean isAllergic = (Boolean) diner.get("isAllergic");
                System.out.println("diner isAllergic: " + isAllergic);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("**** Completed reading JSON");
    }
}
