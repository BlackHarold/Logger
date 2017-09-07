import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;

import javax.swing.*;

public class MainLoggerFrame {

    private static String filepath;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new AluminiumLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            System.out.println("Неудачная попытка создания окна");
        }

        //главная форма (смотри класс)
        MyJFrame cfFrame = new MyJFrame("Приложение LOGGER_v0.01", 800, 600);
    }
}

