package Modul13;

import org.jsoup.Jsoup;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
        String url = "https://jsonplaceholder.typicode.com/users";

        userAllGet(url);
        System.out.println("----------------------------------------");
        userGet(url, 5);
        System.out.println("----------------------------------------");
        userNameGet(url, "Antonette");
        System.out.println("----------------------------------------");
        userDell("https://jsonplaceholder.typicode.com/users/7");
        System.out.println("----------------------------------------");
        userAdd(url);
        System.out.println("----------------------------------------");
        userEdit("https://jsonplaceholder.typicode.com/users/3");
    }

    public static void userAllGet(String uri){
        System.out.println("getting information about all users");
        try {
            String respons = Jsoup.connect(uri).ignoreContentType(true)
                    .header("contentType", "application/json")
                    .get()
                    .body().text();
            System.out.println(respons);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void userGet(String uri, int id){
        String uriID = String.format("%s?id=%d", uri, id);
        System.out.println("getting information about: " + id + " user");
        try {
            String response = Jsoup.connect(uriID).ignoreContentType(true)
                    .header("contentType", "application/json")
                    .get()
                    .body().text();
            System.out.println(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void userNameGet(String uri, String name){
        String uriID = String.format("%s?username=%s", uri, name);
        System.out.println("getting information about name: " + name + " user");
        try {
            String response = Jsoup.connect(uriID).ignoreContentType(true)
                    .header("contentType", "application/json")
                    .get()
                    .body().text();
            System.out.println(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void userDell(String uri) throws URISyntaxException, IOException, InterruptedException {
        System.out.println("delete information about user");
        HttpRequest httpRequest = HttpRequest.newBuilder(new URI(uri))
                .DELETE().build();

        HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1).build();

        HttpResponse<String> httpResponse = client
                .send(httpRequest, HttpResponse.BodyHandlers.ofString());

        System.out.println("httpResponse.statusCode() = " + httpResponse.statusCode());

    }

    public static void userAdd(String uri) throws URISyntaxException, IOException, InterruptedException {
        System.out.println("adding information about new user from file json");
        File file = new File("testUser.json");
        String path = file.getPath();

        HttpRequest request = HttpRequest.newBuilder(new URI(uri))
                .header("contentType", "application/json")
                .POST(HttpRequest.BodyPublishers.ofFile(Path.of(path))).build();

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("httpResponse.statusCode() = " + response.statusCode());
        System.out.println("httpResponse.body() = " + response.body());

    }

    public static void userEdit(String uri) throws URISyntaxException, IOException, InterruptedException {
        System.out.println("editing information about user with id = 3");
        HttpRequest request = HttpRequest.newBuilder(new URI(uri))
                .header("contentType", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString("  {\n" +
                        "    \"id\": 3,\n" +
                        "    \"name\": \"Clementine Bauch\",\n" +
                        "    \"username\": \"Newuser\",\n" +
                        "    \"email\": \"Nathan@yesenia.net\",\n" +
                        "    \"address\": {\n" +
                        "      \"street\": \"Douglas Extension\",\n" +
                        "      \"suite\": \"Suite 847\",\n" +
                        "      \"city\": \"McKenziehaven\",\n" +
                        "      \"zipcode\": \"59590-4157\",\n" +
                        "      \"geo\": {\n" +
                        "        \"lat\": \"-68.6102\",\n" +
                        "        \"lng\": \"-47.0653\"\n" +
                        "      }\n" +
                        "    },\n" +
                        "    \"phone\": \"1-463-123-4447\",\n" +
                        "    \"website\": \"ramiro.info\",\n" +
                        "    \"company\": {\n" +
                        "      \"name\": \"Romaguera-Jacobson\",\n" +
                        "      \"catchPhrase\": \"Face to face bifurcated interface\",\n" +
                        "      \"bs\": \"e-enable strategic applications\"\n" +
                        "    }\n" +
                        "  }")).build();

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("httpResponse.statusCode() = " + response.statusCode());
        System.out.println("httpResponse.body() = " + response.body());

    }
}

