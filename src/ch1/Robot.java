package ch1;

public class Robot {
    private final String  _name;

    public Robot(String name) {
        this._name = name;
    }

    public void order(int command) {
        if(command == 0) {
            System.out.println(_name + " works.");
        } else if(command == 1) {
            System.out.println(_name + " stops.");
        } else if(command == 2) {
            System.out.println(_name + " jumps.");
        } else {
            System.out.println("Command error. command = " + command);
        }
    }
}
