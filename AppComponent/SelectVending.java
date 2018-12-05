package AppComponent;

import Model.VendingMachine;
import MyComponets.MyLabel;

import javax.swing.*;
import java.awt.*;


public class SelectVending extends JPanel{
    private VendingMachine machine;
    public SelectVending(VendingMachine machine){
        this.setMachine(machine);
        //this.setLayout(new GridBagLayout());
        this.setLayout(new BorderLayout());

        MyLabel lbVendingMachine=new MyLabel(machine.getName(),Font.BOLD,14);
        lbVendingMachine.setForeground(machine.getBackground());
        lbVendingMachine.setHorizontalAlignment(SwingConstants.CENTER);
        JButton btSelect=new JButton("Select");
        MyLabel gap=new MyLabel();
        gap.setPreferredSize(new Dimension(400,20));
        this.add(lbVendingMachine,BorderLayout.NORTH);
        //this.add(gap, BorderLayout.CENTER);
        this.add(btSelect,BorderLayout.SOUTH);


//        this.add(lb,main.getGridBagConstraint(new int[]{20,20,0,0},0,0,2,0));
//        this.add(button,main.getGridBagConstraint(new int[]{5,20,20,0},0,1,2,0));
    }

    public VendingMachine getMachine() {
        return machine;
    }

    public void setMachine(VendingMachine machine) {
        this.machine = machine;
    }

}
