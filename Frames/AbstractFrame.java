package Frames;

import Model.Business;
import Model.Feature;

import javax.swing.*;

public abstract class AbstractFrame extends JFrame{
    private void destroy(){
        Feature.destroyFrame(this);
    }
    public void changeTo(AbstractFrame newFrame){
        newFrame.init();
        this.destroy();
    }
    public void returnStarting(Business b){
        new Starting(b).init();
        destroy();
    }

    public void showMessage(String msg){
        JOptionPane.showMessageDialog(this,msg);
    }
    public abstract void init();

}
