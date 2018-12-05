package TableModel;

import Model.Product;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ProductModel extends AbstractTableModel {
    private String[] columnNames={"ID","Product Name","Quantity","Displayed","Price"};
    private List<Product> products;
    private final Class[] columnClass = new Class[] {
            Integer.class, String.class,Integer.class,Integer.class,Double.class
    };

    public ProductModel(List<Product> products){
            this.products=products;
    }
    @Override
    public int getRowCount() {
        return products.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return super.getColumnClass(columnIndex);
    }

    public Product getSelectedRow(int row){
        return this.products.get(row);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex==0)
            return products.get(rowIndex).getProductID();
        else if(columnIndex==1)
            return products.get(rowIndex).getName();
        else if(columnIndex==2)
            return products.get(rowIndex).getQuantity();
        else if(columnIndex==3)
            return products.get(rowIndex).getDisplayed();
        else if(columnIndex==4)
            return products.get(rowIndex).getPrice();

        return null;
    }
}
