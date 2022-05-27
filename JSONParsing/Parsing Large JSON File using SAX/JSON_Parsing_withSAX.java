package com.paulchheang.jsonparsing;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JSON_Parsing_withSAX {

    public static void main(String[] args) {

        System.out.println("**** Reading very large JSON file");

        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("employees.json")) {
            // Object obj = jsonParser.parse(reader); // Parse file content completely to the computer memory. If large file, this line is not needed

            // This is mandatory to parse large JSON file - callback
            ParsingHandler parsingHandler = new ParsingHandler();

            // Parse file content in the callback-based approach
            // 1. Large JSON File
            jsonParser.parse( reader, parsingHandler,true); // Use file reader object for 1st arg, ParsingHandler obj for 2nd arg
            // 2. Small JSON File
            // jsonParser.parse(obj.toString(), parsingHandler, true);

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        System.out.println("**** Completed reading JSON");
    }
}
