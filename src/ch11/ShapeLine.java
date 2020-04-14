package ch11;

import ch8.Shape;
import ch8.ShapeOval;
import ch8.ShapeRectangle;

public class ShapeLine extends ch11.Shape {

    public ShapeLine(int startX, int startY, int endX, int endY) {
        super(startX, startY, endX, endY);
    }

    @Override
    public String getName() {
        return "Line";
    }

    @Override
    public void draw() {
        drawLine();
    }

    private void drawLine() {
        System.out.println("drawLine: " + this.toString());
    }

}
