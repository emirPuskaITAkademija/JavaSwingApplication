package one;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <li>1. Container</li>
 * <li>2. UI controls </li>
 * <li>3. LayoutManager</li>
 *
 *
 */
public class SwingObserverExample {
    private JFrame frame;


    public void go(){
        frame = new JFrame("Prozor");
        //DUgmic predstavlja jednu UI controls
        JButton button = new JButton("Should I do it ? ");
        //OBSERVER
        AngelListener angelListener = new AngelListener();
        DevilListener devilListener = new DevilListener();
        button.addActionListener(angelListener);
        button.addActionListener(devilListener);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.getContentPane().add(button, BorderLayout.NORTH);
        frame.setSize(400, 400);
        frame.setBackground(Color.YELLOW);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    class AngelListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Nemoj, zažalićeš...");
        }
    }

    class DevilListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Uradi, nećeš zažalit ba..pusti priču...");
        }
    }
}
