package Frames;

import AppComponent.ProductForm;
import Model.Business;
import Model.Product;
import MyComponets.MyLabel;
import TableModel.ProductModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import java.awt.*;

/**
 * add products into machine
 * view the available products and where are they located
 * remove and edit products
 * remove Machines
 */
public class ProductSettings extends AbstractFrame {
    private Business business;
    private Product SelectedProduct;
    private ProductForm editForm;
    private JTable productsTable;

    public Product getSelectedProduct() {
        return SelectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        SelectedProduct = selectedProduct;
    }

    public ProductSettings(Business business){
        super();
        this.setBusiness(business);

    }
    public void init(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setSize(700,750);
        //TOP
        JPanel topPanel=new JPanel(new BorderLayout());
        MyLabel label=new MyLabel("Products Settings",Font.BOLD,25);
        JButton btBack=new JButton("Back");
        topPanel.add(label,BorderLayout.CENTER);
        topPanel.add(btBack,BorderLayout.EAST);

        btBack.addActionListener(e->returnStarting(business));
        //Center
        JPanel centerPanel=new JPanel();
        productsTable=new JTable(new ProductModel(business.getProducts()));
        productsTable.setCellSelectionEnabled(false);
        productsTable.setRowSelectionAllowed(true);
        JScrollPane scrollPane=new JScrollPane(productsTable);
        scrollPane.setPreferredSize(new Dimension(700,400));

        JPanel factsPanel=new JPanel(new BorderLayout());
        JPanel editProductSide=new JPanel(new BorderLayout());
//        editProductSide.setLayout(new BoxLayout(editProductSide,BoxLayout.Y_AXIS));
        editForm=new ProductForm();
        JButton btUpdate=new JButton("Update");
       // btUpdate.setPreferredSize(new Dimension(150,20));
        editProductSide.add(editForm,BorderLayout.CENTER);
        editProductSide.add(btUpdate,BorderLayout.SOUTH);
        btUpdate.addActionListener(e->updateProduct());
        factsPanel.add(editProductSide,BorderLayout.WEST);
        productsTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                ProductModel model=(ProductModel)productsTable.getModel();
                Product product=model.getSelectedRow(productsTable.getSelectedRow());
                setSelectedProduct(product);
                editForm.setProductDetails(getSelectedProduct());
               /// updateDisplay();
            }
        });
        centerPanel.add(scrollPane,BorderLayout.CENTER);
        //bottom
        this.add(topPanel, BorderLayout.NORTH);
        this.add(centerPanel,BorderLayout.CENTER);
        this.add(factsPanel,BorderLayout.SOUTH);

        this.setVisible(true);

    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }
    public void updateDisplay(){
        this.revalidate();
    }
    public void updateProduct(){
        if(this.getSelectedProduct()!=null) {
            String msg = this.editForm.validateInput();
            if (editForm == null) {
                this.setSelectedProduct((Product) editForm.getAddedItem().clone());
                this.showMessage("The Product has been updated");
                ((AbstractTableModel) this.productsTable.getModel()).fireTableDataChanged();//update the table
            } else {
                this.showMessage(msg);
            }
        }else{
            showMessage("make sure you've selected product from the table above");
        }
    }


}
