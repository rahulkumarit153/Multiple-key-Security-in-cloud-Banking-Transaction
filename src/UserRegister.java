
import com.mysql.jdbc.PreparedStatement;
import java.awt.Color;
import java.awt.Font;
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
public class UserRegister extends JFrame implements ActionListener,ItemListener
{
     File file=null;
        String path="";
    JPanel jp1,jp2;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15;
    JComboBox c1,c2,c3,c4,c5,c6;
    JButton b1,b2,b3;
    String s1="",s2="",s3="",s4="",s5="",enm="",epwd="";
    
    public UserRegister(String eid,String pwd)
    {
        enm=eid;
        epwd=pwd;
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
        c4=new JComboBox();
                c4.setBounds(250,170,60,30);
                c4.setBackground(Color.white);
                c4.setFont(new Font("Arial",Font.BOLD,12));
                c4.addItem("DAY");
                c4.addItem("1");
                c4.addItem("2");
                c4.addItem("3");
                c4.addItem("4");
                c4.addItem("5");
                c4.addItem("6");
                c4.addItem("7");
                c4.addItem("8");
                c4.addItem("9");
                c4.addItem("10");
                c4.addItem("11");
                c4.addItem("12");
                c4.addItem("13");
                c4.addItem("14");
                c4.addItem("15");
                c4.addItem("16");
                c4.addItem("17");
                c4.addItem("18");
                c4.addItem("19");
                c4.addItem("20");
                c4.addItem("21");
                c4.addItem("22");
                c4.addItem("23");
                c4.addItem("24");
                c4.addItem("25");
                c4.addItem("26");
                c4.addItem("27");
                c4.addItem("28");
                c4.addItem("29");
                c4.addItem("30");
                c4.addItem("31");
                c4.addItemListener(this);

                c5=new JComboBox();
                c5.setBackground(Color.white);
                c5.setBounds(315,170,80,30);
                c5.setFont(new Font("Arial",Font.BOLD,12));
                c5.addItem("MONTH");
                c5.addItem("Jan");
                c5.addItem("Feb");
                c5.addItem("March");
                c5.addItem("April");
                c5.addItem("May");
                c5.addItem("June");
                c5.addItem("July");
                c5.addItem("Aug");
                c5.addItem("Sept");
                c5.addItem("Oct");
                c5.addItem("Nov");
                c5.addItem("Dec");
                 c5.addItemListener(this);

                c6=new JComboBox();
                c6.setBounds(400,170,80,30);
                c6.setBackground(Color.white);	
                c6.setFont(new Font("Arial",Font.BOLD,12));
                c6.addItem("YEAR");
                c6.addItem("2014");
                c6.addItem("2013");
                c6.addItem("2012");
                c6.addItem("2011");
                c6.addItem("2010");
                c6.addItem("2009");
                c6.addItem("2008");
                c6.addItem("2007");
                c6.addItem("2006");
                c6.addItem("2005");
                c6.addItem("2004");
                c6.addItem("2003");
                c6.addItem("2002");
                c6.addItem("2001");
                c6.addItem("2000");
                c6.addItem("1999");
                c6.addItem("1998");
                c6.addItem("1997");
                c6.addItem("1996");
                c6.addItem("1995");
                c6.addItem("1994");
                c6.addItem("1993");
                c6.addItem("1992");
                c6.addItem("1991");
                c6.addItem("1990");
                c6.addItem("1989");
                c6.addItem("1988");
                c6.addItem("1987");
                c6.addItem("1986");
                c6.addItem("1985");
                c6.addItem("1984");
                c6.addItem("1983");
                c6.addItem("1982");
                c6.addItem("1981");
                c6.addItem("1980");
                c6.addItem("1979");
                c6.addItem("1979");
                c6.addItem("1978");
                c6.addItem("1977");
                c6.addItem("1976");
                c6.addItem("1975");
                c6.addItem("1974");
                c6.addItem("1973");
                c6.addItem("1972");
                c6.addItem("1971");
                c6.addItem("1970");
                 c6.addItemListener(this);
                jp2.add(c4);jp2.add(c5);jp2.add(c6);

        
        
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
        
        
                ImageIcon i5=new ImageIcon("man.png");
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
                   String dob=s1+s2+s3;
                   String qual=t6.getText();
                    String add=t7.getText();
                   String aano=t8.getText();
                    String pan=t9.getText();
                    String mob=t14.getText();
                    String mail=t13.getText();
                    
                     int bal=Integer.parseInt(t10.getText());
                     String ans=t11.getText();
                  // JOptionPane.showMessageDialog(null," 1 Record Inserted !");
                  Calendar calendar = Calendar.getInstance();
      java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
//ps.setDtae();
                  try{  
                        java.util.Date date= new java.util.Date();
        Timestamp tm=new Timestamp(date.getTime());
                       File f=new File(path);                
       FileInputStream fis=new FileInputStream(f);
      
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://34.208.185.11:3306/rahul","newuser","deepak");  
//here sonoo is database name, newuser is username and password  
String query="INSERT INTO `rahul`.`customer` (`ano`, `cid`, `pwd`, `name`, `fname`, `dob`, `qualif`, `add`, `aadhar`, `pan`, `bal`, `sq`, `sans`, `photo`,`phone`,`mail`,`lastactive`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
ps.setString(1,ano);
ps.setString(2,cid);
String pwd=AESAlgo.encrypt(nm+ano+cid);
pwd=pwd.substring(0, 8).toUpperCase();
String rpwd=AESAlgo.encrypt(pwd);
ps.setString(3,rpwd);
ps.setString(4,nm);
ps.setString(5,fnm);
ps.setString(6,dob);
ps.setString(7,qual);
ps.setString(8,add);
ps.setString(9,aano);
ps.setString(10,pan);
ps.setInt(11,bal);
ps.setString(12,s4);
ps.setString(13,ans);
 ps.setBinaryStream(14,(InputStream)fis,(int)(f.length()));
 ps.setString(15,mob);
 ps.setString(16,mail);
 ps.setTimestamp(17, tm);
                                	ps.executeUpdate();
                                        
                                        String msg="Your Account No is"+ano+"\n User Id is "+cid+" Password is "+pwd;
                                        EmailSend.sendMail(mail, msg);
                                        
     
                                                      String query1="INSERT INTO `rahul`.`history` (`empid`, `msg`, `doh`) VALUES (?,?,?)";
                                        PreparedStatement ps1 = (PreparedStatement) con.prepareStatement(query1);
ps1.setString(1,enm);
ps1.setString(2,"Account created of CId="+ano);
ps1.setTimestamp(3,tm);
ps1.executeUpdate();   
   JOptionPane.showMessageDialog(null," User account created !");
                       this.setVisible(false);
                                        new AdminHome(enm,epwd);
                                        ps.close();
                                       








      
con.close();  
}catch(Exception e){ System.out.println(e);}  
}  
}  
                  
                   
                   
   public void itemStateChanged(ItemEvent ie)
                {
                 if(ie.getItemSelectable()==c4)
                        {
                        s1=(String)c4.getSelectedItem();
                        s1+="-";
                        }
                 if(ie.getItemSelectable()==c5)
                        {
                        s2=(String)c5.getSelectedItem();
                        s2+="-";
                        }
                 if(ie.getItemSelectable()==c6)
                        {
                        s3=(String)c6.getSelectedItem();
                        s3+="";
                        }
                   if(ie.getItemSelectable()==c1)
                        {
                        s4=(String)c1.getSelectedItem();
                        //s3+="";
                        }
                }
                    
                   
                   
                   
               

   
    

   
    public static void main(String[] args)
    {
        new UserRegister("emp102","rahul");
    }  
}
