package ch14;

import java.io.IOException;
import java.util.Enumeration;

public class Main {
    public static void main(String[] args) {
        try {
            AddressFile file = new AddressFile("dbfile.txt");
            file.set("Hiroshi Yuki", "hyuki@example.com");
            file.set("Sejin", "jinioh@example.com");
            file.set("James", "james@example.com");
            file.update();

            Enumeration e = file.names();
            while(e.hasMoreElements()) {
                String name = (String) e.nextElement();
                String mail = file.get(name);
                System.out.println("name = " + name + ", mail = " + mail);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
