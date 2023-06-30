package lessons;

import com.sun.net.httpserver.HttpExchange;
import dataModel.BookDataModel;
import dataModel.BooksDataModel;
import dataModel.EmployeesDataModel;
import entity.Book;
import server.BasicServer;
import util.FileService;
import util.Utils;

import java.io.*;
import java.util.List;
import java.util.Map;

public class Lesson44Server extends BasicServer {


    public Lesson44Server(String host, int port) throws IOException {
        super(host, port);
        registerGet("/books/book", this::freemarkerBookHandler);
            registerGet("/books", this::freemarkerBooksHandler);
            registerGet("/employees", this::freemarkerEmployersHandler);
            registerGet("/employee", this::freemarkerEmployeeHandler);
    }

    private void freemarkerEmployeeHandler(HttpExchange exchange) {
        if(isAuthorized(exchange)){
            renderTemplate(exchange, "employee.ftlh", getEmployersDataModel());
        }else {
            redirect303(exchange, "/login");
        }
    }

    private void freemarkerBookHandler(HttpExchange exchange) {
        if(isAuthorized(exchange)){
            String query = getQueryParams(exchange);
            Map<String, String> params = Utils.parseUrlEncoded(query, "&");
            String id = params.getOrDefault("id", "null");
            renderTemplate(exchange, "book.ftlh", getBookDataModel(id));
        }else {
            redirect303(exchange, "/login");

        }
    }

    private void freemarkerBooksHandler(HttpExchange exchange) {
        if(isAuthorized(exchange)){
            renderTemplate(exchange, "books.ftlh", getBooksDataModel());
        }else {
            redirect303(exchange, "/login");
        }
    }

    private void freemarkerEmployersHandler(HttpExchange exchange) {
        if(isAuthorized(exchange)){
            renderTemplate(exchange, "employees.ftlh", getEmployersDataModel());
        }else {
            redirect303(exchange, "/login");
        }
    }

    private BooksDataModel getBooksDataModel(){
        return new BooksDataModel();
    }

    private BookDataModel getBookDataModel(String bookId){
        int id = Integer.parseInt(bookId);
        List<Book> list = FileService.readBooks();
        Book book = list.stream()
                .filter(e -> id == e.getId())
                .findAny()
                .orElse(list.get(0));
        return new BookDataModel(book);
    }

    private EmployeesDataModel getEmployersDataModel(){
        return new EmployeesDataModel();
    }

}
