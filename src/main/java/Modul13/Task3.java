package Modul13;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import static org.jsoup.Jsoup.connect;

public class Task3 {
    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        String url = "https://jsonplaceholder.typicode.com/users/";

        int idUser = 1; // user id
        String task = "false"; // todo is complited or not

        userTodosGet(url, idUser, task);
    }

    public static void userTodosGet(String url, int id, String task) throws IOException, InterruptedException, URISyntaxException {
        String uri = url + String.valueOf(id) + "/todos";

        try {
            String response = connect(uri)
                    .ignoreContentType(true)
                    .get()
                    .body().text();

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Type type = TypeToken.getParameterized(List.class, UserTodos.class).getType();
            List<UserTodos> todosList = gson.fromJson(response, type);
            List<UserTodos> todos = todosList.stream()
                    .filter(userTodos -> userTodos.getCompleted().equals(task))
                    .peek(System.out::println)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
