package two;

import javax.swing.*;

public class SpringLayoutDemo {
    public static void main(String[] args) {
        JFrame f = new JFrame("Spring layout demo");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JButton btn1 = new JButton("Hello");
        SpringLayout springLayout = new SpringLayout();
        f.setLayout(springLayout);
        springLayout.putConstraint(SpringLayout.WEST, btn1, 50,SpringLayout.WEST, f.getContentPane());
        springLayout.putConstraint(SpringLayout.NORTH, btn1, 150, SpringLayout.NORTH, f.getContentPane());
        f.add(btn1);
        f.pack();
        f.setVisible(true);
    }
}
