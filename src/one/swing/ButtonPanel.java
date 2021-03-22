package one.swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;

//KONTEJNERSKIH komponenti
public class ButtonPanel extends JPanel {
    //UI controls
    private JButton leftButton;
    private JButton middleButton;
    private JButton rightButton;

    public ButtonPanel(){
        //ActionListener
        VictimCodeActionListener actionListener = new VictimCodeActionListener();

        ImageIcon leftImageIcon = createImageIcon("right.gif");
        this.leftButton = new JButton("Disable middle button", leftImageIcon);
        this.leftButton.setHorizontalTextPosition(SwingConstants.LEFT);
        this.leftButton.setActionCommand("disable");
        this.leftButton.setMnemonic(KeyEvent.VK_L);
        this.leftButton.addActionListener(actionListener);

        ImageIcon middleImageIcon = createImageIcon("middle.gif");
        this.middleButton = new JButton("Middle button", middleImageIcon);
        this.middleButton.setHorizontalTextPosition(SwingConstants.CENTER);
        this.middleButton.setVerticalTextPosition(SwingConstants.BOTTOM);

        ImageIcon rightImageIcon = createImageIcon("left.gif");
        this.rightButton = new JButton("Enable middle button", rightImageIcon);
        this.rightButton.setActionCommand("enable");
        this.rightButton.setMnemonic(KeyEvent.VK_R);
        this.rightButton.addActionListener(actionListener);
        this.rightButton.setHorizontalTextPosition(SwingConstants.RIGHT);

        add(leftButton);
        add(middleButton);
        add(rightButton);
    }

    private ImageIcon createImageIcon(String pictureName){
        URL imgUrl = ButtonPanel.class.getResource(pictureName);
        if(imgUrl != null){
            return new ImageIcon(imgUrl);
        }else{
            System.err.println("Could not find file");
            return null;
        }
    }

    class VictimCodeActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if("disable".equals(e.getActionCommand())){
                middleButton.setEnabled(false);
            }else{
                middleButton.setEnabled(true);
            }
        }
    }
}
