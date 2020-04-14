package ch15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

public class CSVFileReader extends CSVReader {
    public CSVFileReader(String fileName) throws IOException {
        super(new BufferedReader(new FileReader(fileName)));
    }
}
