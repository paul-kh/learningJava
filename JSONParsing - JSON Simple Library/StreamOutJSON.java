package com.paulchheang.jsonparsing;

import org.json.simple.JSONObject;

import java.io.IOException;
import java.io.StringWriter;

public class StreamOutJSON{

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {

        System.out.println("**** Creating JSONObject");

        JSONObject movie = new JSONObject();

        movie.put("name", "Back to the Future");
        movie.put("releaseYear", 1985);
        movie.put("boxOffice", 388.8);
        movie.put("director", "Robert Zemeckis");

        StringWriter out = new StringWriter();
        movie.writeJSONString(out);

        System.out.println(out.toString());

        System.out.println("**** Stream encoding of JSON object");
    }
}