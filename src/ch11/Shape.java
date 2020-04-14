package ch11;

public abstract class Shape {
    private final int startX;
    private final int startY;
    private final int endX;
    private final int endY;

    protected Shape(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    public static Shape crateLine(int startX, int startY, int endX, int endY) {
        return new ShapeLine(startX, startY, endX, endY);
    }

    public static Shape crateRectangle(int startX, int startY, int endX, int endY) {
        return new ShapeRectangle(startX, startY, endX, endY);
    }

    public static Shape crateOval(int startX, int startY, int endX, int endY) {
        return new ShapeOval(startX, startY, endX, endY);
    }

    @Override
    public String toString() {
        return "Shape{" +
                ", startX=" + startX +
                ", startY=" + startY +
                ", endX=" + endX +
                ", endY=" + endY +
                '}';
    }

    public abstract String getName();
    public abstract void draw();

}
