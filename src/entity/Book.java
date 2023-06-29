package entity;

public class Book {
    private int id;
    private final String title;
    private final String author;
    private final String image;
    private boolean status;

    public Book(int id, String title, String author, String image, boolean status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.image = image;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }


    public String getImage() {
        return image;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
