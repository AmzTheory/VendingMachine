package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Business implements Serializable {
    private static final long serialVersionUID = 1L;
    ArrayList<VendingMachine> machines;
    ArrayList<Product> products;

    public Business(){
        machines=new ArrayList<>();
        products=new ArrayList<>();
    }

    public void addMachine(VendingMachine machine){
        this.machines.add(machine);
        System.out.println("Machine added to bus");
    }
    public void addProduct(Product product){
        this.products.add(product);
    }

    public ArrayList<VendingMachine> getMachines() {
        return machines;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
    public void updateState(){
        Feature.writeObjectFile("\\src\\fileData",this);
    }
}
