package service;

import dataModel.BookAndWhomIssued;
import dataModel.BookDataModel;
import dataModel.BooksAndWhomIssuedDataModel;
import entity.Book;
import entity.Employee;
import util.FileService;

import java.util.ArrayList;
import java.util.List;

public class BookService {
    private static BookService instance;

    private  List<Book> books = new ArrayList<>();
    private  List<Employee> employees = new ArrayList<>();

    public BookService() {
        this.books.addAll(FileService.readBooks());
        this.employees.addAll(FileService.readEmployees());
    }

    public static BookService getInstance(){
        if(instance == null){
            instance = new BookService();
        }
        return instance;
    }

    public BooksAndWhomIssuedDataModel getBooksAndWhomIssued() {
        List<BookAndWhomIssued> list = new ArrayList<>();
        books.forEach(e -> list.add(new BookAndWhomIssued(e, getWhomIssued(e))));
        return new BooksAndWhomIssuedDataModel(list);
    }

    private Employee getWhomIssued(Book book) {
        Employee employee = null;
        for (var e : employees){
            boolean issued = e.getReading().stream()
                    .anyMatch(i -> i.getId() == (book.getId()));
            if (issued) {
                employee = e;
            }
        }
        return employee;
    }

    public BookDataModel getBook(){
        return new BookDataModel(books.get(0));
    }
}
