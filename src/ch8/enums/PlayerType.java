package ch8.enums;

public enum PlayerType {
    MUSIC(0), VIDEO(1);

    private int type;

    PlayerType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
