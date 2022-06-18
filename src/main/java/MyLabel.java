/*Clase encargada de modelar un label que contiene la img*/
/*Se añade el campo de bufferedImage para tener un respaldo de la imagen principal */
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.image.*;

public class MyLabel extends JLabel {
    private BufferedImage bufferedImage;
    private ImageIcon imageIcon;

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

    /*Metodo para retornar una copia de la imagen original al momento de aplicar filtros
      Principalmente diseñado para asegurar la integridad de la imagen de modificaciones por referencia
     */
    public BufferedImage getCopyImg(){
        ColorModel cm = bufferedImage.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bufferedImage.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }
    //Settea la imagen original como icono para su despliegue
    public void resetImg(){
        imageIcon = new ImageIcon(bufferedImage);
        this.setIcon(imageIcon);
    }
}
