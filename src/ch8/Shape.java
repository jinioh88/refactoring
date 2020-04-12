package ch8;

public abstract class Shape {
    public static final int TYPECODE_LINE = 0;
    public static final int TYPECODE_RECTANGLE = 1;
    public static final int TYPECODE_OVAL = 2;

    private final int startX;
    private final int startY;
    private final int endX;
    private final int endY;

    public Shape(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    public abstract int getTypeCode();

    public abstract String getName();

    public abstract void draw();

    public static Shape createShape(ShapeFactory factory, int startX, int startY, int endX, int endY) {
        return factory.create(startX, startY, endX, endY);
    }


    @Override
    public String toString() {
        return "Shape{" +
                "startX=" + startX +
                ", startY=" + startY +
                ", endX=" + endX +
                ", endY=" + endY +
                '}';
    }
}
