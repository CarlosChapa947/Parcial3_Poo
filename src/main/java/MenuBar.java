import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionListener;

public class MenuBar extends JMenuBar {
    JMenu archivo, efectos;
    JMenuItem cargar, remove;
    JMenuItem negativo, blur, sharpen, reset;

    public MenuBar(JFrame frame){
        this.archivo = new JMenu("Archivo");
        this.efectos = new JMenu("Efectos");
        this.cargar = new JMenuItem("Cargar");
        this.remove = new JMenuItem("Remove");
        this.reset = new JMenuItem("Reset");
        this.negativo = new JMenuItem("Negativo");
        this.blur = new JMenuItem("Blur");
        this.sharpen = new JMenuItem("Sharpen");
        this.add(archivo);
        this.add(efectos);
        this.archivo.add(cargar);
        this.archivo.add(remove);
        this.efectos.add(reset);
        this.efectos.add(negativo);
        this.efectos.add(blur);
        this.efectos.add(sharpen);
    }

    public JMenuItem getCargar() {
        return cargar;
    }

    public JMenuItem getNegativo(){
        return negativo;
    }

    public JMenuItem getBlur() {
        return blur;
    }

    public JMenuItem getSharpen(){
        return sharpen;
    }

    public JMenuItem getReset() {
        return reset;
    }

    public JMenuItem getRemove() {
        return remove;
    }
}
