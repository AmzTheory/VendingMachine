package Model;
import Frames.AddMachine;

import javax.swing.JFrame;
import java.io.*;

public class Feature {
    public static void destroyFrame(JFrame frame){
        frame.dispose();
    }
    public static String formatRelativePath(String path){
        String basePath = new File("").getAbsolutePath();
        return basePath.concat(path);
    }
//    public static void changeWindow(JFrame frame,JFrame fr){
//        AddMachine frame=new AddMachine(business);
//        frame.init();
//        Feature.destroyFrame(wind);
//    }
    public static Business readObjectFile(String relativePath){
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(formatRelativePath(relativePath)));
            Business b=(Business)input.readObject();
            input.close();
            return b;
        }catch (IOException e){
            return null;
        }catch(ClassNotFoundException e){
            return null;
        }
    }
    public static Business writeObjectFile(String relativePath,Business b){
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(formatRelativePath(relativePath)));
            output.writeObject(b);
            output.close();
            return b;
        }catch (IOException e){
            return null;
        }
    }
}

