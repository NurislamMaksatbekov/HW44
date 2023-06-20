package dataModel;

import entity.Book;
import util.FileService;

import java.util.ArrayList;
import java.util.List;

public class BooksDataModel {

    private final List<Book> books = new ArrayList<>();

    public BooksDataModel() {
        books.addAll(FileService.readBooks());
    }

    public List<Book> getBooks() {
        return books;
    }
}
