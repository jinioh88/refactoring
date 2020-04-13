package ch10;

import java.util.HashMap;
import java.util.Map;

public class Command {
    public static final Command FORWARD = new Command("forward");
    public static final Command BACKWARD = new Command("backward");
    public static final Command TURN_RIGHT = new Command("right");
    public static final Command TURN_LEFT = new Command("left");

    private static final Map<String, Command> commandNameMap = new HashMap<>();

    static {
        commandNameMap.put(FORWARD.name, FORWARD);
        commandNameMap.put(BACKWARD.name, BACKWARD);
        commandNameMap.put(TURN_RIGHT.name, TURN_RIGHT);
        commandNameMap.put(TURN_LEFT.name, TURN_LEFT);
    }

    private final String name;

    public Command(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Command parseCommand(String name) {
        if(!commandNameMap.containsKey(name)) {
            return null;
        }

        return commandNameMap.get(name);
    }
}
