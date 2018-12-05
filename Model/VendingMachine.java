package Model;

import Model.Product;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class VendingMachine implements Serializable {
    private static final long serialVersionUID = 3L;
    private String name;
    private HashMap<Product,Integer> products=new HashMap<>();
    private Color background;
    private Color border;
    private int rows;
    private int cols;
    private int cellCapacity;
    private double balance;

    public VendingMachine(String name,Color background, Color border, int rows, int cols, int cellCapacity) {
        this.setName(name);
        this.setBackground(background);
        this.setBorder(border);
        this.setRows(rows);
        this.setCols(cols);
        this.setCellCapacity(cellCapacity);
        this.setBalance(0.0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Product> getProducts() {
        return new ArrayList<>(products.keySet());
    }

    public void addProduct(Product product,int value) {
        this.products.put(product,value);
    }

    public Color getBackground() {
        return background;
    }

    public void setBackground(Color background) {
        this.background = background;
    }

    public Color getBorder() {
        return border;
    }

    public void setBorder(Color border) {
        this.border = border;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public int getCellCapacity() {
        return cellCapacity;
    }

    public void setCellCapacity(int cellCapacity) {
        this.cellCapacity = cellCapacity;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
