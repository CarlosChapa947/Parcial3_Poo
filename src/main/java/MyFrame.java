import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MyFrame extends JFrame {

    public MyFrame(){
        MyPanel myPanel = new MyPanel(new FlowLayout());
        MenuBar menuBar = new MenuBar(this);

        menuBar.getCargar().addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.addChoosableFileFilter(new ImageFilter());
            fileChooser.setAcceptAllFileFilterUsed(false);
            int option = fileChooser.showOpenDialog(this);
            if(option == JFileChooser.APPROVE_OPTION){
                File file = fileChooser.getSelectedFile();
                try {
                    BufferedImage bufferedImage = ImageIO.read(file);
                    ImageIcon imageIcon =  new ImageIcon(bufferedImage);
                    MyLabel label = new MyLabel(imageIcon);
                    label.setImageIcon(imageIcon);
                    label.setBufferedImage(bufferedImage);
                    myPanel.setMyLabel(label);
                    myPanel.removeAll();
                    myPanel.add(label);
                    this.pack();
                    myPanel.setVisible(true);
                    label.setVisible(true);
                    myPanel.repaint();
                    this.repaint();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }else{
            }
        });

        menuBar.getRemove().addActionListener(e -> {
            myPanel.removeAll();
            myPanel.repaint();
        });

        menuBar.getNegativo().addActionListener(e -> {
            if(myPanel.myLabel == null){
                return;
            }
            myPanel.applyNegativeFilter();
        });

        menuBar.getBlur().addActionListener(e -> {
            if(myPanel.myLabel == null){
                return;
            }
            myPanel.applyBlurFilter();
        });

        menuBar.getSharpen().addActionListener(e -> {
            if(myPanel.myLabel == null){
                return;
            }
            myPanel.applySharpenFilter();
        });

        menuBar.getReset().addActionListener(e -> {
            if(myPanel.myLabel == null){
                return;
            }
            myPanel.resetImg();
        });

        this.setJMenuBar(menuBar);
        this.add(myPanel);
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setVisible(true);
    }
}
