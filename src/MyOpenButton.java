import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyOpenButton extends JButton {

    MyOpenButton(String title, String name) {
        super(title);
        this.setName(name);
        setFocusable(false);
    }
}
