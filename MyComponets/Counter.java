package MyComponets;

import javax.swing.*;
import java.awt.*;

public class Counter extends JPanel {
    private int value;
    private JTextField tbfield;
    public Counter(){
        this.setLayout(new BorderLayout());
        tbfield=new JTextField();
        tbfield.setPreferredSize(new Dimension(50,20));
        tbfield.setEnabled(false);
        value=0;
        updateDisplay();
        JPanel change=new JPanel();
        change.setLayout(new GridLayout(2,1));
        JButton btIncr=new JButton("+");
        JButton btDecr=new JButton("-");
        change.add(btIncr);
        change.add(btDecr);

        //events
        btIncr.addActionListener(e->incr());
        btDecr.addActionListener(e->decr());

        //adding
        this.add(tbfield,BorderLayout.CENTER);
        this.add(change,BorderLayout.EAST);


    }

    public int getValue() {
        return value;
    }

    public void setValue(int count) {
        this.value = count;
        this.updateDisplay();
    }

    private void incr(){
        this.setValue(this.getValue()+1);
        updateDisplay();
    }
    private void decr(){
        if(value!=0) {
            this.setValue(this.getValue() - 1);
            updateDisplay();
        }
    }
    private void updateDisplay(){
        tbfield.setText(Integer.toString(this.getValue()));
    }
}
