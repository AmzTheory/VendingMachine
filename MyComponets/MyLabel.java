package MyComponets;

import javax.swing.*;
import java.awt.*;

public class MyLabel extends JLabel {
    public MyLabel(String text,int textStyle,int size){
        super();
        this.setText(text);
        this.setFont(new Font("Ariel",textStyle,size));
    }
    public MyLabel(){
        super();
    }
    public MyLabel(String text){
        super();
        this.setText(text);
        this.setFont(new Font("Ariel",Font.PLAIN,14));
    }
    public MyLabel(String text,int align){
        this(text);
        this.setHorizontalAlignment(align);
    }
}
