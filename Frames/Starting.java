package Frames;

import Model.Business;
import Model.Feature;
import Model.VendingMachine;
import AppComponent.VendingMachineList;

import javax.swing.*;
import java.awt.*;

public class Starting extends AbstractFrame {
    private Business business;
    public Starting(){
        Business readObject=Feature.readObjectFile("\\src\\fileData");

        if(readObject!=null)
            this.business=readObject;
        else
            this.business=new Business();
    }
    public Starting(Business B){
        B.updateState();
        this.business=B;
    }
    public void init(){
        this.setUpGui();
    }


    private void initatDumbeBus(){
        business.addMachine(new VendingMachine("MBZ site",null,null,9,5,8));
        business.addMachine(new VendingMachine("KU site",null,null,9,5,8));
    }


    private void setUpGui(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(550,600));
        this.setLayout(new BorderLayout());
        VendingMachineList list=new VendingMachineList(business);
        this.add(list,BorderLayout.CENTER);

        JPanel settingPanel=new JPanel();
        settingPanel.setLayout(new FlowLayout(SwingConstants.HORIZONTAL));
        settingPanel.setPreferredSize(new Dimension(550,50));

        JButton btAddMachine=new JButton("+ machine");
        btAddMachine.setPreferredSize(new Dimension(100,45));
        JButton btAddProduct=new JButton("+ Product");
        btAddProduct.setPreferredSize(new Dimension(100,45));
        JButton btSettingProducts=new JButton("Products Settings");
        btSettingProducts.setPreferredSize(new Dimension(140,45));
        JFrame wind=this;
        //action listener
        btAddMachine.addActionListener(e->changeTo(new AddMachine(business)));
        btAddProduct.addActionListener(e->changeTo(new AddProduct(business)));
        btSettingProducts.addActionListener(e->changeTo(new ProductSettings(business)));

        settingPanel.add(btAddMachine);
        settingPanel.add(btAddProduct);
        settingPanel.add(btSettingProducts);
        this.add(settingPanel,BorderLayout.SOUTH);

        //this.add(list,main.getGridBagConstraint(new int[]{30,100,30,100},0,0,0,0));
        this.setVisible(true);
    }

}
