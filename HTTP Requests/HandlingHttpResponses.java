package com.paulchheang.http_request;

import java.io.IOException;
import java.net.URI; // URL is one type of URI
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.json.JSONObject;
import java.time.Duration;

public class HandlingHttpResponses {

    public static void  main(String[] args) throws IOException, InterruptedException {

        String url = "https://reqres.in/api/users?delay=10"; // the end point api server will delay the response by 10 seconds

        //Create client
        HttpClient client = HttpClient.newHttpClient();

        //Create HTTP GET request
        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET() //Explicitly specify GET method in the request  -- good practice
                .timeout(Duration.ofMillis(15000)) // timeout if not receive the response within 5 seconds
                .build();

        //Send HTTP request to remote server and write response body to file
        HttpResponse<Path> res1 = client.send(req, HttpResponse.BodyHandlers.ofFile(Paths.get("responseBody.txt")));

        //Send HTTP request to remote server and get response body in String format
        HttpResponse<String> res2 = client.send(req, HttpResponse.BodyHandlers.ofString());

        //Serialize the string of response body to JSON object
        JSONObject resBodyJson = new JSONObject(res2.body());
        System.out.println("Body:\n" + resBodyJson.toString(2));

        System.out.println("Status code:\n" + res2.statusCode());
        System.out.println("URI:\n" + res2.uri()); //the returned URI might not be the same as the URL that we sent, because a redirect might be used at the server

        System.out.println("Response Headers:\n" + res2.headers());
        System.out.println("Content Type (first): "
                + res2.headers().firstValue("content-type")); // returning the Optional object
        System.out.println("Content Type (all): "
                + res2.headers().allValues("content-type")); // returning an array object
    }
}
