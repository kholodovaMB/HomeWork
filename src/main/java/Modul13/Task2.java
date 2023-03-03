package Modul13;

import Modul10.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Jsoup;

import java.io.*;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.util.List;

public class Task2 {
    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {

        String url = "https://jsonplaceholder.typicode.com/users/";
        int postId = 1;
        userPostGet(url, postId);
    }

    public static void userPostGet(String url, int id) throws IOException, InterruptedException, URISyntaxException {
        String uri = url + String.valueOf(id) + "/posts";
        int max = 0;

        HttpRequest httpRequest = HttpRequest.newBuilder(new URI(uri))
                .GET().build();

        HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1).build();

        HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Type type = TypeToken.getParameterized(List.class, UserPost.class).getType();

        List<UserPost> postList = gson.fromJson(response.body(), type);

        if (response.statusCode() == 200) {
            for (UserPost post : postList) {
                max = max < post.getId() ? post.getId() : max;
            }
        } else {
            System.out.println("response.statusCode() = " + response.statusCode());
            return;
        }

        String maxId = String.valueOf(max) + "/comments";

        String uriID = String.format("%s%s", "https://jsonplaceholder.typicode.com/posts/", maxId);

        HttpRequest request = HttpRequest.newBuilder(new URI(uriID))
                .GET().build();
        HttpResponse<byte[]> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofByteArray());

        String nameFile = "user-" + String.valueOf(id) + "-post-" + String.valueOf(max) + "-comments.json";
        File file = new File(nameFile);

        try (OutputStream fos = Files.newOutputStream(file.toPath())) {
            fos.write(httpResponse.body());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
