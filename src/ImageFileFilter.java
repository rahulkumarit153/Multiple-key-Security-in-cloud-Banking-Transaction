import java.io.*;
public class ImageFileFilter extends javax.swing.filechooser.FileFilter
        {
        @Override
        public boolean accept(File file)
                {
                if(file.isDirectory())return false;
                 String name=file.getName().toLowerCase();
                 return (name.endsWith(".jpg") || name.endsWith(".png") || name.endsWith(".gif"));
                 }
        @Override
        public String getDescription()
                {
                return "images(*.gif,*.bmp,*.jpg,*.png)";
                }
        }
