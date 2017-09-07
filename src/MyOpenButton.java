import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyOpenButton extends JButton implements ActionListener {

    private String text;

    MyOpenButton(String title, String name) {
        super(title);
        this.setName(name);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //обработчик события для разных кнопок
        if (this.getName().equalsIgnoreCase("OK")) {
            System.out.println("Нажата кнопка " + "ОК");
          /*считываем путь в строку;
            считываем файл по пути в строке
            выводим весь файл в окно txtPane*/



        } else if (this.getName().equalsIgnoreCase("Выбор файла")) {
            System.out.println("Нажата кнопка " + "\"" + this.getName() + "\"");
            MyOpenDialog dialog = new MyOpenDialog();
            dialog.showDialog(null, "Открыть");
            MyFileChooser fileChooser = new MyFileChooser();
            dialog.add(fileChooser);
            dialog.setVisible(true);
        }
    }
}
