package Frames;

import AppComponent.ProductForm;
import Model.Business;
import Model.Feature;
import MyComponets.MyLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProduct extends AbstractFrame {
    private Business business;
    public AddProduct(Business business){
       // business.updateState();
        this.setBusiness(business);

    }
    public void init(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(380,280));
        this.setTitle("Add Product");
        this.setLayout(new BorderLayout());


        //TOP
        MyLabel lbTitle=new MyLabel("Add Product",Font.BOLD,25);
        lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lbTitle.setForeground(Color.DARK_GRAY);
        this.add(lbTitle,BorderLayout.NORTH);


        //Center(FORM)
        ProductForm pForm=new ProductForm();
        this.add(pForm,BorderLayout.CENTER);



        //ADD or Back
        JButton btBack=new JButton("Back");
        JButton btAdd=new JButton("Add");

        //Events

        btAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String res=pForm.validateInput();
                if(res==null){
                    business.addProduct(pForm.getAddedItem());
                    JOptionPane.showMessageDialog(null,"The Product had been added");
                    returnStarting(business);
                }else{
                    JOptionPane.showMessageDialog(null,res);
                }
            }
        });
        btBack.addActionListener(e->returnStarting(business));

        JPanel bottomPanel=new JPanel();
        bottomPanel.setLayout(new GridLayout(1,2));
        bottomPanel.add(btBack);
        bottomPanel.add(btAdd);

        this.add(bottomPanel,BorderLayout.SOUTH);

        this.setVisible(true);

    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

}
