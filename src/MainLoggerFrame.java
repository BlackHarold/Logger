import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainLoggerFrame {

    public static void main(String[] args) {

        //применяем скин для программы
        try {
            UIManager.setLookAndFeel(new AluminiumLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            System.out.println("Неудачная попытка создания окна");
        }

        //главная форма (смотри класс)
        MyJFrame cfFrame = new MyJFrame("Приложение LOGGER_v0.01", 800, 600);

        //1. текстовые поле для отображения выбранного файла
        MyJTextField txtField = new MyJTextField();
        //2. текстовая область отображает содержание выбраного файла
        JTextPane txtPane = new JTextPane();
        //3. текстовое поле для поиска текста
        JTextField txtField2 = new JTextField("Поиск текста");

        //кнопки | добавление слушателей | снятие фокуса
        MyOpenButton cfButton = new MyOpenButton("Выбор файла", "Выбор файла");
        MyOpenButton okButton = new MyOpenButton("OK", "OK");
        //MyOpenDialog dialog = new MyOpenDialog();

        //выбор файла смотри класс MyFileChooser
        MyFileChooser fileChooser = new MyFileChooser();
        fileChooser.addActionListener(fileChooser);

        cfButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //обработчик события для разных кнопок
                if (cfButton.getName().equalsIgnoreCase("Выбор файла")) {
                    System.out.println("Нажата кнопка " + "\"" + cfButton.getName() + "\"");
                    fileChooser.showOpenDialog(null);
                    fileChooser.setVisible(true);
                    //dialog.getSelectedFile(String.valueOf(fileChooser.getSelectedFile()));
                    //System.out.println(dialog.filePath);
                }
            }
        });
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (okButton.getName().equalsIgnoreCase("OK")) {
                    System.out.println("Нажата кнопка " + "OK");

                }
            }
        });
        cfButton.setFocusable(false);
        okButton.setFocusable(false);

        JPanel panel_1 = new JPanel(new BorderLayout());
        JPanel panel_2 = new JPanel(new BorderLayout());
        JPanel panel_3 = new JPanel(new BorderLayout());

        panel_1.add(cfButton, BorderLayout.WEST);
        panel_1.add(txtField, BorderLayout.CENTER);
        panel_1.add(okButton, BorderLayout.EAST);

        Border etched = BorderFactory.createEtchedBorder();
        panel_1.setBorder(etched);
        panel_2.setBorder(etched);
        panel_3.setBorder(etched);

        panel_2.add(txtPane);

        //расположение элементов в панели_3 (низ окна)
        panel_3.add(txtField2);

        //расположение элементов на фрейме согласно сторонам света
        cfFrame.add(panel_1, BorderLayout.NORTH);
        cfFrame.add(panel_2, BorderLayout.CENTER);
        cfFrame.add(panel_3, BorderLayout.SOUTH);

        cfFrame.setVisible(true);
    }
}

