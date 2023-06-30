package lessons;

import com.sun.net.httpserver.HttpExchange;
import dataModel.EmployeeDataModel;
import entity.Employee;
import server.Cookie;
import util.Utils;
import util.FileService;

import java.io.IOException;
import java.util.*;

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
        registerGet("/logout", this::logoutGet);
    }

    private void logoutGet(HttpExchange exchange) {
        logout(exchange);
        renderTemplate(exchange, "logout.ftlh", null);
    }

    private void incorrectGet(HttpExchange exchange) {
        renderTemplate(exchange, "incorrectData.ftlh", null);
    }

    private void profileGet(HttpExchange exchange) {
        if (isAuthorized(exchange)) {
            String query = getQueryParams(exchange);
            Map<String, String> params = Utils.parseUrlEncoded(query, "&");
            String email = params.getOrDefault("email", null);
            renderTemplate(exchange, "profile.ftlh", getEmployeeDataModel(email));
        } else {
            redirect303(exchange, "/login");
        }
    }

    private EmployeeDataModel getEmployeeDataModel(String email) {
        List<Employee> list = FileService.readEmployees();
        return list.stream()
                .filter(e -> Objects.equals(email, e.getEmail()))
                .findFirst()
                .map(EmployeeDataModel::new)
                .orElse(null);
    }

    private void registerPost(HttpExchange exchange) {
        String raw = getBody(exchange);
        Map<String, String> register = Utils.parseUrlEncoded(raw, "&");
        List<Employee> employees = FileService.readEmployees();
        String email = register.get("email");

        if (employees.stream().anyMatch(e -> e.getEmail().equals(email))) {
            redirect303(exchange, "/error");
        } else {
            String name = register.get("name");
            String surname = register.get("surname");
            String password = register.get("password");

            Employee employee = new Employee(name, surname, email, password, new ArrayList<>(), new ArrayList<>());
            employees.add(employee);
            FileService.writeEmployees(employee);
            redirect303(exchange, "/login");
        }
    }

    private void errorGet(HttpExchange exchange) {
        renderTemplate(exchange, "error.ftlh", null);
        redirect303(exchange, "/login");
    }

    private void registerGet(HttpExchange exchange) {
        renderTemplate(exchange, "register.ftlh", null);
    }

    private void loginPost(HttpExchange exchange) {
        String raw = getBody(exchange);
        Map<String, String> parsed = Utils.parseUrlEncoded(raw, "&");

        List<Employee> employees = FileService.readEmployees();

        String email = parsed.get("email");
        String password = parsed.get("password");

        if (employees.stream().anyMatch(e -> e.getEmail().equals(email) && e.getPassword().equals(password))) {
            Map<String, Object> data = new HashMap<>();
            cookie = Cookie.make("email", email);

            String cookieString = getCookies(exchange);
            Map<String, String> cookies = Cookie.parse(cookieString);
            cookie.setMaxAge(getMaxAge());
            cookie.setHttpOnly(true);

            setCookie(exchange, cookie);
            data.put("cookies", cookies);

            redirect303(exchange, "/profile?email=" + email);
        } else {
            redirect303(exchange, "/incorrectData");
        }
    }

    private void loginGet(HttpExchange exchange) {
        renderTemplate(exchange, "login.ftlh", null);
    }
}



