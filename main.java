import Frames.Starting;
import Model.Business;
import Model.Feature;

import java.awt.*;

public class main {
    public static void main(String args[]){
        Starting SF=new Starting();
        SF.init();
    }
    public static GridBagConstraints getGridBagConstraint(int[] insets,int x,int y,int spanX,int spanY){
        GridBagConstraints con=new GridBagConstraints();
        if(insets!=null && insets.length==4)
            con.insets=new Insets(insets[0],insets[1],insets[2],insets[3]);
        con.anchor=GridBagConstraints.FIRST_LINE_START;
        con.weighty=1;
        con.weightx=1;
        con.fill=GridBagConstraints.BOTH;
        con.gridx=x;
        con.gridy=y;


        if(spanX>0)
            con.gridwidth=spanX;
        if(spanY>0)
            con.gridheight=spanY;

        return con;
    }
}