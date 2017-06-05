
import com.mysql.jdbc.PreparedStatement;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.System.in;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rahul
 */
public class COwnerHome extends JFrame  implements ActionListener
{
    JPanel jp1,jp2,jp3,jp4,jp5,jp6,jp7,jp8,jp9;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,cl,l11,l12;
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20;
    JRadioButton r1,r2,r3,r4,r5,r6,r7,r8,r9,r10;
    JCheckBox jc1,jc2,jc3,jc4,jc5,jc6,jc7,jc8,jc9,jc10;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    Image img;
    JTextArea jt1,jt2;
    byte[]image=null;
    String pwd="";
    private int i=0;
             private Timer timer;
        private ImageIcon pictures1,pictures2,pictures3,pictures4,pictures5,pictures6,pictures7,pictures8,pictures9,pictures10;
String req="",ano="";
String munm="",mpwd="";
static JTable table;
    //String[] columnNames = {"User name", "Email", "Password", "Country"};
      String[] columnNames = {"Hisory And Activities"};
        DefaultTableModel model = new DefaultTableModel();
    public COwnerHome(String unm,String pwd) throws SQLException
    {
       munm=unm;
       mpwd=pwd;

         setSize(1366,769);
        this.setVisible(true);
        setLayout(null);
       // this.pack();
        jp1=new JPanel();
        jp1.setBounds(0,0,1366,768);
         jp1.setLayout(null);
        jp1.setBackground(Color.blue);
        this.add(jp1);
        timer=new Timer(2000,this);
                timer.start();

        jp2=new JPanel();
        jp2.setBounds(0,0,1366,120);
         jp2.setLayout(null);
        jp2.setBackground(Color.WHITE);
        jp1.add(jp2);
        
        ImageIcon ic1=new ImageIcon("cloud3.jpg");
         cl=new JLabel(ic1);
         cl.setBounds(0,0,1366,120);
         cl.setLayout(null);
         jp2.add(cl);
           l11=new JLabel("Security In Cloud rahuling Transaction");
                cl.add(l11);
                l11.setBounds(280,10,720,50);
                l11.setFont(new Font("Stencil",Font.ITALIC,30));
                l11.setForeground(new Color(88, 24, 69  ));
        ImageIcon i1=new ImageIcon("man.png");
                l1=new JLabel(i1);
                cl.add(l1);
                l1.setBounds(1240,0,120,120);
                l1.setBorder(BorderFactory.createLineBorder(Color.CYAN,2));
                
                l2=new JLabel("Welcome Mr. ");
                cl.add(l2);
                l2.setBounds(30,80,520,30);
                l2.setFont(new Font("Arial",Font.BOLD,25));
                
                 l3=new JLabel("Last Active Time :");
                cl.add(l3);
               l3.setBounds(750,90,520,30);
                l3.setFont(new Font("Arial",Font.BOLD,25));
                
                ImageIcon i4=new ImageIcon("logout3.jpg");
                b1=new JButton(i4);
                cl.add(b1);
                b1.setBounds(970,0,269,75);
                b1.setFont(new Font("Arial",Font.BOLD,25));
                b1.setBackground(Color.red);
                b1.addActionListener(this);
                
                
                 b2=new JButton("Get File");
                jp1.add(b2);
                b2.setBounds(730,125,269,40);
                b2.setFont(new Font("Arial",Font.BOLD,25));
                b2.setBackground(Color.ORANGE);
                b2.addActionListener(this);
                
        jt1=new JTextArea();
        jp1.add(jt1);
                jt1.setBounds(50,170,400,350);
                jt1.setFont(new Font("Arial",Font.PLAIN,12));
                jt1.setBackground(Color.cyan);
                
                 l4=new JLabel("Attributes For Encryption ");
                jt1.add(l4);
                l4.setBounds(50,20,520,30);
                l4.setFont(new Font("Arial",Font.BOLD,25));
                
                 
                 l5=new JLabel("File Name ");
                jt1.add(l5);
                l5.setBounds(30,60,170,30);
                l5.setFont(new Font("Arial",Font.BOLD,25));
                
                
                t1=new JTextField();
                jt1.add(t1);
                t1.setBounds(210,60,120,30);
                t1.setFont(new Font("Arial",Font.BOLD,25));
                
                  l6=new JLabel("File Size ");
                jt1.add(l6);
                l6.setBounds(30,100,170,30);
                l6.setFont(new Font("Arial",Font.BOLD,25));
                
                
                t2=new JTextField();
                jt1.add(t2);
                t2.setBounds(210,100,120,30);
                t2.setFont(new Font("Arial",Font.BOLD,25));
                
                
                  l7=new JLabel("File Extension ");
                jt1.add(l7);
                l7.setBounds(10,140,190,30);
                l7.setFont(new Font("Arial",Font.BOLD,25));
                
                
                t3=new JTextField();
                jt1.add(t3);
                t3.setBounds(210,140,120,30);
                t3.setFont(new Font("Arial",Font.BOLD,25));
                
                 b3=new JButton("Encrypt File");
                jp1.add(b3);
                b3.setBounds(530,625,269,40);
                b3.setFont(new Font("Arial",Font.BOLD,25));
                b3.setBackground(Color.ORANGE);
                b3.addActionListener(this);
                 
        jt2=new JTextArea();
        jp1.add(jt2);
                jt2.setBounds(500,170,800,450);
                jt2.setFont(new Font("Arial",Font.PLAIN,17));
                jt2.setBackground(Color.cyan);
                
        b4=new JButton("Decrypt File");
                jp1.add(b4);
                b4.setBounds(930,625,269,40);
                b4.setFont(new Font("Arial",Font.BOLD,25));
                b4.setBackground(Color.ORANGE);
                b4.addActionListener(this);
       
        try {  
            Class.forName("com.mysql.jdbc.Driver");
       Connection con=DriverManager.getConnection("jdbc:mysql://34.208.185.11:3306/rahul","newuser","deepak");  
//here sonoo is database name, newuser is username and password  
String query="select * from cloudowner where userid=? and pwd=?";
PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
ps.setString(1,munm);
ps.setString(2,mpwd);
ResultSet rs=ps.executeQuery();
if(rs.next())
{
    String nm=rs.getString(4);
    String time=rs.getString(5);
    // image= rs.getBytes(14);
     //Image img=Toolkit.getDefaultToolkit().createImage(image);
     //ImageIcon icon=new ImageIcon(img);
     //l1.setIcon(icon);
        
    l2.setText(l2.getText()+ ""+nm);
    l3.setText(l3.getText()+ ""+time);
    
} 
         } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        this.invalidate();
this.validate();
this.repaint();
        
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
             java.util.Date date= new java.util.Date();
        Timestamp tm=new Timestamp(date.getTime());
        //System.out.println(tm);
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://34.208.185.11:3306/rahul","newuser","deepak");
//here sonoo is database name, newuser is username and password
                String query="update cloudowner set time=?,active=? where userid=? and pwd=?";
                PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
                ps.setTimestamp(1, tm);
                ps.setString(2, "off");
                ps.setString(3, munm);
                ps.setString(4, mpwd);
                int rs=ps.executeUpdate();
                this.setVisible(false);
                new AdminLogout();
            } catch (SQLException ex) {
                Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(ae.getSource()==b2)
        {
            try { 
String one = ""; 
String two = ""; 
FileReader fr = new FileReader("clouddata.txt"); 
BufferedReader in = new BufferedReader(fr); 
while ((one = in.readLine()) != null) { 
two += two + one; 
} 
File f=new File("clouddata.txt");
t1.setText(f.getName().toString());
t2.setText(Long.toString(f.length()));
t3.setText("txt");
               
jt2.setText(two); 
} catch (FileNotFoundException ex) { 
ex.printStackTrace(); 
}catch (IOException e){ 
e.printStackTrace(); 
}
        }
        else if(ae.getSource()==b3)
        {
             try {
                 String dat=jt2.getText();
                 jt2.setText(AESAlgo.encrypt(dat));
                 //JOptionPane.showMessageDialog(null,dat);
                     pwd=AESAlgo.encrypt(t1.getText()+t2.getText()+t3.getText()).substring(0, 8);
                     //  JOptionPane.showMessageDialog(null,pwd);
                   EmailSend.sendMail("rahulkumarit3@gmail.com", "Your decryption code is "+pwd);
                } catch (Exception ex) {
                    Logger.getLogger(COwnerHome.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
                  
         else if(ae.getSource()==b4)
        {
             try {
                 String epwd=JOptionPane.showInputDialog("Enter decryption code :");
                 if(epwd.compareTo(pwd)==0)
                 {
                 jt2.setText(AESAlgo.decrypt(jt2.getText()));
                 }
                 else
                 {
                     JOptionPane.showMessageDialog(null,"DEC code mismatched");
                 }
                                   } catch (Exception ex) {
                    Logger.getLogger(COwnerHome.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
                  
                }
                    
    
    public static void main(String[] args)
    {
        try { 
            new COwnerHome("15mca0063","project");
        } catch (SQLException ex) {
            Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
