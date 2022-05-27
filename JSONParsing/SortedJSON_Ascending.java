package com.paulchheang.jsonparsing;

import org.json.simple.JSONValue;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class SortedJSON_Ascending{

    public static void main(String[] args) throws IOException {

        System.out.println("**** Creating JSONObject");

        Map<String, Object> movie = new TreeMap<>();

        movie.put("name", "Back to the Future");
        movie.put("releaseYear", 1985);
        movie.put("boxOffice", 388.8);
        movie.put("director", "Robert Zemeckis");

        System.out.println(JSONValue.toJSONString(movie));

        System.out.println("**** Predictable ordering string encoding of JSON object");
    }
}