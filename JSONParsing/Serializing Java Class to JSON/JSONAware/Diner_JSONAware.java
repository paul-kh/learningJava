package com.paulchheang.jsonparsing;
import org.json.simple.JSONAware;

public class Diner_JSONAware implements JSONAware {

    private String name;
    private int age;
    private String gender;
    private float amountSpent;

    public Diner_JSONAware(String name, int age, String gender, float amountSpent) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.amountSpent = amountSpent;
    }

    @Override
    public String toJSONString() {
        return String.format("{\"name\": %s, \"age\": %d, \"gender\": %s, \"amountSpent\": %f}",
                name, age, gender, amountSpent);
    }

}
