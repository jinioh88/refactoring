package ch4;

public class NullLabel extends Label {
    private static final NullLabel singleton = new NullLabel();

    public static NullLabel getInstance() {
        return singleton;
    }

    public NullLabel() {
        super("(none)");
    }

    @Override
    public boolean isNull() {
        return true;
    }

    @Override
    public void display() {
    }
}
