package Frames;

import Model.Business;
import Model.VendingMachine;
import AppComponent.*;
import javax.swing.*;
import java.awt.*;

public class DisplayVendingMachine extends AbstractFrame {
    private Business business;
    private VendingMachine machine;
    private Console machineConsole;
    private KeyPad keyPad;
    private InsertPanel insertPanel;
    public DisplayVendingMachine(VendingMachine machine,Business business){
        this.machine=machine;
        this.business=business;
    }
    public void init(){
        this.setTitle(machine.getName());
        //this.setResizable(false);
        //GridLayout gridLayout=new GridLayout(1,1);

        //this.setLayout(new GridBagLayout());
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));
        this.setSize(new Dimension(750,1000));

        JPanel displayM=new JPanel();
        displayM.setPreferredSize(new Dimension(500,1000));
        displayM.setBackground(Color.BLUE);
       this.add(displayM);


        JPanel inputPanel=new JPanel();
        inputPanel.setBackground(new Color(120, 84, 47));
        inputPanel.setLayout(new FlowLayout());
        inputPanel.setPreferredSize(new Dimension(250,1000));
        machineConsole=new Console();
        keyPad=new KeyPad();
        insertPanel=new InsertPanel();
        JButton btSetting=new JButton("Settings");
        btSetting.setAlignmentX(SwingConstants.LEFT);
        inputPanel.add(machineConsole);
        inputPanel.add(keyPad);
        inputPanel.add(insertPanel);
        inputPanel.add(btSetting);

        this.add(inputPanel);

        this.setVisible(true);
    }
}
