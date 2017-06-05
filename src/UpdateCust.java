
import com.mysql.jdbc.PreparedStatement;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rahul
 */
public class UpdateCust extends JFrame implements ActionListener,ItemListener
{
     File file=null;
        String path="";
    JPanel jp1,jp2;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15;
    JComboBox c1,c2,c3,c4,c5,c6;
    JButton b1,b2,b3;
    String s1="",s2="",s3="",s4="",s5="",acno="";
    byte image[]=null;
  ImageIcon i5;
  public UpdateCust(String ano)
    {
        
        acno=ano;
        setSize(1366,769);
        setVisible(true);
        setLayout(null);
        jp1=new JPanel();
        jp1.setBounds(300,0,766,768);
         jp1.setLayout(null);
        jp1.setBackground(Color.red);
        this.add(jp1);
        
        jp2=new JPanel();
        jp2.setBounds(0,70,766,598);
        jp2.setLayout(null);
        jp2.setBackground(Color.orange);
        jp1.add(jp2);
        
         Font f=new Font("Arial",Font.PLAIN,20);
       
        l1=new JLabel("Account Number");
        l1.setBounds(20,10,150,20);
        l1.setFont(f);
        l1.setForeground(Color.blue);
        jp2.add(l1);
        
        t1=new JTextField("");
       // t1.setEditable(false);
        t1.setBounds(250,10,200,30);
        t1.setFont(f);
        t1.setForeground(Color.darkGray);
        t1.setBackground(Color.white);
        jp2.add(t1);
        
        
        l2=new JLabel("Customer Id No");
        l2.setBounds(20,50,150,20);
        l2.setFont(f);
        l2.setForeground(Color.blue);
        jp2.add(l2);
        
        t2=new JTextField();
       // t1.setEditable(false);
        t2.setBounds(250,50,200,30);
        t2.setFont(f);
        t2.setForeground(Color.darkGray);
        t2.setBackground(Color.white);
        jp2.add(t2);
        
        l3=new JLabel("Name");
        l3.setBounds(20,90,150,20);
        l3.setFont(f);
        l3.setForeground(Color.blue);
        jp2.add(l3);
        
        t3=new JTextField();
       // t1.setEditable(false);
        t3.setBounds(250,90,200,30);
        t3.setFont(f);
        t3.setForeground(Color.darkGray);
        t3.setBackground(Color.white);
        jp2.add(t3);
        
         l4=new JLabel("Father/Husband Name");
        l4.setBounds(20,130,200,20);
        l4.setFont(f);
        l4.setForeground(Color.blue);
        jp2.add(l4);
        
        t4=new JTextField();
       // t1.setEditable(false);
        t4.setBounds(250,130,200,30);
        t4.setFont(f);
        t4.setForeground(Color.darkGray);
        t4.setBackground(Color.white);
        jp2.add(t4);
        
        
         l5=new JLabel("Date of Birth");
        l5.setBounds(20,170,200,20);
        l5.setFont(f);
        l5.setForeground(Color.blue);
        jp2.add(l5);
        
       /////////
        t15=new JTextField();
         t15.setBounds(250,170,200,30);
        t15.setFont(f);
        t15.setForeground(Color.darkGray);
        t15.setBackground(Color.white);
        jp2.add(t15);
        
        
         l6=new JLabel("Educational Qualif");
        l6.setBounds(20,210,200,20);
        l6.setFont(f);
        l6.setForeground(Color.blue);
        jp2.add(l6);
        
        t6=new JTextField();
       // t1.setEditable(false);
        t6.setBounds(250,210,200,30);
        t6.setFont(f);
        t6.setForeground(Color.darkGray);
        t6.setBackground(Color.white);
        jp2.add(t6);
        
        l7=new JLabel("Permanent Address");
        l7.setBounds(20,250,200,20);
        l7.setFont(f);
        l7.setForeground(Color.blue);
        jp2.add(l7);
        
        t7=new JTextField();
       // t1.setEditable(false);
        t7.setBounds(250,250,200,30);
        t7.setFont(f);
        t7.setForeground(Color.darkGray);
        t7.setBackground(Color.white);
        jp2.add(t7);
        
        l8=new JLabel("Aadhar Number");
        l8.setBounds(20,290,200,20);
        l8.setFont(f);
        l8.setForeground(Color.blue);
        jp2.add(l8);
        
        t8=new JTextField();
       // t1.setEditable(false);
        t8.setBounds(250,290,200,30);
        t8.setFont(f);
        t8.setForeground(Color.darkGray);
        t8.setBackground(Color.white);
        jp2.add(t8);
        
        l9=new JLabel("PAN Number");
        l9.setBounds(20,330,200,20);
        l9.setFont(f);
        l9.setForeground(Color.blue);
        jp2.add(l9);
        
        t9=new JTextField();
       // t1.setEditable(false);
        t9.setBounds(250,330,200,30);
        t9.setFont(f);
        t9.setForeground(Color.darkGray);
        t9.setBackground(Color.white);
        jp2.add(t9);
        
        l11=new JLabel("Opening Balance");
        l11.setBounds(20,370,200,20);
        l11.setFont(f);
        l11.setForeground(Color.blue);
        jp2.add(l11);
        
        t10=new JTextField();
       // t1.setEditable(false);
        t10.setBounds(250,370,200,30);
        t10.setFont(f);
        t10.setForeground(Color.darkGray);
        t10.setBackground(Color.white);
        jp2.add(t10);
        
        c1=new JComboBox();
        c1.setBounds(20,410,200,30);
        c1.setBackground(Color.white);
        c1.setFont(new Font("Arial",Font.BOLD,12));
        c1.addItem("Security Questions");
        c1.addItem("Best Friend Name");
        c1.addItem("Pet Name");
        c1.addItem("Grand father Name");
        c1.addItem("Favorite Color");
        c1.addItem("Street Name");
         c1.addItemListener(this);
        jp2.add(c1);
        
         t11=new JTextField();
         t11.setBounds(250,410,200,30);
        t11.setFont(f);
        t11.setForeground(Color.darkGray);
        t11.setBackground(Color.white);
        jp2.add(t11);
        
        t12=new JTextField();
        t12.setVisible(false);
        jp2.add(t12);
        
        
        l12=new JLabel("Email Id");
        l12.setBounds(20,450,200,20);
        l12.setFont(f);
        l12.setForeground(Color.blue);
        jp2.add(l12);
        
        t13=new JTextField();
       // t1.setEditable(false);
        t13.setBounds(250,450,200,30);
        t13.setFont(f);
        t13.setForeground(Color.darkGray);
        t13.setBackground(Color.white);
        jp2.add(t13);
        
        l13=new JLabel("Phone Number");
        l13.setBounds(20,490,200,20);
        l13.setFont(f);
        l13.setForeground(Color.blue);
        jp2.add(l13);
        
        t14=new JTextField();
       // 1.setEditable(false);
        t14.setBounds(250,490,200,30);
        t14.setFont(f);
        t14.setForeground(Color.darkGray);
        t14.setBackground(Color.white);
        jp2.add(t14);
        
        
                i5=new ImageIcon("man.png");
                l10=new JLabel(i5);
                jp2.add(l10);
                l10.setBounds(500,20,210,256);
                l10.setBorder(BorderFactory.createLineBorder(Color.CYAN,2));
                    ImageIcon i1=new ImageIcon("up11.jpg");
                b1=new JButton(i1);
                jp2.add(b1);
                b1.setFont(new Font("Elephant",1,25));
                b1.setBounds(500,293,200,50);
                b1.addActionListener(this);
                
                 ImageIcon i2=new ImageIcon("register.png");
                b2=new JButton(i2);
                jp2.add(b2);
                b2.setFont(new Font("Elephant",1,25));
                b2.setBounds(250,540,120,50);
                b2.addActionListener(this);
                
            
                
   try{  
              
Class.forName("com.mysql.jdbc.Driver");  
//here sonoo is database name, newuser is username and password
            try (Connection con = DriverManager.getConnection("jdbc:mysql://34.208.185.11:3306/rahul","newuser","deepak")) {
                //here sonoo is database name, newuser is username and password
                String query="select * from customer where ano='12345678' ";
    try (PreparedStatement ps = (PreparedStatement) con.prepareStatement(query)) {
       // ps.setString(1,acno);
        ResultSet rs=ps.executeQuery(query);
        if(rs.next())
        {
            t1.setText(rs.getString(1));
            t2.setText(rs.getString(2));
            t3.setText(rs.getString(4));
            t4.setText(rs.getString(5));
            t15.setText(rs.getString(6));
            
            t6.setText(rs.getString(7));
            t7.setText(rs.getString(8));
            t8.setText(rs.getString(9));
            t9.setText(rs.getString(10));
            t10.setText(rs.getString(11));
            c1.setActionCommand(rs.getString(12));
            t11.setText(rs.getString(13));
            t13.setText(rs.getString(17));
            t14.setText(rs.getString(18));
             image= rs.getBytes(14);
                                       
                                       Image img=Toolkit.getDefaultToolkit().createImage(image);
                                       
                                        ImageIcon icon=new ImageIcon(img);
                         
                                       i5.setImage(img);
        
        }
    }
            }  
}catch(Exception e){ System.out.println(e);}

        
  this.invalidate();
this.validate();
this.repaint();
                
 this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);      
        
        
        
    }
  public void actionPerformed(ActionEvent ae)
   {            
               if(ae.getSource()==b1)
                        {
                           
                        JFileChooser chooser=new JFileChooser();
                        chooser.addChoosableFileFilter(new ImageFileFilter());
                        int returnVal=chooser.showOpenDialog(null);
                        if(returnVal==JFileChooser.APPROVE_OPTION)
                                {
                                file=chooser.getSelectedFile();
                                path=file.getPath();
                                ImageIcon icon=new ImageIcon(path);
                                l10.setIcon(icon);
                               // t20.setText(path);
                                }
                        }
               else if(ae.getSource()==b2)
               {
                   String ano=t1.getText();
                   String cid=t2.getText();
                   String nm=t3.getText();
                   String fnm=t4.getText();
                   String qual=t6.getText();
                    String add=t7.getText();
                   String aano=t8.getText();
                    String pan=t9.getText();
                    String mob=t14.getText();
                    String mail=t13.getText();
                    
                     String ans=t11.getText();
                  // JOptionPane.showMessageDialog(null," 1 Record Inserted !");
                  Calendar calendar = Calendar.getInstance();
      java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
//ps.setDtae();
                  try{  
                       //File f=new File(path);                
      // FileInputStream fis=new FileInputStream(f);
      
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://34.208.185.11:3306/rahul","newuser","deepak");  
//here sonoo is database name, newuser is username and password  

String query="UPDATE `customer` SET `cid`=?,`name`=?,`fname`=?,`dob`=?,`qualif`=?,`add`=?,`aadhar`=?,`pan`=?,`sq`=?,`sans`=?,`phone`=?,`mail`=? WHERE `ano`=? ";
PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
ps.setString(1,cid);
ps.setString(2,nm);
ps.setString(3,fnm);
ps.setString(4,t15.getText());
ps.setString(5,qual);
ps.setString(6,add);
ps.setString(7,aano);
ps.setString(8,pan);
ps.setString(9,s4);
ps.setString(10,ans);
//ps.setBinaryStream(11,(InputStream)fis,(int)(f.length()));
 ps.setString(11,mob);
 ps.setString(12,mail);
 ps.setString(13,ano);
                                	ps.executeUpdate();
          String msg="Your account details has been updated !!!!";                              
                                        EmailSend.sendMail(mail, msg);
                                         java.util.Date date= new java.util.Date();
        Timestamp tm=new Timestamp(date.getTime());
     
                                                      String query1="INSERT INTO `rahul`.`history` (`empid`, `msg`, `doh`) VALUES (?,?,?)";
                                        PreparedStatement ps1 = (PreparedStatement) con.prepareStatement(query1);
ps1.setString(1,"emp102");
ps1.setString(2,"Account updated of CId="+ano);
ps1.setTimestamp(3,tm);
ps1.executeUpdate();  

//JOptionPane.showMessageDialog(null," User account updated!");
query1="update request set flag=1 where ano=?";
ps1=(PreparedStatement) con.prepareStatement(query1);
ps1.setString(1, ano);
ps1.executeUpdate();

query1="delete from seccode where ano=?";
ps1=(PreparedStatement) con.prepareStatement(query1);
ps1.setString(1, ano);
ps1.executeUpdate();

query1="INSERT INTO `cnotify`(`notify`) VALUES ('Your Request has accepted and changed your details' ) ";
ps1=(PreparedStatement) con.prepareStatement(query1);
ps1.executeUpdate();

   JOptionPane.showMessageDialog(null," User account updated!");
                       this.setVisible(false);
                                        //new AdminHome(enm,epwd);
                                        ps.close();
                                       








      
con.close();  
}catch(Exception e){ System.out.println(e);}  
}  
}  
            public void itemStateChanged(ItemEvent ie)
                {
                   if(ie.getItemSelectable()==c1)
                        {
                        s4=(String)c1.getSelectedItem();
                        //s3+="";
                        }
                }
                    
   
   
    public static void main(String[] args)
    {
        new UpdateCust("12345678");
    }  
}
