package com.paulchheang.jsonparsing;

import org.json.simple.parser.ContentHandler;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class ParsingHandler implements ContentHandler {

    @Override
    public void startJSON() throws ParseException, IOException {
        System.out.println("Start");
    }

    @Override
    public void endJSON() throws ParseException, IOException {
        System.out.println("End");
    }

    @Override
    public boolean startObject() throws ParseException, IOException {
        System.out.println("Start Object");
        return true;
    }

    @Override
    public boolean endObject() throws ParseException, IOException {
        System.out.println("End Object");
        return true;
    }

    @Override
    public boolean startObjectEntry(String s) throws ParseException, IOException {
        System.out.println("Start Object Entry: " + s);
        return true;
    }

    @Override
    public boolean endObjectEntry() throws ParseException, IOException {
        System.out.println("End Object Entry");
        return true;
    }

    @Override
    public boolean startArray() throws ParseException, IOException {
        System.out.println("Start Array");
        return true;
    }

    @Override
    public boolean endArray() throws ParseException, IOException {
        System.out.println("End Array");
        return true;
    }

    @Override
    public boolean primitive(Object o) throws ParseException, IOException {
        System.out.println("---" + o + "---");
        return true;
    }
}