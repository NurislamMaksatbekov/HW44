package lessons;

import com.sun.net.httpserver.HttpExchange;
import dataModel.EmployeeDataModel;
import entity.Employee;
import util.Utils;
import util.FileService;

import java.io.IOException;
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
        renderTemplate(exchange, "incorrectData.ftlh", null);
    }

    private void profileGet(HttpExchange exchange) {
        renderTemplate(exchange, "profile.ftlh", new EmployeeDataModel(employee));
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
        renderTemplate(exchange, "error.ftlh", null);
    }

    private void registerGet(HttpExchange exchange) {
        renderTemplate(exchange, "register.ftlh", null);
    }

    private void loginPost(HttpExchange exchange) {
        String raw = getBody(exchange);
        Map<String, String> parsed = Utils.parseUrlEncoded(raw, "&");
        List<Employee> employees = FileService.readEmployers();
        String email = parsed.get("email");
        String password = parsed.get("password");
        employee = new Employee(parsed.get("email"), parsed.get("password"));

        if(employees.stream().anyMatch(e -> e.getEmail().equals(email) && e.getPassword().equals(password))){
            redirect303(exchange, "/profile");
        }else {
            redirect303(exchange, "/incorrectData");
        }
    }

    private void loginGet(HttpExchange exchange) {
        renderTemplate(exchange, "login.ftlh", null);
    }
}
