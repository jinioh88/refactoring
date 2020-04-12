package ch8;

public class Shape {
    public static final int TYPECODE_LINE = 0;
    public static final int TYPECODE_RECTANGLE = 1;
    public static final int TYPECODE_OVAL = 2;

    private final int typeCode;
    private final int startX;
    private final int startY;
    private final int endX;
    private final int endY;

    public Shape(int typeCode, int startX, int startY, int endX, int endY) {
        this.typeCode = typeCode;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    public int getTypeCode() {
        return typeCode;
    }

    public String getName() {
        switch (typeCode) {
            case TYPECODE_LINE:
                return "LINE";
            case TYPECODE_RECTANGLE:
                return "RECTANGLE";
            case TYPECODE_OVAL:
                return "OVAL";
            default:
                return null;
        }
    }

    public void draw() {
        switch (typeCode) {
            case TYPECODE_LINE:
                drawLine();
                break;
            case TYPECODE_RECTANGLE:
                drawRactangle();
                break;
            case TYPECODE_OVAL:
                drawOval();
                break;
            default:
                ;
        }
    }

    public void drawLine() {
        System.out.println("drawLine: " + this.toString());
    }

    public void drawRactangle() {
        System.out.println("drawRectangle: " + this.toString());
    }

    public void drawOval() {
        System.out.println("drawOval: " + this.toString());
    }

    @Override
    public String toString() {
        return "Shape{" +
                "typeCode=" + typeCode +
                ", startX=" + startX +
                ", startY=" + startY +
                ", endX=" + endX +
                ", endY=" + endY +
                '}';
    }
}
