package ch8;

public class ShapeLine extends Shape {

    public ShapeLine(int startX, int startY, int endX, int endY) {
        super(startX, startY, endX, endY);
    }

    @Override
    public int getTypeCode() {
        return Shape.TYPECODE_LINE;
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

    public static ShapeLine createShapeLie(int startX, int startY, int endX, int endY) {
        return new ShapeLine(startX, startY, endX, endY);
    }

    public static ShapeRectangle createRectangle(int startX, int startY, int endX, int endY) {
        return new ShapeRectangle(startX, startY, endX, endY);
    }

    public static ShapeOval createOval(int startX, int startY, int endX, int endY) {
        return new ShapeOval(startX, startY, endX, endY);
    }
}
