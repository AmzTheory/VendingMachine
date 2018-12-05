package MyComponets;
import Model.Feature;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class UploadImage extends JPanel{
    private boolean choosed;
    private ImageDisplay imageDisplay;
    private String path;
    public UploadImage() {
        this.setChoosed(false);
        this.setPath(Feature.formatRelativePath("\\src\\ProductsImage\\no_img.png"));
        this.setUpGui();
    }
    public UploadImage(String path){
        this.setPath(path);
        this.setChoosed(false);
        this.setUpGui();
    }
    public void setUpGui(){
        BoxLayout layout=new BoxLayout(this,BoxLayout.X_AXIS);

        this.setLayout(layout);
        this.setPreferredSize(new Dimension(90, 50));
        //components
        imageDisplay = new ImageDisplay(this.getPath());
        System.out.println(this.getPath());
        JButton btChooseImage = new JButton("choose");
        btChooseImage.setPreferredSize(new Dimension(90,20));
        updateDisplay();

        btChooseImage.addActionListener(e->showFileChooser());
        //adding components
        this.add(btChooseImage);
        this.add(imageDisplay);
    }
    public void setPath(String path){
        File file=new File(path);
       if(file.exists())
        this.path=path;

    }
    public String getPath(){
        return path;
    }

    public boolean isChoosed() {
        return choosed;
    }

    public void setChoosed(boolean choosed) {
        this.choosed = choosed;
    }
    public void updateDisplay(){
        if(this.imageDisplay!=null)
            this.imageDisplay.setPath(this.getPath());
    }
    private void showFileChooser() {
        try {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter ext = new FileNameExtensionFilter("Images", "jpg", "png", "gif");
            chooser.setFileFilter(ext);

            int res = chooser.showDialog(null, "Select");
            if (res == JFileChooser.APPROVE_OPTION) {
                File selectedFile = chooser.getSelectedFile();
                String programPath = Feature.formatRelativePath("\\src\\ProductsImage\\" + selectedFile.getName());
                Files.copy(Paths.get(selectedFile.getAbsolutePath()), Paths.get(programPath), StandardCopyOption.REPLACE_EXISTING);
                this.setPath(programPath);
                this.setChoosed(true);
                updateDisplay();
            }
        }catch (IOException ex){

        }

    }
}
