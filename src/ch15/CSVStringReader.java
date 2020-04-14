package ch15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class CSVStringReader extends CSVReader {
    private final BufferedReader bufferedReader;

    public CSVStringReader(String string) {
        bufferedReader = new BufferedReader(new StringReader(string));
    }

    @Override
    public String[] readCSV() throws IOException {
        String line = bufferedReader.readLine();
        if(line == null) {
            return null;
        } else {
            String[] item = CSV_PATTERN.split(line);
            return item;
        }
    }

    @Override
    public void close() throws IOException {
        bufferedReader.close();
    }
}
