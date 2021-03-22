package one;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Prozor {

    public static void main(String[] args) {
        List<JButton> dugmici = new ArrayList<>();
        for(int i = 0; i<100; i++){
            JButton button = new JButton("Button "+ i);
            dugmici.add(button);
        }
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        for(JButton btn: dugmici){
            panel.add(btn);
        }

        JFrame frame = new JFrame("Flow layout");
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
