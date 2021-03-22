package three;

import two.Animal;
import two.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ComboBoxPanel extends JPanel {
    private JLabel pictureLabel;

    public ComboBoxPanel() {
        super(new BorderLayout());
        String[] animalNames =  Stream.of(Animal.values())
                .map(Animal::getName)
                .collect(Collectors.toList())
                .toArray(String[]::new);
        JComboBox<String> petComboBox = new JComboBox<>(animalNames);
        petComboBox.setSelectedIndex(0);
        petComboBox.addActionListener(this::actionPerformed);

        pictureLabel = new JLabel();
        pictureLabel.setHorizontalAlignment(JLabel.CENTER);
        Animal animal = Animal.findDefaulSelectedAnimal();
        ImageLoader imageLoader = new ImageLoader(animal.getPictureName());
        ImageIcon imageIcon = imageLoader.load();
        pictureLabel.setIcon(imageIcon);
        pictureLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        add(petComboBox, BorderLayout.NORTH);
        add(pictureLabel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent actionEvent){
       JComboBox<String> sourceComboBox = (JComboBox<String>) actionEvent.getSource();
       String ime =(String) sourceComboBox.getSelectedItem();
       String pictureName = ime+".gif";
       ImageLoader imageLoader = new ImageLoader(pictureName);
       ImageIcon imageIcon = imageLoader.load();
       pictureLabel.setIcon(imageIcon);
    }
}
