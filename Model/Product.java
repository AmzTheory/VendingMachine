package Model;

import java.io.Serializable;

public class Product implements Serializable,Cloneable {
    private static final long serialVersionUID = 2L;
    private int productID;
    private String name;
    private double price;
    private int quantity;
    private int displayed;
    private String photoPath;

    public Product(int productID, String name, double price, int quantity, String photoPath) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.photoPath = photoPath;
        this.displayed=0;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getDisplayed() {
        return displayed;
    }

    public void setDisplayed(int displayed) {
        this.displayed = displayed;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    @Override
    public int hashCode() {
        int code=0;
        for (char c:this.name.toCharArray()) {
            code+=c;
        }
        return code;
    }
    public Object clone(){
        Product product=new Product(this.getProductID(),this.getName(),this.getPrice(),this.getQuantity(),this.getPhotoPath());
        return product;
    }

}
