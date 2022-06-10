package com.paulchheang.http_request;

import org.json.JSONObject;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;
import java.util.concurrent.CompletableFuture;  //Future object | placeholder of data which not filled up yet
import java.util.concurrent.ExecutionException;


public class MultipleAsynHttpRequests {
    public static void  main(String[] args) throws IOException, InterruptedException, ExecutionException {

        List<String> list = new ArrayList<>();

        list.add("https://reqres.in/api/users/5");
        list.add("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY");
        list.add("https://swapi.dev/api/planets/3");

        Map<String, CompletableFuture<HttpResponse<String >>> responses = new HashMap<>();

        //Create client
        HttpClient client = HttpClient.newHttpClient();

        //Create HTTP GET request for each API end point
        for (String url: list) {
            HttpRequest req = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            //Create and send Asynchronous http request using future object
            CompletableFuture<HttpResponse<String>> future = null; // Create a future object
            future = client.sendAsync(req, HttpResponse.BodyHandlers.ofString());

            //Add future response object to responses hashedMap
            responses.put(url, future);
        }

        System.out.println("Requests sent out. Ready to do some more works...");
        Thread.sleep(5000);
        System.out.println("Ready to process responses... \n ");

        // Get each response object from the HashedMap
        for (Map.Entry<String, CompletableFuture<HttpResponse<String >>> entry: responses.entrySet()) {

            String resBody = entry.getValue().thenApply(HttpResponse::body).get();
            JSONObject resBodyJson = new JSONObject(resBody);

            System.out.println("\n##### URL: " + entry.getKey());
            System.out.println("\nThe response body:\n" + resBodyJson.toString(4));

        }

    }
}
