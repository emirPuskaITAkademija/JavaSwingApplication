package two;

import javax.swing.*;
import java.net.URL;

public class ImageLoader {

    private String path;

    public ImageLoader(String path){
        this.path = path;
    }


    public ImageIcon load(){
        URL imageUrl = RadioButtonPanel.class.getResource(path);
        if(imageUrl != null){
            return new ImageIcon(imageUrl);
        }else{
            System.err.println("Ne mogu nać sliku");
            return null;
        }
    }
}
