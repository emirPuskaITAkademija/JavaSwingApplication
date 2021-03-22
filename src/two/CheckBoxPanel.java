package two;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.security.Key;

/**
 * Kontejnersku komponentu.
 */
public class CheckBoxPanel extends JPanel implements ItemListener{
    private JCheckBox chinCheckBox;
    private JCheckBox glassesCheckBox;
    private JCheckBox hairCheckBox;
    private JCheckBox teethCheckBox;
    private StringBuffer choices;
    private JLabel pictureLabel;


    public CheckBoxPanel(){
        super(new BorderLayout());
        //check boxes
        chinCheckBox = createCheckBox("Chin", KeyEvent.VK_C,true);
        glassesCheckBox = createCheckBox("Glasses", KeyEvent.VK_G,true);
        hairCheckBox = createCheckBox("Hair", KeyEvent.VK_H,true);
        teethCheckBox = createCheckBox("Teeth", KeyEvent.VK_T,true);
        //odabrani parametri čikca
        choices = new StringBuffer("cght");
        //slika
        pictureLabel = new JLabel();
        setupPicture();
        //panel
        JPanel checkPanel = new JPanel(new GridLayout(0, 1));
        checkPanel.add(chinCheckBox);
        checkPanel.add(glassesCheckBox);
        checkPanel.add(hairCheckBox);
        checkPanel.add(teethCheckBox);
        //CheckBoxDemo
        add(checkPanel, BorderLayout.LINE_START);
        add(pictureLabel, BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));





    }

    private void setupPicture(){
        //image
        String imageName = "geek-"+choices.toString()+".gif";
        ImageIcon imageIcon = new ImageLoader(imageName).load();
        if(imageIcon !=null){
            pictureLabel.setIcon(imageIcon);
            pictureLabel.setToolTipText(imageName);
        }else{
            pictureLabel.setText("Missing image: " + imageName);
        }
    }

    private JCheckBox createCheckBox(String tex, int keyEvent, boolean selected){
        JCheckBox checkBox = new JCheckBox(tex);
        checkBox.setMnemonic(keyEvent);
        checkBox.setSelected(selected);
        checkBox.addItemListener(this);
        return checkBox;
    }

    @Override
    public void itemStateChanged(ItemEvent event) {
        int index = 0;
        char character='-';
        Object source = event.getItemSelectable();
        if(chinCheckBox == source){
            index = 0;
            character = 'c';
        }else if(glassesCheckBox == source) {
            index = 1;
            character = 'g';
        }else if(hairCheckBox == source){
            index = 2;
            character = 'h';
        }else if(teethCheckBox == source){
            index = 3;
            character = 't';
        }
        if(event.getStateChange()==ItemEvent.DESELECTED){
            character = '-';
        }
        choices.setCharAt(index, character);
        setupPicture();
    }
}
