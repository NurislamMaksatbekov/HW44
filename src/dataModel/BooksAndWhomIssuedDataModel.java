package dataModel;

import java.util.List;

public class BooksAndWhomIssuedDataModel {

    private List<BookAndWhomIssued> books;

    public BooksAndWhomIssuedDataModel(List<BookAndWhomIssued> books) {
        this.books = books;
    }

    public List<BookAndWhomIssued> getBooks() {
        return books;
    }
}
