package com.jaxwsservice;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService; //For older version of Apache Tomcat, it uses javax.jws.WebService

//Add annotation to point to the interface "MyWebServiceInterface.java"
@WebService
//Definition of a basic web service that will execute a method invoked by a client
public class MyWebServiceImplementation {
    @WebMethod
    public String myGreetingMessage(String mystr) {
        return "Hello, " + mystr + ". Welcome to the world of Web Services! ";
    }
}