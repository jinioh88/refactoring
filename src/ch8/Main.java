package ch8;

import ch8.enums.PlayerType;

public class Main {
    public static void main(String[] args) {
//        Shape line = ShapeLine.createShapeLie(0, 0, 100, 200);
//        Shape rectangle = ShapeLine.createRectangle(10, 20, 30, 40);
//        Shape oval = ShapeLine.createOval(100, 200, 300, 400);
//
//        Shape[] shape = {
//                line, rectangle, oval
//        };
//
//        for (Shape s : shape) {
//            s.draw();
//        }

        Player[] players = {
                Player.create(PlayerType.MUSIC),
                Player.create(PlayerType.VIDEO),
        };

        for (Player player : players) {
            player.play();
            player.stop();
        }
    }

}
