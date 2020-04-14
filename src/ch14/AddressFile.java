package ch14;

import java.io.IOException;
import java.util.Enumeration;

public class AddressFile {
    private final Database database;

    public AddressFile(String fileName) {
        this.database = new Database(fileName);
    }

    public Enumeration names() {
        return database.keys();
    }

    public void set(String key, String value) {
        database.set(key, value);
    }

    public String get(String key) {
        return database.get(key);
    }

    public void update() throws IOException {
        database.update();
    }
}
