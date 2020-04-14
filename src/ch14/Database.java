package ch14;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class Database {
    private final Properties properties;
    private final String fileName;

    public Database(String fileName) {
        this.fileName = fileName;
        properties = new Properties();
        try {
            properties.load(new FileInputStream(fileName));
        } catch (IOException e) {
        }
    }

    public void set(String key, String value) {
        properties.setProperty(key, value);
    }

    public String get(String key) {
        return properties.getProperty(key, null);
    }

    public void update() throws IOException {
        properties.store(new FileOutputStream(fileName), "");
    }

    public Enumeration keys() {
        return properties.propertyNames();
    }
}
