package entity;

import java.util.List;

public class Employee {

    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private int read;
    private int reading;
    private List<Book> readBook;
    private List<Book> readingBook;
    private boolean authorized;

    public Employee(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Employee(String name, String surname, String email, String password, int read, int reading, List<Book> readBook, List<Book> readingBook) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.read = read;
        this.reading = reading;
        this.readBook = readBook;
        this.readingBook = readingBook;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRead() {
        return read;
    }

    public void setRead(int read) {
        this.read = read;
    }

    public int getReading() {
        return reading;
    }

    public void setReading(int reading) {
        this.reading = reading;
    }

    public List<Book> getReadBook() {
        return readBook;
    }

    public void setReadBook(List<Book> readBook) {
        this.readBook = readBook;
    }

    public List<Book> getReadingBook() {
        return readingBook;
    }

    public void setReadingBook(List<Book> readingBook) {
        this.readingBook = readingBook;
    }

    public boolean isAuthorized() {
        return authorized;
    }

    public void setAuthorized(boolean authorized) {
        this.authorized = authorized;
    }
}

