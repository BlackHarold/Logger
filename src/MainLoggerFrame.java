
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.*;

public class MainLoggerFrame {

    public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException {

        //главная форма (смотри класс)
        MyJFrame cfFrame = new MyJFrame("Приложение LOGGER_v0.01", 800, 600);

        //1. текстовые поле для отображения выбранного файла
        JTextField txtField = new JTextField();
        //2. текстовая область отображает содержание выбраного файла
        JTextPane txtPane = new JTextPane();
        //3. текстовое поле для поиска текста
        JTextField txtField2 = new JTextField("Поиск текста");

        //буфер обмена
        //MyBufferReader myBufferReader = new MyBufferReader(txtField.getText());

        // кнопки
        MyOpenButton cfButton = new MyOpenButton("Выбор файла", "Выбор файла");
        MyOpenButton okButton = new MyOpenButton("OK", "OK");

        //выбор файла -> смотри класс MyFileChooser
        MyFileChooser fileChooser = new MyFileChooser();
        fileChooser.addActionListener(fileChooser);
        MyBufferReader myBufferReader = new MyBufferReader();

        // описание работы кнопки "Выбор файла"
        cfButton.addActionListener(e -> {
            //обработчик события для разных кнопок
            if (cfButton.getName().equalsIgnoreCase("Выбор файла")) {
                System.out.println("Нажата кнопка " + "\"" + cfButton.getName() + "\"");
                fileChooser.showOpenDialog(null);
                txtField.setText(fileChooser.filePath);
                FileInputStream fis = null;
                try {
                    fis = new FileInputStream((fileChooser.filePath).toString());
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                //FileOutputStream fos = new FileOutputStream("");

                try {
                    BufferedReader br = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
                } catch (UnsupportedEncodingException e1) {
                    e1.printStackTrace();
                }
                //BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(fos));
                myBufferReader.setPath();
                //myBufferReader.doRead();
            }
        });

        //описание работы кнопки "ОК" (пока только пишет хлам
        okButton.addActionListener(e -> {
            if (okButton.getName().equalsIgnoreCase("OK")) {
                System.out.println("Нажата кнопка " + "OK");
            }
        });

        //назначение подчинения расположения для панелей
        JPanel panel_1 = new JPanel(new BorderLayout());
        JPanel panel_2 = new JPanel(new BorderLayout());
        JPanel panel_3 = new JPanel(new BorderLayout());

        //1. добавленеие элементов на панель_1 (верх окна)
        panel_1.add(cfButton, BorderLayout.WEST);
        panel_1.add(txtField, BorderLayout.CENTER);
        panel_1.add(okButton, BorderLayout.EAST);

        //добавление рамок на все панели
        Border etched = BorderFactory.createEtchedBorder();
        panel_1.setBorder(etched);
        panel_2.setBorder(etched);
        panel_3.setBorder(etched);

        //2. добавленеие элементов на панель_2 (центр окна)
        panel_2.add(txtPane);

        //3. расположение элементов в панели_3 (низ окна)
        panel_3.add(txtField2);

        //расположение элементов на фрейме согласно сторонам света
        cfFrame.add(panel_1, BorderLayout.NORTH);
        cfFrame.add(panel_2, BorderLayout.CENTER);
        cfFrame.add(panel_3, BorderLayout.SOUTH);

        cfFrame.setVisible(true);
    }
}

