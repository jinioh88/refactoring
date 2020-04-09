package ch1.enums;

import ch1.typecode.RobotCommand;

public class Robot {
    private final String name;
    
    public enum Command {
        WALK, STOP, JUMP,
    };

    public Robot(String name) {
        this.name = name;
    }

    public void order(Robot.Command command) {
        if(command == Command.WALK) {
            System.out.println(name + " works.");
        } else if(command == Command.STOP) {
            System.out.println(name + " stops.");
        } else if(command == Command.JUMP) {
            System.out.println(name + " jumps.");
        } else {
            System.out.println("Command error. command = " + command);
        }
    }
}
