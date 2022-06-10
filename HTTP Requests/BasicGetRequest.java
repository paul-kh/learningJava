package com.paulchheang.http_request;

import java.io.IOException;
import java.net.URI; // URL is one type of URI
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BasicGetRequest {

    public static void  main(String[] args) throws IOException, InterruptedException {

        String url = "https://reqres.in/api/users";

        //Create client
        HttpClient client = HttpClient.newHttpClient();

        //Create HTTP GET request
        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        //Send HTTP request to remote server
        HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());

        System.out.println("Body:\n" + res.body()); //res.body() is of JSON format
        System.out.println("Status code:\n" + res.statusCode());
        System.out.println("URI:\n" + res.uri()); //the returned URI might not be the same as the URL that we sent, because a redirect might be used at the server
        System.out.println("Response Headers:\n" + res.headers());
    }

}
