package AppComponent;

import javax.swing.*;
import java.awt.*;

public class Console extends JPanel {
    private JLabel lbOutput;
    public Console(){
        this.setPreferredSize(new Dimension(250,250));
        this.setBackground(new Color(20, 193, 119));
        lbOutput=new JLabel();
        lbOutput.setHorizontalAlignment(SwingConstants.CENTER);
        welcome();

        this.setLayout(new BorderLayout());
        this.add(lbOutput,BorderLayout.CENTER);
    }

    public void welcome(){

        lbOutput.setText("<html>Welcome<br> select product</html>");
    }
}
