package RenderedItems;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import AppComponent.SelectVending;

public class VendingMachine extends JPanel implements ListCellRenderer<Model.VendingMachine> {
    @Override
    public Component getListCellRendererComponent(JList<? extends Model.VendingMachine> list, Model.VendingMachine value, int index, boolean isSelected, boolean cellHasFocus) {
        this.removeAll();
        this.setSize(new Dimension(300,70));
        this.setLayout(new BorderLayout());
        SelectVending item=new SelectVending(value);

       this.add(item,BorderLayout.CENTER);


        return this;
    }

}
