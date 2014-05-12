package ru.kunik.uct.util;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Dialogs {
    
    public static void showErrorDialog(JFrame base, String info) {
        JOptionPane.showMessageDialog(base, info, Rus.get("Error"), JOptionPane.ERROR_MESSAGE);
    }
    
    public static int showQuestionDialog(JFrame base, String info, String title) {
        return JOptionPane.showConfirmDialog(base, info, title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    }
}
