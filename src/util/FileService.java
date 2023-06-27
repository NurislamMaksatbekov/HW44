package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import entity.Book;
import entity.Employee;
import entity.Library;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileService {

    private FileService(){}
    private static final Gson GSON = new GsonBuilder().create();
    private static final Path PATH = Paths.get("json/books.json");
    private static final Path WAY = Paths.get("json/employers.json");

    public static List<Book> readBooks()  {
        String json = "";
        try {
            json = Files.readString(PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return GSON.fromJson(json, Library.class).getBooks();
    }

    public static List<Employee> readEmployees()  {
        Type list = new TypeToken<List<Employee>>(){}.getType();
        String json = "";
        try {
            json = Files.readString(WAY);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return GSON.fromJson(json, list);
    }

    public static void writeEmployees(Employee employee){
        List<Employee> employees = readEmployees();
        employee.setId(employees.size() + 1);
        employees.add(employee);
        try (Writer writer = new FileWriter(WAY.toString())){
            String json = GSON.toJson(employees);
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
