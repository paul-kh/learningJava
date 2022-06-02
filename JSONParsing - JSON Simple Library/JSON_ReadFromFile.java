package com.paulchheang.jsonparsing;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.FileReader;
import java.io.IOException;

public class JSON_ReadFromFile {

    public static void main(String[] args) {

        System.out.println("**** Reading JSON");

        try (FileReader reader = new FileReader("diner.json")){

            JSONObject dinerData = (JSONObject) JSONValue.parse(reader);
            System.out.println(dinerData);


            String name = (String) dinerData.get("name");
            System.out.println("\ndiner name: " + name);

            String gender = (String) dinerData.get("gender");
            System.out.println("diner gender: " + gender);

            long age = (long) dinerData.get("age");
            System.out.println("diner age: " + age);

            double amountSpent = (double) dinerData.get("amountSpent");
            System.out.println("diner spending: " + amountSpent);

            Boolean isAllergic = (Boolean) dinerData.get("isAllergic");
            System.out.println("diner isAllergic: " + isAllergic);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("**** Completed reading JSON");
    }
}
