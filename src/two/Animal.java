package two;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.stream.Stream;

public enum Animal {

    BIRD("Bird.gif", KeyEvent.VK_B, true),
    CAT("Cat.gif", KeyEvent.VK_C, false),
    DOG("Dog.gif", KeyEvent.VK_D, false),
    RABBIT("Rabbit.gif", KeyEvent.VK_R, false),
    PIG("Pig.gif", KeyEvent.VK_P, false);

    private String pictureName;
    private int mnemonic;
    private boolean defaultSelected;

    private Animal(String pictureName, int mnemonic, boolean defaultSelected) {
        this.pictureName = pictureName;
        this.mnemonic = mnemonic;
        this.defaultSelected = defaultSelected;
    }

    public boolean isDefaultSelected() {
        return defaultSelected;
    }

    public String getPictureName() {
        return pictureName;
    }

    public String getName(){
        //.gif -> broj karaktera je 4
        return pictureName.substring(0, pictureName.length()-4);
    }

    public int getMnemonic() {
        return mnemonic;
    }

    public ImageIcon loadImage() {
        return new ImageLoader(pictureName).load();
    }

    public static Animal findDefaulSelectedAnimal(){

        return Stream.of(Animal.values())
                .filter(Animal::isDefaultSelected)
                .findFirst()
                .orElse(Animal.BIRD);
    }
}
