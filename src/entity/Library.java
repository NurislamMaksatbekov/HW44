package entity;

import java.util.List;

public class Library {

    public Library(Book book, List<Book> books, Employee employee, List<Employee> employers) {
        this.book = book;
        this.books = books;
        this.employee = employee;
        this.employers = employers;
    }

    private Book book;
    private List<Book> books;
    private Employee employee;
    private List<Employee> employers;

    public Book getBook(){
        return book;
    }

    public List<Book> getBooks() {
        return books;
    }

    public Employee getEmployee(){
        return employee;
    }

    public List<Employee> getEmployers() {
        return employers;
    }



}
