package entity;

import entity.Book;
import entity.Employee;

import java.util.List;

public class Library {

    public Library(List<Book> books, List<Employee> employers) {
        this.books = books;
        this.employers = employers;
    }

    private List<Book> books;

    private List<Employee> employers;

    public List<Book> getBook() {
        return books;
    }

    public List<Employee> getEmployers() {
        return employers;
    }



}
