package two;

import javax.swing.*;

public class Executor {

    public static void main(String[] args) {
        Executor executor = new Executor();
        //Kreiranje UI startamo u odvojenom Thread
        SwingUtilities.invokeLater(executor::createGUI);
    }

    void createGUI(){
        System.out.println(Thread.currentThread().getName());
        JFrame frame = new JFrame("Radio box usage demo");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //pozivom sada linije 18 -> kreira se objekat
        RadioButtonPanel panel = new RadioButtonPanel();
        frame.setContentPane(panel);
        frame.pack();
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
