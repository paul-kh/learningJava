package com.paulchheang.http_request;

import java.io.IOException;
import java.net.URI; // URL is one type of URI
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.net.http.HttpRequest.*;

public class HandlingRedirects {
    public static void  main(String[] args) throws IOException, InterruptedException {

        String url = "http://wikipedia.com";  // new URL is https://wikipedia.org

        //Create client with redirect policy
        HttpClient client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS) //Set redirect policy to be "ALWAYS" to allow redirecting
                .build();

        //Create HTTP GET request
        HttpRequest req = newBuilder()
                .uri(URI.create(url))
                .build();

        //Send HTTP request to remote server
        HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status code:\n" + res.statusCode());
        System.out.println("URI:\n" + res.uri());

        //Create previous response object before the redirect
        HttpResponse<String> previousRes = res.previousResponse().get();
        System.out.println("Previous response status code: " + previousRes.statusCode()); //301 redirect status code
        System.out.println("Previous response URI: " + previousRes.uri()); // should be http://wikipedia.com

    }
}
