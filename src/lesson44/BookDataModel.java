package lesson44;

import entity.Book;
import util.FileService;

import java.util.ArrayList;
import java.util.List;

public class BookDataModel {

    private final List<Book> books = new ArrayList<>();

    public BookDataModel() {
        books.addAll(FileService.readBooks());
    }

    public List<Book> getBooks() {
        return books;
    }
}
