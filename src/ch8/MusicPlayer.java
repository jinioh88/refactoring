package ch8;

public class MusicPlayer extends Player {

    @Override
    public void play() {
        System.out.println("Music: play");
    }

    @Override
    public void loop() {
        System.out.println("Music: loop");
    }

    @Override
    public void stop() {
        System.out.println("Music: stop");
    }
}
