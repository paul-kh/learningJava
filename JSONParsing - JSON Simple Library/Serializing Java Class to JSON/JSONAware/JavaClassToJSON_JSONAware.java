package com.paulchheang.jsonparsing;

import org.json.simple.JSONArray;

import java.io.FileWriter;
import java.io.IOException;

public class JavaClassToJSON_JSONAware{

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        System.out.println("**** Creating JSONArray of Diners");

        JSONArray dinerList = new JSONArray();

        Diner_JSONAware diner1 = new Diner_JSONAware("Jane Stark", 22, "Female", 153.5f);
        Diner_JSONAware diner2 = new Diner_JSONAware("Jon Snow", 24, "Male", 767.5f);

        dinerList.add(diner1);
        dinerList.add(diner2);

        System.out.println(dinerList);

        try (FileWriter file = new FileWriter("diners.json")) {
            dinerList.writeJSONString(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("**** Writing out JSONArray of Diners");
    }
}