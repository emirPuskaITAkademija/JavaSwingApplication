package two;

import javax.swing.*;
import java.awt.*;

public class CheckBoxExecutor {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(CheckBoxExecutor::createGUI);
    }

    static void createGUI(){
        System.out.println(Thread.currentThread().getName());
        JFrame frame = new JFrame("Check box usage demo");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        CheckBoxPanel panel = new CheckBoxPanel();
        frame.setContentPane(panel);
        frame.pack();
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
