package dataModel;

import entity.Book;
import entity.Employee;

public class BookAndWhomIssued {

    private Book book;
    private Employee customer;

    public BookAndWhomIssued(Book book, Employee customer) {
        this.book = book;
        this.customer = customer;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Employee getCustomer() {
        return customer;
    }

    public void setCustomer(Employee customer) {
        this.customer = customer;
    }

}
