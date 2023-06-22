package lessons;

import com.sun.net.httpserver.HttpExchange;
import entity.User;
import server.BasicServer;
import server.ContentType;
import server.Utils;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

public class Lesson45Server extends Lesson44Server {
    public Lesson45Server(String host, int port) throws IOException {
        super(host, port);
        registerGet("/login", this::loginGet);
        registerPost("/login", this::loginPost);
    }

    private void loginPost(HttpExchange exchange) {
        String raw = getBody(exchange);
        Map<String, String> parsed = Utils.parseUrlEncoded(raw, "&");
        user = new User(parsed.get("email"), parsed.get("password"));
        redirect303(exchange, "/");
    }

    private void loginGet(HttpExchange exchange) {
        Path path = makeFilePath("login.ftlh");
        sendFile(exchange, path, ContentType.TEXT_HTML);
    }
}
