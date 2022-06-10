package com.paulchheang.http_request;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class POST_Request {
    public static void main(String[] args) throws IOException, InterruptedException {

        String url = "https://reqres.in/api/users";

        //POST data needs to be of JSON Format
        String postData = "{'email': 'alice@paulchheang.com'," +
                "'firstName': 'Alice', " +
                "'lastName': 'Thompson'}";

        //Create HTTP Client object
        HttpClient client = HttpClient.newBuilder().build();

        //Create POST request
        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .POST(HttpRequest.BodyPublishers.ofString(postData))
                .build();
        //Send out the request object to API end point
        HttpResponse<?> res = client.send(req, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status:" + res.statusCode());
        System.out.println("Headers:" + res.headers());

        //Parsing response object to JSON object
        JSONObject resJson =  new JSONObject(res.body().toString());
        System.out.println("Response JSON: \n" + resJson.toString(4));
    }
}
