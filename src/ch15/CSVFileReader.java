package ch15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVFileReader extends CSVReader {
    private final BufferedReader bufferedReader;

    public CSVFileReader(String fileName) throws IOException {
        this.bufferedReader = new BufferedReader(new FileReader(fileName));
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
