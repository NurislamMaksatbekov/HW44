package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Book;
import lesson44.Collection;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileService {
    private static final Gson GSON = new GsonBuilder().create();
    private static final Path PATH = Paths.get("data/books.json");

    public static List<Book> readBooks()  {
        String json = "";
        try {
            json = Files.readString(PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return GSON.fromJson(json, Collection.class).getBook();
    }


}
