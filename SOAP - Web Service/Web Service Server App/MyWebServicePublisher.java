package com.jaxwsservice;

import jakarta.xml.ws.Endpoint;

public class MyWebServicePublisher {

    public static void main(String[] args) {

        Endpoint.publish("http://localhost:8080/webservice/greeting",
                new MyWebServiceImplementation());
    }
}
