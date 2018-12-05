package MyComponets;

import javax.swing.*;
import java.awt.*;

public class ImageDisplay extends JLabel {
    private int h;//height
    private int w;//weight
    private String path;
    public ImageDisplay(String path){

        this.setPath(path);
//        this.setAlignmentX(SwingConstants.CENTER);
//        this.setAlignmentY(SwingConstants.TOP);
    }
    public ImageDisplay(String path,int w,int h){
        this(path);
        this.setPreferredSize(new Dimension(w,h));
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
        ImageIcon icon=new ImageIcon(path);
        Image image=icon.getImage();
        ImageIcon imageIcon=new ImageIcon(image.getScaledInstance(100,100,Image.SCALE_DEFAULT));
        this.setIcon(imageIcon);
    }
}
