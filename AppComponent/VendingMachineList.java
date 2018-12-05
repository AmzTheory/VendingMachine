package AppComponent;

import Frames.DisplayVendingMachine;
import Model.Business;
import RenderedItems.VendingMachine;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class VendingMachineList extends JScrollPane {
    public VendingMachineList(Business b){
        super(setUpList(b));
    }
    private static JList<Model.VendingMachine> setUpList(Business b){
        JList<Model.VendingMachine> machineJList=new JList<>();
        DefaultListModel<Model.VendingMachine> model=new DefaultListModel<>();
        for (Model.VendingMachine m:b.getMachines()) {
            model.addElement(m);
        }

        machineJList.setModel(model);
        machineJList.setCellRenderer(new VendingMachine());
        machineJList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JList<Model.VendingMachine> list=(JList<Model.VendingMachine>)e.getSource();
                if(list!=null){
                    int index=list.locationToIndex(e.getPoint());
                    Model.VendingMachine bt=(Model.VendingMachine)list.getModel().getElementAt(index);
                    new DisplayVendingMachine(bt,b).init();
                }
            }
        });


        return machineJList;
    }

}
