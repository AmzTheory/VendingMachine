package AppComponent;

import Model.Product;
import MyComponets.Counter;
import MyComponets.ImageDisplay;
import MyComponets.MyLabel;
import MyComponets.UploadImage;

import javax.swing.*;
import java.awt.*;

public class ProductForm  extends JPanel{
    private JTextField tbProductName;
    private UploadImage uploadImage;
    private Counter coQuantity;
    private Counter coPrice;
    public ProductForm() {
        super();
        this.init();
    }
    public void setProductDetails(Product product){
        tbProductName.setText(product.getName());
        coQuantity.setValue(product.getQuantity());
        coPrice.setValue((int)product.getPrice());
        uploadImage=new UploadImage(product.getPhotoPath());
        uploadImage.setPath(product.getPhotoPath());
        uploadImage.updateDisplay();
    }

    public void init(){
        this.setPreferredSize(new Dimension(380,220));
        GridLayout layout=new GridLayout(4,2);
        layout.setHgap(15);
        layout.setVgap(2);
        this.setOpaque(false);
        this.setLayout(layout);

        tbProductName=new JTextField();
        uploadImage=new UploadImage();
        coQuantity=new Counter();
        coPrice=new Counter();
        this.add(new MyLabel(" Product Name"));
        this.add(tbProductName);
        this.add(new MyLabel("Product Photo"));
        this.add(uploadImage);
        this.add(new MyLabel("Quantity"));
        this.add(coQuantity);
        this.add(new MyLabel("Price"));
        this.add(coPrice);



    }
    public String validateInput(){
        String messages="";
        if(tbProductName.getText().equals(""))
            messages+=("type in the Product name\n");
        if(!uploadImage.isChoosed())
            messages+=("choose Photo for the Product\n");
        if(coQuantity.getValue()==0)
            messages+=("choose the Quantity to Enter\n");
        if(coPrice.getValue()==0)
            messages+=("choose the price\n");


        //In case no errors (imply that the all the input is correct)
        if(messages.length()==0)
            return null;

        return messages;
    }
    public Product getAddedItem(){
        Product product=new Product(1,tbProductName.getText(),coPrice.getValue(),coQuantity.getValue(),uploadImage.getPath());
        return product;
    }
}
