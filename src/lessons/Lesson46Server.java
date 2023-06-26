package lessons;

import com.sun.net.httpserver.HttpExchange;
import server.Cookie;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Lesson46Server extends Lesson45Server{
    public Lesson46Server(String host, int port) throws IOException {
        super(host, port);
        registerGet("/cookie", this::CookieHandler);
    }

    private void CookieHandler(HttpExchange exchange) {
        Map<String, Object> data = new HashMap<>();
        String name = "times";

        Cookie c1 = Cookie.make("user%Id", "456");
        setCookie(exchange, c1);

        Cookie c2 = Cookie.make("user-email", "example@gmail.com");
        setCookie(exchange, c2);

        Cookie c3 = Cookie.make("restricted()<>@,;:\\\"/[]?={}", "()<>@,;:\\\"/[]?={}");
        setCookie(exchange, c3);

        String cookieString = getCookies(exchange);
        Map<String, String> cookies = Cookie.parse(cookieString);

        String cookieValue = cookies.getOrDefault(name, "0");

        int times = Integer.parseInt(cookieValue) + 1;

        Cookie response = new Cookie<>(name, times);
        setCookie(exchange, response);

        data.put(name, times);
        data.put("cookies", cookies);
        renderTemplate(exchange, "cookie.ftlh", data);
    }
}
