import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.image.*;

public class MyLabel extends JLabel {
    public BufferedImage bufferedImage;
    public ImageIcon imageIcon;

    MyLabel(){
        super();
    }

    MyLabel(ImageIcon imageIcon){
        super(imageIcon);
    }

    MyLabel(String str, ImageIcon imageIcon, int num){
        super(str, imageIcon, num);
    }

    MyLabel(String str){
        super(str);
    }

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public BufferedImage getCopyImg(){
        ColorModel cm = bufferedImage.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bufferedImage.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }

    public void resetImg(){
        imageIcon = new ImageIcon(bufferedImage);
        this.setIcon(imageIcon);
    }
}
