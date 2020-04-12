package ch8;

public class ShapeOval extends Shape {
    public ShapeOval(int startX, int startY, int endX, int endY) {
        super(startX, startY, endX, endY);
    }

    @Override
    public int getTypeCode() {
        return Shape.TYPECODE_OVAL;
    }

    @Override
    public String getName() {
        return "Rectangle";
    }

    @Override
    public void draw() {
        drawOval();
    }

    private void drawOval() {
        System.out.println("drawOval: " + this.toString());
    }


}
