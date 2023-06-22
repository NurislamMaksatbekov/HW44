package lessons;

import com.sun.net.httpserver.HttpExchange;
import dataModel.BooksDataModel;
import dataModel.EmployersDataModel;
import dataModel.SampleDataModel;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import server.BasicServer;
import server.ContentType;
import server.ResponseCodes;

import java.io.*;

public class Lesson44Server extends BasicServer {

    public Lesson44Server(String host, int port) throws IOException {
        super(host, port);
        registerGet("/sample", this::freemarkerSampleHandler);
        registerGet("/book", this::freemarkerBookHandler);
        registerGet("/books", this::freemarkerBooksHandler);
        registerGet("/employers", this::freemarkerEmployersHandler);
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
        renderTemplate(exchange, "employers.ftlh", getEmployersDataModel());
    }

    private void freemarkerSampleHandler(HttpExchange exchange) {
        renderTemplate(exchange, "sample.ftlh", getSampleDataModel());
    }


    private BooksDataModel getBooksDataModel(){
        return new BooksDataModel();
    }

    private EmployersDataModel getEmployersDataModel(){
        return new EmployersDataModel();
    }

    private SampleDataModel getSampleDataModel() {
        // возвращаем экземпляр тестовой модели-данных
        // которую freemarker будет использовать для наполнения шаблона
        return new SampleDataModel();
    }
}
