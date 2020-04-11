package ch4;

public class Person {
    private final Label _name;
    private final Label _mail;

    public Person(Label name, Label mail) {
        _name = name;
        _mail = mail;
    }

    public Person(Label name) {
        this(name, Label.newNull());
    }

    public void display() {
        _name.display();

        _mail.display();
    }

    public String toString() {
        String result = "[ Person:";

        result += " name=";
        if (!_name.isNull()) {
            result += "\"(none)\"";
        } else {
            result += _name;
        }

        result += " mail=";
        if (!_mail.isNull()) {
            result += "\"(none)\"";
        } else {
            result += _mail;
        }

        result += " ]";

        return result;
    }
}
