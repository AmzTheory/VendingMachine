package AppComponent;

import javax.swing.*;
import java.awt.*;

public class InsertPanel extends JPanel {
    public InsertPanel(){
        this.setOpaque(false);
        this.setPreferredSize(new Dimension(250,70));
        this.setLayout(new BorderLayout());
        JLabel lbInsert=new JLabel("Insert Cash");
        lbInsert.setFont(new Font("Ariel",Font.BOLD,22));
        lbInsert.setHorizontalAlignment(SwingConstants.CENTER);
        lbInsert.setForeground(Color.darkGray);
        JTextField tbAmount=new JTextField(10);
        tbAmount.setPreferredSize(new Dimension(100,50));
        JButton btInsert=new JButton("Insert");
        btInsert.setPreferredSize(new Dimension(100,50));

        this.add(lbInsert, BorderLayout.NORTH);
        this.add(tbAmount,BorderLayout.CENTER);
        this.add(btInsert,BorderLayout.EAST);



    }
}
