/*Clase encargada del modelado del menu, asi como sus respectivas opciones*/

import javax.swing.*;

public class MenuBar extends JMenuBar {
    private JMenu archivo, efectos;
    private JMenuItem cargar, remove;
    private JMenuItem negativo, blur, sharpen, reset;

    public MenuBar(){
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
