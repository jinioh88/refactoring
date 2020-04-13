package ch10;

public class Position {
    public int x;
    public int y;

    public Position(int i, int i1) {
        x = i;
        y = i1;
    }

    public void relativeMove(int dx, int dy) {
        x += dx;
        y += dy;
    }
}
