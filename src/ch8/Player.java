package ch8;

import ch8.enums.PlayerType;

public abstract class Player {

    public static Player create(PlayerType type) {
        switch (type) {
            case MUSIC:
                return new MusicPlayer();
            case VIDEO:
                return new VideoPlayer();
            default:
                throw new IllegalArgumentException("type = " + type);
        }
    }

    public abstract void play();

    public abstract void loop();

    public abstract void stop();
}
