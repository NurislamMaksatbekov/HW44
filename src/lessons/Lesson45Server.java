package lessons;

import com.sun.net.httpserver.HttpExchange;
import dataModel.UserDataModel;
import entity.Employee;
import entity.User;
import server.ContentType;
import server.Utils;
import util.FileService;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Lesson45Server extends Lesson44Server {
    public Lesson45Server(String host, int port) throws IOException {
        super(host, port);
        registerGet("/error", this::errorGet);
        registerGet("/incorrectData", this::incorrectGet);
        registerGet("/login", this::loginGet);
        registerPost("/login", this::loginPost);
        registerGet("/register", this::registerGet);
        registerPost("/register", this::registerPost);
        registerGet("/profile", this::profileGet);
    }

    private void incorrectGet(HttpExchange exchange) {
        Path path = makeFilePath("incorrectData.ftlh");
        sendFile(exchange, path, ContentType.TEXT_HTML);
    }

    private void profileGet(HttpExchange exchange) {
        renderTemplate(exchange, "profile.ftlh", new UserDataModel(user));
    }

    private void registerPost(HttpExchange exchange) {
        String raw = getBody(exchange);
        Map<String, String> register = Utils.parseUrlEncoded(raw, "&");
        List<Employee> employees = FileService.readEmployers();
        String email = register.get("email");

        if (employees.stream().anyMatch(e -> e.getEmail().equals(email))) {
            redirect303(exchange, "/error");
        } else {
            String name = register.get("name");
            String surname = register.get("surname");
            String password = register.get("password");

            Employee employee = new Employee(name, surname, email, password, 0, 0, new ArrayList<>(), new ArrayList<>());
            employees.add(employee);
            FileService.writeEmployers(employee);
            redirect303(exchange, "/login");
        }
    }



    private void errorGet(HttpExchange exchange) {
        Path path = makeFilePath("error.ftlh");
        sendFile(exchange, path, ContentType.TEXT_HTML);
    }

    private void registerGet(HttpExchange exchange) {
        Path path = makeFilePath("register.ftlh");
        sendFile(exchange, path, ContentType.TEXT_HTML);
    }

    private void loginPost(HttpExchange exchange) {
        String raw = getBody(exchange);
        Map<String, String> parsed = Utils.parseUrlEncoded(raw, "&");
        List<Employee> employees = FileService.readEmployers();
        String email = parsed.get("email");
        String password = parsed.get("password");
        user = new User(parsed.get("email"), parsed.get("password"));

        if(employees.stream().anyMatch(e -> e.getEmail().equals(email) && e.getPassword().equals(password))){
            redirect303(exchange, "/profile");
        }else {
            redirect303(exchange, "/incorrectData");
        }
    }

    private void loginGet(HttpExchange exchange) {
        Path path = makeFilePath("login.ftlh");
        sendFile(exchange, path, ContentType.TEXT_HTML);
    }
}
