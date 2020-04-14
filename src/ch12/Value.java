package ch12;

import java.util.ArrayList;
import java.util.List;

public class Value {
    private int value = 0;

    private final List<ValueListener> listeners = new ArrayList<>();

    public Value(int value) {
        this.value = value;
    }

    public void addValueListener(ValueListener listener) {
        listeners.add(listener);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        notifyToListeners();
    }

    private void notifyToListeners() {
        for(ValueListener listener : listeners) {
            listener.valueChanged(new ValueChangeEvent(this));
        }
    }
}
