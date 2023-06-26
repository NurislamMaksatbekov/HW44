package lessons;

import com.sun.net.httpserver.HttpExchange;
import dataModel.BooksDataModel;
import dataModel.EmployersDataModel;
import server.BasicServer;

import java.io.*;

public class Lesson44Server extends BasicServer {

    public Lesson44Server(String host, int port) throws IOException {
        super(host, port);
        registerGet("/book", this::freemarkerBookHandler);
        registerGet("/books", this::freemarkerBooksHandler);
        registerGet("/employees", this::freemarkerEmployersHandler);
        registerGet("/employee", this::freemarkerEmployeeHandler);
    }

    private void freemarkerEmployeeHandler(HttpExchange exchange) {
        renderTemplate(exchange, "employee.ftlh", getEmployersDataModel());
    }

    private void freemarkerBookHandler(HttpExchange exchange) {
        renderTemplate(exchange, "book.ftlh", getBooksDataModel());
    }


    private void freemarkerBooksHandler(HttpExchange exchange) {
        renderTemplate(exchange, "books.ftlh", getBooksDataModel());
    }

    private void freemarkerEmployersHandler(HttpExchange exchange) {
        renderTemplate(exchange, "employees.ftlh", getEmployersDataModel());
    }


    private BooksDataModel getBooksDataModel(){
        return new BooksDataModel();
    }

    private EmployersDataModel getEmployersDataModel(){
        return new EmployersDataModel();
    }

}
