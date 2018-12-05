package Frames;

import Model.Business;
import Model.Feature;
import MyComponets.MyLabel;

import javax.swing.*;
import java.awt.*;
import AppComponent.Form;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddMachine extends AbstractFrame {
    private Business business;
    public AddMachine(Business business){
     //   business.updateState();
        this.business=business;

    }
    public void init(){
        this.setSize(new Dimension(350,350));
        this.setTitle("Add new machine");
        this.setLayout(new BorderLayout());

        //TOP
        MyLabel lbTitle=new MyLabel("Add Machine",Font.BOLD,25);
        lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lbTitle.setForeground(Color.DARK_GRAY);

        this.add(lbTitle,BorderLayout.NORTH);

        //Form
        Form form=new Form();
        this.add(form,BorderLayout.CENTER);


        //Bottom
        JButton btBack=new JButton("Back");
        JButton btAddMachine=new JButton("Add Machine");
        JPanel bottomPanel=new JPanel();
        bottomPanel.setLayout(new GridLayout(1,2));
        bottomPanel.add(btBack);
        bottomPanel.add(btAddMachine);


        this.add(bottomPanel,BorderLayout.SOUTH);

        btBack.addActionListener(e->returnStarting(business));
        btAddMachine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message=form.validateInput();
                if(message==null) {
                    getBusiness().addMachine(form.getAddedItem());
                    showMessage("Vending Machine has been added");
                    new Starting(getBusiness()).init();
                    destroy();

                }else {
                    showMessage(message);
                }
            }
        });
        this.setVisible(true);
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }
    private void destroy(){
        Feature.destroyFrame(this);
    }


}

