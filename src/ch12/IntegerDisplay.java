package ch12;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class IntegerDisplay extends Frame implements ActionListener {
    private final Label octalLabel = new Label("0");
    private final Label decimalLabel = new Label("0");
    private final Label hexadecimalLabel = new Label("0");
    private final Button incrementButton = new Button("+");
    private final Button decrementButton = new Button("-");

    private int value = 0;

    public IntegerDisplay() {
        super("IntegerDisplay");

        setLayout(new GridLayout(4, 2));
        add(new Label("Octal:"));
        add(octalLabel);

        add(new Label("Decimal:"));
        add(decimalLabel);

        add(new Label("Hexadecimal:"));
        add(hexadecimalLabel);

        add(incrementButton);
        add(decrementButton);

        incrementButton.addActionListener(this);
        decrementButton.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == incrementButton) {
            setValue(value + 1);
        } else if(e.getSource() == decrementButton) {
            setValue(value -1);
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        octalLabel.setText(Integer.toString(value, 8));
        decimalLabel.setText(Integer.toString(value, 10));
        hexadecimalLabel.setText(Integer.toString(value, 16));
    }
}
