import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;

import javax.swing.*;

public class MyJFrame extends JFrame {

    public MyJFrame(String title, int width, int height) {
        try {
            UIManager.setLookAndFeel(new AluminiumLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            System.out.println("Неудачная попытка создания окна");
        }

        setName(title);
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


}
