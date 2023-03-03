package Modul13;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SHTTPTest {

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

//        String url = "https://uk.wikipedia.org/wiki/HTTP";

//        String url = "https://api.monobank.ua/bank/currency";
//        String url = "https://jsonplaceholder.typicode.com/users";
        String url = "https://jsonplaceholder.typicode.com/users/1/posts";

        HttpRequest httpRequest = HttpRequest.newBuilder(new URI(url))
                .GET().build();

        HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1).build();

        HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        System.out.println("response.statusCode() = " + response.statusCode());

        System.out.println("response.body() = " + response.body());
    }
}
