package ch1;

import ch1.typecode.RobotCommand;

public class Robot {
    public static final RobotCommand COMMAND_WALK = new RobotCommand("WALK");
    public static final RobotCommand COMMAND_STOP = new RobotCommand("STOP");
    public static final RobotCommand COMMAND_JUMP = new RobotCommand("JUMP");;

    private final String  _name;

    public Robot(String name) {
        this._name = name;
    }

    public void order(RobotCommand command) {
        if(command == COMMAND_WALK) {
            System.out.println(_name + " works.");
        } else if(command == COMMAND_STOP) {
            System.out.println(_name + " stops.");
        } else if(command == COMMAND_JUMP) {
            System.out.println(_name + " jumps.");
        } else {
            System.out.println("Command error. command = " + command);
        }
    }
}
