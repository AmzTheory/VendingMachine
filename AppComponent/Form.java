package AppComponent;

import javax.swing.*;
import java.awt.GridLayout;

import Model.VendingMachine;
import MyComponets.ColourPicker;
import MyComponets.Counter;
import MyComponets.MyLabel;

public class Form extends JPanel {
    private JTextField tbSiteName;
    private ColourPicker cpBackground;
    private ColourPicker cpBorder;
    private Counter coRows;
    private Counter coCols;
    private Counter coCapacity;
    public Form() {
        super();
        this.init();
    }
    
    public void init(){
        GridLayout layout=new GridLayout(6,2);
        layout.setHgap(15);
        layout.setVgap(2);

        this.setLayout(layout);

        tbSiteName=new JTextField();
        cpBackground=new ColourPicker();
        cpBorder=new ColourPicker();
        coRows=new Counter();
        coCols=new Counter();
        coCapacity=new Counter();

        this.add(new MyLabel("Site Name",SwingConstants.CENTER));
        this.add(tbSiteName);

        this.add(new MyLabel("Background",SwingConstants.CENTER));
        this.add(cpBackground);

        this.add(new MyLabel("Border",SwingConstants.CENTER));
        this.add(cpBorder);

        this.add(new MyLabel("Rows",SwingConstants.CENTER));
        this.add(coRows);

        this.add(new MyLabel("Cols",SwingConstants.CENTER));
        this.add(coCols);

        this.add(new MyLabel("Cell Capacity",SwingConstants.CENTER));
        this.add(coCapacity);

    }
    public String validateInput(){
        String messages="";
        if(tbSiteName.getText().equals(""))
            messages+=("Type in the site name\n");
        if(cpBackground.getColor()==null)
            messages+=("choose the background colour\n");
        if(cpBorder.getColor()==null)
            messages+=("choose the background colour\n");
        if(coCapacity.getValue()==0)
            messages+=("choose the cell Capacity\n");
        if(coCols.getValue()==0)
            messages+=("choose the Cols\n");
        if(coRows.getValue()==0)
            messages+=("choose the Rows\n");


        //In case no errors (imply that the all the input is correct)
        if(messages.length()==0)
            return null;

        return messages;
    }
    public VendingMachine getAddedItem(){
        VendingMachine machine=new VendingMachine(tbSiteName.getText(),cpBackground.getColor()
                ,cpBorder.getColor(),coRows.getValue(),coCols.getValue(), coCapacity.getValue());
        return machine;
    }

}
