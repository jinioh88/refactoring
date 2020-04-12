package ch8;

public class VideoPlayer extends Player {

    @Override
    public void play() {
        System.out.println("Video: play");
    }

    @Override
    public void loop() {
        System.out.println("Video: loop");
    }

    @Override
    public void stop() {
        System.out.println("Video: stop");
    }
}
