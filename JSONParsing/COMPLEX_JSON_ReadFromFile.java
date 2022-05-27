package com.paulchheang.jsonparsing;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.FileReader;
import java.io.IOException;

public class COMPLEX_JSON_ReadFromFile {

    public static void main(String[] args) {

        System.out.println("**** Reading JSON");

        try (FileReader reader = new FileReader("dinersComplexJSON.json")){

            JSONObject dinerListObject = (JSONObject) JSONValue.parse(reader);
            System.out.println(dinerListObject);

            JSONArray dinerList = (JSONArray) dinerListObject.get("diners");

            for (Object object : dinerList) {
                JSONObject diner = (JSONObject) object;

                System.out.println("\n**** Diner");

                for (Object keyObj: diner.keySet()) { // .keySet() in Map
                    String key = (String) keyObj;

                    if (key.equals("contact")) {

                        JSONArray contactList = (JSONArray) diner.get(key);

                        System.out.println("Contacts: ");
                        for (Object contact : contactList) {

                            JSONObject contactJSON = (JSONObject) contact;

                            System.out.format("{**Number: %s, Type: %s**}\n",
                                    contactJSON.get("number"), contactJSON.get("type"));
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("**** Completed reading JSON");
    }
}
