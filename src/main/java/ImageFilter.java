/*Filtro para mostrar solo archivos con la terminacion relacionadas a imagenes o carpetas */

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class ImageFilter extends FileFilter {
    private final String whiteList[] = {"jpeg", "jpg", "png"};
    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        String extension = this.getExtension(f);
        if(extension != null){
            for(String str: whiteList){
                if(str.equals(extension)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String getDescription() {
        return "Imagenes";
    }

    public String getExtension(File f){
        String ext = null;
        String str = f.getName();
        int i = str.lastIndexOf('.');

        if (i > 0 &&  i < str.length() - 1) {
            ext = str.substring(i+1).toLowerCase();
        }
        return ext;
    }
}

