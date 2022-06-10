package com.paulchheang.http_request;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
public class DELET_Request {

    public static void main(String[] args) throws IOException, InterruptedException {

        String url = "https://reqres.in/api/users/563";


        //Create HTTP Client object
        HttpClient client = HttpClient.newBuilder().build();

        //Create POST request
        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .DELETE()
                .build();
        //Send out the request object to API end point
        HttpResponse<?> res = client.send(req, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status:" + res.statusCode()); // 204 delete status code
        System.out.println("Headers:" + res.headers());
        System.out.println("Body:" + res.body()); // should be empty

    }
}
