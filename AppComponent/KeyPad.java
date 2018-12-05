package AppComponent;

import javax.swing.*;
import java.awt.*;

public class KeyPad extends JPanel {
    public KeyPad(){
        this.setPreferredSize(new Dimension(250,250));
        this.setOpaque(false);
        GridLayout layout=new GridLayout(3,3);
        layout.setHgap(5);
        layout.setVgap(5);

        this.setLayout(layout);

        for(int i=0;i<9;){
            for(int j=0;j<3;j++){
              JButton bt=new JButton(Integer.toString(i+1));
              bt.setPreferredSize(new Dimension(30,30));
              bt.setFont(new Font("Ariel",Font.BOLD,15));

              this.add(bt);
              i++;
            }
        }


    }
}
