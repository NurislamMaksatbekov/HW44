package lessons;

import com.sun.net.httpserver.HttpExchange;
import dataModel.BooksDataModel;
import dataModel.EmployersDataModel;
import server.BasicServer;

import java.io.*;

public class Lesson44Server extends BasicServer {


    public Lesson44Server(String host, int port) throws IOException {
        super(host, port);
            registerGet("/books/book", this::freemarkerBookHandler);
            registerGet("/books", this::freemarkerBooksHandler);
            registerGet("/employees", this::freemarkerEmployersHandler);
            registerGet("/employee", this::freemarkerEmployeeHandler);


    }

    private void freemarkerEmployeeHandler(HttpExchange exchange) {
        if(isAuthorized()){
            renderTemplate(exchange, "employee.ftlh", getEmployersDataModel());
        }else {
            redirect303(exchange, "/login");
        }
    }

    private void freemarkerBookHandler(HttpExchange exchange) {
        if(isAuthorized()){
            renderTemplate(exchange, "book.ftlh", null);
        }else {
            redirect303(exchange, "/login");

        }
    }


    private void freemarkerBooksHandler(HttpExchange exchange) {
        if(isAuthorized()){
            renderTemplate(exchange, "books.ftlh", getBooksDataModel());
        }else {
            redirect303(exchange, "/login");
        }
    }

    private void freemarkerEmployersHandler(HttpExchange exchange) {
        if(isAuthorized()){
            renderTemplate(exchange, "employees.ftlh", getEmployersDataModel());
        }else {
            redirect303(exchange, "/login");
        }
    }


    private BooksDataModel getBooksDataModel(){
        return new BooksDataModel();
    }

    private EmployersDataModel getEmployersDataModel(){
        return new EmployersDataModel();
    }

}
