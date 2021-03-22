package two;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.stream.Stream;

public class RadioButtonPanel extends JPanel  {

    //panel -> panel.pictureLabel
    private JLabel pictureLabel;

    public RadioButtonPanel(){
        super(new BorderLayout());
        //pigRadioButton, birdRadioButton, catRadioButton, dogRadioButton, rabbitRadioButton
        JPanel radioButtonPanel = new JPanel(new GridLayout(0,1));
        ButtonGroup buttonGroup = new ButtonGroup();
        Stream.of(Animal.values())
                .forEach(animal -> createRadioButton(animal, buttonGroup, radioButtonPanel));

        pictureLabel = new JLabel();
        Animal animal = Animal.findDefaulSelectedAnimal();
        ImageIcon imageIcon = animal.loadImage();
        pictureLabel.setIcon(imageIcon);
        Dimension dimension = new Dimension(200, 130);
        pictureLabel.setPreferredSize(dimension);


        add(radioButtonPanel, BorderLayout.LINE_START);
        add(pictureLabel, BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }


    private JRadioButton createRadioButton(Animal animal, ButtonGroup buttonGroup, JPanel panel){
        JRadioButton radioButton = new JRadioButton(animal.getPictureName());
        radioButton.setMnemonic(animal.getMnemonic());
        //actionCommand -> String .... Bird.gif, Cat.gif, Rabbit.gif
        radioButton.setActionCommand(animal.getPictureName());
        radioButton.setSelected(animal.isDefaultSelected());
        radioButton.addActionListener(this::actionPerformed);
        buttonGroup.add(radioButton);
        panel.add(radioButton);
        return radioButton;
    }

    // RADIO BUTTON -> setActionCommand  ----->  actionEvent.getActionCommand()
    public void actionPerformed(ActionEvent actionEvent) {
        String pictureName = actionEvent.getActionCommand();
        ImageLoader imageLoader = new ImageLoader(pictureName);
        ImageIcon imageIcon = imageLoader.load();
        pictureLabel.setIcon(imageIcon);
    }
}
