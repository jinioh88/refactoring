package ch2;

import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class Main {
    private Point[] point;
    public static void main(String[] args) {
        try {
            SimpleDatabase db = new SimpleDatabase(new FileReader("dbfile.txt"));
            Iterator<String> it = db.iterator();
            while(it.hasNext()) {
                String key = it.next();
                System.out.println("KEY: \"" + key + "\"");
                System.out.println("VALUE: \"" + db.getValue(key) + "\"");
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean existPoint(int x, int y) {
        boolean f = false;
        boolean ff = false;
        for(int i = 0; i < point.length; i++) {
            if(point[i].x == x && point[i].y == y) {
                return true;
            }
        }
        return false;
    }
}
