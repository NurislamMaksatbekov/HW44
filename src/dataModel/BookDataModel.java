package dataModel;

import entity.Book;

public class BookDataModel {
    private Book book;

    public BookDataModel(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
