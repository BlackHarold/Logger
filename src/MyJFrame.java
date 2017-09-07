import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MyJFrame extends JFrame {

    public MyJFrame(String title, int width, int height) {
        setName(title);
        setSize(width, height);

        //текстовые поле для отображения выбранного файла
        MyJTextField txtField = new MyJTextField();
        txtField.addActionListener(txtField);

        //текстовое поле для поиска текста
        JTextField txtField2 = new JTextField("Поиск текста");

        //текстовая область отображает содержание выбраного файла
        JTextPane txtPane = new JTextPane();

        //кнопки | добавление слушателей | снятие фокуса
        MyOpenButton cfButton = new MyOpenButton("Выбор файла", "Выбор файла");
        MyOpenButton okButton = new MyOpenButton("ОК", "ОК");
        //MyOpenDialog dialog = new MyOpenDialog();
        cfButton.addActionListener(cfButton);
        okButton.addActionListener(okButton);
        cfButton.setFocusable(false);
        okButton.setFocusable(false);

        //размещения элементов на панелях
        JPanel panel_1 = new JPanel(new BorderLayout());
        JPanel panel_2 = new JPanel(new BorderLayout());
        JPanel panel_3 = new JPanel(new BorderLayout());

        //описание рамки и присваивание панелям
        Border etched = BorderFactory.createEtchedBorder();
        panel_1.setBorder(etched);
        panel_2.setBorder(etched);
        panel_3.setBorder(etched);

        //расположение элементов в панели_1 (верх окна)
        panel_1.add(cfButton, BorderLayout.WEST);
        panel_1.add(txtField, BorderLayout.CENTER);
        panel_1.add(okButton, BorderLayout.EAST);

        //расположение окна редактора по центру занимает всю область
        panel_2.add(txtPane);

        //расположение элементов в панели_3 (низ окна)
        panel_3.add(txtField2);

        //расположение элементов на фрейме согласно сторонам света
        add(panel_1, BorderLayout.NORTH);
        add(panel_2, BorderLayout.CENTER);
        add(panel_3, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }


}
