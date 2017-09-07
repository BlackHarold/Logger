import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyJTextField extends JTextField {
    private String t;

    MyJTextField() {
        setEditable(false);
    }

    public String getText() {
        return t;
    }

    public void setText(String t) {
        this.t = t;
    }

    /*@Override
    public void actionPerformed(ActionEvent st) {
        setText(t);
    }*/
}
