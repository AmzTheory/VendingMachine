package MyComponets;

import javax.swing.*;
import java.awt.*;

public class ColourPicker extends JPanel {
    private Color color;
    private JPanel colourPanel;
    public ColourPicker() {
        super();
        this.setColor(null);
        this.setLayout(new BorderLayout());
        JButton btChoose=new JButton("Choose");
        btChoose.setPreferredSize(new Dimension(25,30));
        colourPanel=new JPanel();
        colourPanel.setPreferredSize(new Dimension(50,30));

        this.add(btChoose,BorderLayout.CENTER);
        this.add(colourPanel, BorderLayout.EAST);

        updateColor();

        btChoose.addActionListener(e->showColorDialog());
    }
    public ColourPicker(Color color){
        this();
        this.setColor(color);
        this.updateColor();

    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    public void updateColor(){
        if(this.getColor()!=null)
            colourPanel.setBackground(this.getColor());
    }
    private void showColorDialog(){
        color= JColorChooser.showDialog(this,"choose Color",color);
        updateColor();
    }
}
