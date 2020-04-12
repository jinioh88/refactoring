package ch9;

public class Logger {

    private State state;

    public Logger() {
        setState(State.STATE_STOPPED);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void start() {
        state.start();
        setState(State.STATE_LOGGING);
    }

    public void stop() {
        state.stop();
        setState(State.STATE_STOPPED);
    }

    public void log(String info) {
        state.log(info);
    }
}
