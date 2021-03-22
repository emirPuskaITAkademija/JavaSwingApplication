package one.swing;

import javax.swing.*;
import java.awt.*;

/**
 *
 * <li>1. Container(JFrame, JPanel, ..)</li>
 * <li>2. UI controls(JButton, JCheckBox, JRadioButton...)</li>
 * <li>3. LayoutManager(BorderLayout, GridLayout, Grid)</li>
 *
 *
 */
public class ButtonDemo {

    public static void main(String[] args) {
        //Kontejnerske komponente
        ButtonPanel buttonPanel = new ButtonPanel();
        buttonPanel.setLayout(new FlowLayout());
        JFrame frame = new JFrame("Tesni dugmići");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(buttonPanel);

        frame.getContentPane().setBackground(Color.WHITE);
        //frame.pack();
        frame.pack();
        frame.setVisible(true);
    }
}
