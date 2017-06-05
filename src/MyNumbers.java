/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rahul
 */
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import com.itextpdf.awt.PdfGraphics2D;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class MyNumbers extends JFrame {
    private ResourceBundle rb;
    private Font devanagariFont;

    public MyNumbers (String language, String fontFile) {
        loadResourceBundle(language);
        loadFont(fontFile);
        display();
    }

    TextArea txtArea;

    private void display() {
        String unicode = null;

        JPanel labels = new JPanel(new GridLayout(0,2));
        JLabel uni = null;
        for(int i=0; i<=10; i++) {
            unicode = rb.getString("" +i);
            labels.add(new JLabel("" + i));
            labels.add(uni = new JLabel(unicode));
            //uni.setFont(devanagariFont);
        }
        labels.add(new JLabel("Time"));
        labels.add(new ClockLabel());
        getContentPane().setLayout(new FlowLayout());
        Box b = Box.createVerticalBox();
        b.add(labels);
        b.add(txtArea = new TextArea(10, 40));
        getContentPane().add(b);
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowOpened(WindowEvent e) {
                // TODO Auto-generated method stub
                try {
                    getInputContext().selectInputMethod(new Locale("hi", "IN"));
                    read();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }

            @Override
            public void windowClosing(WindowEvent e) {
                // TODO Auto-generated method stub
                try {
                    System.out.println(getInputContext().getLocale());
                    save();
                    print();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                System.exit(0);

            }


        });
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);



    }


    String fileName = "MyNumbers.txt";
    private void save() throws IOException {
        File f = new File(fileName);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f), "UTF-16"));
        String txt = txtArea.getText();
        writer.write(txt);
        writer.flush();
        writer.close();
    }

    private void read() throws IOException {
        File f = new File(fileName);
        if(f.exists() == false) return;
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF-16"));
        String line = null;
        while((line = reader.readLine()) != null) {
            txtArea.append(line + "\n");
        }
        reader.close();
    }

    private void loadFont(String fontFile) {
        try {
            InputStream input = getClass().getResourceAsStream(fontFile);
            Font b = Font.createFont(Font.TRUETYPE_FONT, input);
            devanagariFont = b.deriveFont(Font.PLAIN, 11);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void loadResourceBundle(String language) {
        String base = getClass().getName() + "rb";
        rb = ResourceBundle.getBundle(base, new Locale(language));

    }

    static class ClockLabel extends JLabel implements ActionListener {


        private ClockLabel() {
            new Timer(1000, this).start();
        }



        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        public void actionPerformed(ActionEvent e) {
            Calendar cal = Calendar.getInstance();
            setText(sdf.format(cal.getTime()));

        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MyNumbers("hi", "Devnew.ttf");      
            }
        });

    }

    String pdfFileName = "MyNumbers.pdf";
    private void print() {
        System.out.println("Printing PDF file ..");
        try { 
            Document document = new Document(PageSize.A4);  
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdfFileName));
            document.open();
            PdfContentByte cb = writer.getDirectContent( );
            PdfGraphics2D g2d = new PdfGraphics2D(cb, PageSize.A4.getWidth(), PageSize.A4.getHeight());
            System.out.println(txtArea.getSize());
            txtArea.print(g2d);
            g2d.dispose();
            document.close ();
        }
        catch(DocumentException de) {
            System.err.println(de.getMessage());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MyNumbers.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}