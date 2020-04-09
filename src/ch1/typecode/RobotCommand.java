package ch1.typecode;

public class RobotCommand {
    private final String name;

    public RobotCommand(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RobotCommand{" +
                "name='" + name + '\'' +
                '}';
    }
}
