package ch2;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SimpleDatabase {
    private Map<String, String> map = new HashMap<>();

    public SimpleDatabase(Reader r) throws IOException {
        BufferedReader reader = new BufferedReader(r);
        String line;

        while(true) {
            line = reader.readLine();
            if(line == null) {
                break;
            }

            int equalIndex = line.indexOf("=");
            if(equalIndex > 0) {
                String key = line.substring(0, equalIndex);
                String val = line.substring(equalIndex + 1, line.length());
                map.put(key, val);
            }
        }
    }

    public void putValue(String key, String value) {
        map.put(key, value);
    }

    public String getValue(String key) {
        return map.get(key);
    }

    public Iterator<String> iterator() {
        return map.keySet().iterator();
    }
}
