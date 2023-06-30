package entity;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private List<Book> read = new ArrayList<>();
    private List<Book> reading = new ArrayList<>();

    public Employee() {
    }

    public Employee(String name, String surname, String email, String password, List<Book> read, List<Book> reading) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.read = read;
        this.reading = reading;
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

    public List<Book> getRead() {
        return read;
    }

    public void setRead(List<Book> read) {
        this.read = read;
    }

    public List<Book> getReading() {
        return reading;
    }

    public void setReading(List<Book> reading) {
        this.reading = reading;
    }
}

