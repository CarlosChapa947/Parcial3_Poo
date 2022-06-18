import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

public class MyPanel extends JPanel {
    public MyLabel myLabel;

    MyPanel(){
        super();
    }

    MyPanel(LayoutManager layoutManager){
        super();
    }

    public void setMyLabel(MyLabel myLabel) {
        this.myLabel = myLabel;
    }

    public MyLabel getMyLabel() {
        return myLabel;
    }

    public void applyNegativeFilter(){
        SwingWorker<BufferedImage, Object> worker;
        worker = new SwingWorker<BufferedImage, Object>() {
            @Override
            protected BufferedImage doInBackground() throws Exception {
                BufferedImage buff = myLabel.getCopyImg();
                int pixel, alpha, red, green, blue;
                for (int i = 0; i < buff.getHeight(); i++) {
                    for (int j = 0; j < buff.getWidth(); j++) {
                        pixel = buff.getRGB(j, i);
                        alpha = (pixel >> 24) & 0xFF;
                        red = (pixel >> 16) & 0xFF;
                        green = (pixel >> 8) & 0xFF;
                        blue = pixel & 0xFF;

                        red = 255 - red;
                        green = 255 - green;
                        blue = 255 - blue;
                        pixel = (alpha << 24) | (red << 16) | (green << 8) | blue;
                        buff.setRGB(j, i, pixel);
                    }
                }
                return buff;
            }

            @Override
            protected void done() {
                BufferedImage buff = null;
                try {
                    buff = get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                myLabel.setIcon(new ImageIcon(buff));
                myLabel.repaint();
            }
        };
        worker.execute();
    }

    public void resetImg(){
        BufferedImage buff = myLabel.getCopyImg();
        myLabel.setIcon(new ImageIcon(buff));
        myLabel.repaint();
    }

    public void applySharpenFilter(){
        SwingWorker<BufferedImage, Object> worker;
        worker = new SwingWorker<BufferedImage, Object>() {
            @Override
            protected BufferedImage doInBackground() throws Exception {
                BufferedImage buff = myLabel.getCopyImg();
                Kernel kernel = new Kernel(3, 3, new float[]
                        {-0, -1, -0,
                                -1, 5, -1,
                                -0, -1, -0});
                BufferedImageOp buffOP = new ConvolveOp(kernel);
                buff = buffOP.filter(buff, null);
                return buff;
            }

            @Override
            protected void done(){
                BufferedImage buff = null;
                try {
                    buff = get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
                myLabel.setIcon(new ImageIcon(buff));
                myLabel.repaint();
            }
        };
        worker.execute();
    }

    public void applyBlurFilter(){
        SwingWorker<BufferedImage, Object> worker;
        worker = new SwingWorker<BufferedImage, Object>() {
            @Override
            protected BufferedImage doInBackground() throws Exception {
                BufferedImage buff = myLabel.getCopyImg();
                float matriz[] = new float[400];
                Arrays.fill(matriz, 1.0f / 400.0f);
                Kernel kernel = new Kernel(20, 20, matriz);
                BufferedImageOp buffOP = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
                buff = buffOP.filter(buff, null);
                return buff;
            }

            @Override
            protected void done(){
                BufferedImage buff = null;
                try {
                    buff = get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                myLabel.setIcon(new ImageIcon(buff));
                myLabel.repaint();
            }
        };
        worker.execute();
    }

    @Override
    public void removeAll() {
        super.removeAll();
    }

    @Override
    public void setVisible(boolean aFlag) {
        super.setVisible(aFlag);
    }

    @Override
    public Component add(Component comp) {
        return super.add(comp);
    }

    @Override
    public void repaint() {
        super.repaint();
    }
}
