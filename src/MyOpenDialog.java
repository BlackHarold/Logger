import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class MyOpenDialog extends JFileChooser {

    private JDialog dialog;
    private int returnValue;
    String filePath;

    public MyOpenDialog() {
    }

    @Override
    public int showDialog(Component parent, String approveButtonText)
            throws HeadlessException {
        if (approveButtonText != null) {
            setApproveButtonText(approveButtonText);
            setDialogType(CUSTOM_DIALOG);
        }
        dialog = createDialog(parent);
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                returnValue = CANCEL_OPTION;
            }
        });

        returnValue = ERROR_OPTION;
        rescanCurrentDirectory();
        dialog.setVisible(true);
        firePropertyChange("JFileChooserDialogIsClosingProperty", dialog, null);
        return returnValue;
    }

    public void approveSelection() {
        returnValue = APPROVE_OPTION;
        if (dialog != null) {
            filePath = String.valueOf(this.getSelectedFile());
            System.out.println(filePath);
            fireActionPerformed(CANCEL_SELECTION);
            dialog.setVisible(false);


        }
    }

    @Override
    public void cancelSelection() {
        super.cancelSelection();
        System.out.println("Нажата клавиша \"Отмена\"");
        dialog.setVisible(false);
    }
}
