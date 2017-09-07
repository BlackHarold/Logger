import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyFileChooser extends JFileChooser implements ActionListener {

    static String filePath;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (APPROVE_OPTION == 0) {
            filePath = String.valueOf(this.getSelectedFile());
            System.out.println(filePath);
            this.setVisible(false);
        }
    }
}
