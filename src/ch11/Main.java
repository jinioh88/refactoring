package ch11;

public class Main {
    public static void main(String[] args) {
        Shape line = Shape.crateLine(0, 0, 100, 200);
        Shape rectangle = Shape.crateRectangle(10, 20, 30, 40);
        Shape oval = Shape.crateOval(100, 200, 300, 400);

        Shape[] shapes = {
                line, rectangle, oval,
        };

        for(Shape s : shapes) {
            s.draw();
        }
    }
}
