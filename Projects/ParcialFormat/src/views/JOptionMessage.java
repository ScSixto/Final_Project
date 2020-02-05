package views;

import javax.swing.*;
import java.awt.*;

public class JOptionMessage{

    public static void showErrorMessage(ErrorMessage error, String message){
        JOptionPane.showMessageDialog(null, "<html>" + error.getMessage() + ":<br>" + message + "</html>", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void showErrorMessage(ErrorMessage error){
        JOptionPane.showMessageDialog(null, error.getMessage()+".", "Error", JOptionPane.ERROR_MESSAGE);
    }
}