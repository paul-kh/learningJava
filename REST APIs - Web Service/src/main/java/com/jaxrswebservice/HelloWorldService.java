package com.jaxrswebservice;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/ws")
public class HelloWorldService {

    @GET
    @Path("/greeting")  //full-path = http://localhost:8080/rest-app/ws/greeting
    @Produces(MediaType.TEXT_HTML)
    public String myGreeting() {

        return "Welcome to the world of <b>REST APIs in Java!</b>";
    }

    @GET
    @Path("/greeting/{param}")
    public Response myGreeting(@PathParam("param") String name) {

        String message = "Welcome <b>" + name + "!</b> This is the world of web services.";

        return Response.status(200)
                .entity(message)
                .type(MediaType.TEXT_HTML)
                .build();

    }

}
