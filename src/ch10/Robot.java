package ch10;

import java.util.StringTokenizer;

public class Robot {
    private final String name;
    private final Position position = new Position(0,0);
    private final Direction direction = new Direction(0, 1);

    public Robot(String name) {
        this.name = name;
    }

    public void execute(String commandSequence) {
        StringTokenizer tokenizer = new StringTokenizer(commandSequence);
        while(tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if(!executeCommand(token)) {
                System.out.println("Invalid command: " + token);
                break;
            }
        }
    }

    private boolean executeCommand(String commandString) {
        Command command = Command.parseCommand(commandString);
        if(command == null) {
            return false;
        }

        return executeCommand(command);
    }

    private boolean executeCommand(Command command) {
        if(command == Command.FORWARD) {
            position.relativeMove(direction.x, direction.y);
        } else if(command == Command.BACKWARD) {
            position.relativeMove(-direction.x, -direction.y);
        } else if(command == Command.TURN_RIGHT) {
            direction.setDirection(direction.x, direction.y);
        } else if(command == Command.TURN_LEFT) {
            direction.setDirection(-direction.x, -direction.y);
        } else {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "name='" + name + '\'' +
                ", position=" + position +
                ", direction=" + direction +
                '}';
    }
}
