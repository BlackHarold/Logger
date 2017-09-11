import javax.swing.*;

class MyOpenButton extends JButton {

    MyOpenButton(String title, String name) {
        super(title);
        this.setName(name);
        setFocusable(false);
    }
}
