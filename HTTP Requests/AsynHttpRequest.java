package com.paulchheang.http_request;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;  //Future object | placeholder of data which not filled up yet
import java.util.concurrent.ExecutionException;
import java.util.Date;

public class AsynHttpRequest {
    public static void  main(String[] args) throws IOException, InterruptedException, ExecutionException {

        String url = "https://reqres.in/api/users?delay=10";

        //Create client
        HttpClient client = HttpClient.newHttpClient();

        //Create HTTP GET request
        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        System.out.println("Creating the future. Time: " + (new Date()).toString());

        //Create and send Asynchronous http request using future object
        CompletableFuture<HttpResponse<String>> future = null; // Create a future object
        future = client.sendAsync(req, HttpResponse.BodyHandlers.ofString());

        System.out.println("Future object created. Time: " + (new Date()).toString());

        try {
            System.out.println("Sleeping for a few seconds now...");
            Thread.sleep(8000);
            System.out.println("Waking up...Let's see where the response is!");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        String res = future.thenApply(HttpResponse::body).get(); //tell the future object to apply response body when the data becomes available

        System.out.println("Parsing the response. Time: " + (new Date().toString()));
        JSONObject resBodyJson = new JSONObject(res);
        System.out.println("Body:\n" + resBodyJson.toString(4));

    }
}
