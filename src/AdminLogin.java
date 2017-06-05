
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rahul
 */
public class AdminLogin extends JFrame implements ActionListener{
    
    JPanel jp1,jp2,jp3,jp4,jp5;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
    JTextField t1,t4,t5,t8,t7,t9,t10;
    JPasswordField t2,t3,t6;
    JButton b1,b2,b3,b4;
    String munm="",mpwd="",meid="";
     String sa1="",sa2="";Random rnd=new Random();
                int rd=0;
  
    public AdminLogin()
    {
      setSize(1366,769);
        setVisible(true);
        setLayout(null);
       setBackground(Color.white);
       
       jp4=new JPanel();
        jp4.setBounds(0,0,1366,768);
        jp4.setBackground(Color.white);
          jp4.setLayout(null);
        this.add(jp4);
        
        
        jp1=new JPanel();
        jp1.setBounds(500,100,700,400);
        jp1.setBackground(Color.blue);
          jp1.setLayout(null);
        jp4.add(jp1);
        
        
        jp2=new JPanel();
        jp2.setBounds(0,50,700,300);
        jp2.setLayout(null);
        jp2.setBackground(Color.cyan);
        jp1.add(jp2);
        
         Font f=new Font("Arial",Font.BOLD,20);
        l3=new JLabel("ADMIN LOGIN ");
        l3.setBounds(250,10,200,25);
        l3.setFont(f);
        l3.setForeground(Color.ORANGE);
        jp1.add(l3);
         
        l1=new JLabel("ENTER USERID");
        l1.setBounds(120,10,200,25);
        l1.setFont(f);
        l1.setForeground(Color.blue);
        jp2.add(l1);
        
        t1=new JTextField("");
       // t1.setEditable(false);
        t1.setBounds(350,10,200,30);
        t1.setFont(f);
        t1.setForeground(Color.darkGray);
        t1.setBackground(Color.white);
        jp2.add(t1);
        
        
        l2=new JLabel("ENTER PASSWORD");
        l2.setBounds(120,50,200,25);
        l2.setFont(f);
        l2.setForeground(Color.blue);
        jp2.add(l2);
        
        t2=new JPasswordField();
       // t1.setEditable(false);
        t2.setBounds(350,50,200,30);
        t2.setFont(f);
        t2.setForeground(Color.darkGray);
        t2.setBackground(Color.white);
        jp2.add(t2);
        
        l5=new JLabel("ENTER EMPID");
        l5.setBounds(120,90,200,25);
        l5.setFont(f);
        l5.setForeground(Color.blue);
        jp2.add(l5);
        
        t3=new JPasswordField();
       // t1.setEditable(false);
        t3.setBounds(350,90,200,30);
        t3.setFont(f);
        t3.setForeground(Color.darkGray);
        t3.setBackground(Color.white);
        jp2.add(t3);
        
        
        ImageIcon im=new ImageIcon("admin.jpg");
	l4=new JLabel(im);
	l4.setBounds(0,0,500,700);
	jp4.add(l4);
        
         l8=new JLabel("");
        l8.setBounds(250,170,200,25);
        l8.setFont(f);
        l8.setForeground(Color.blue);
        jp2.add(l8);
        
        t7=new JTextField("");
       // t1.setEditable(false);
        t7.setBounds(450,170,200,30);
        t7.setFont(f);
        t7.setForeground(Color.darkGray);
        t7.setBackground(Color.white);
        jp2.add(t7);
        
        l9=new JLabel("");
        l9.setBounds(250,210,200,25);
        l9.setFont(f);
        l9.setForeground(Color.blue);
        jp2.add(l9);
        
        t8=new JTextField("");
       // t1.setEditable(false);
        t8.setBounds(450,210,200,30);
        t8.setFont(f);
        t8.setForeground(Color.darkGray);
        t8.setBackground(Color.white);
        jp2.add(t8);
        
         b4=new JButton("Generate OTP");
       b4.setBounds(300,260,250,30);
       b4.addActionListener(this);
	jp2.add(b4);
      l8.setVisible(false);
       l9.setVisible(false);
       t7.setVisible(false);
       t8.setVisible(false);
       b4.setVisible(false);
       
      
        
        ImageIcon im2=new ImageIcon("lg.png");
        b1=new JButton(im2);
        b1.setBounds(225,130,150,35);
        jp2.add(b1);
        b1.addActionListener(this);
         
         jp3=new JPanel();
        jp3.setBounds(500,100,700,400);
        jp3.setBackground(Color.white);
          jp3.setLayout(null);
          jp3.setVisible(false);
        jp4.add(jp3);
        
        
        ImageIcon im1=new ImageIcon("mob.jpg");
	l6=new JLabel(im1);
	l6.setBounds(0,100,330,330);
	jp3.add(l6);
        
        
        l7=new JLabel("ENTER KEY");
        l7.setBounds(120,120,200,25);
        l7.setFont(new Font("Arial",Font.BOLD,12));
        l7.setForeground(Color.BLACK);
        l6.add(l7);
        
        t6=new JPasswordField();
        t6.setBounds(110,160,100,30);
        t6.setFont(f);
        t6.setForeground(Color.darkGray);
        t6.setBackground(Color.white);
        l6.add(t6);
        
        b3=new JButton("verify");
        b3.setBounds(120,200,80,30);
        b3.setBackground(Color.red);
        l6.add(b3);
        b3.addActionListener(this);
        
          this.invalidate();
this.validate();
this.repaint();
        
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            try {
                String uid=t1.getText();
                String pwd=AESAlgo.encrypt(t2.getText());
                String eid=t3.getText();
                
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://34.208.185.11:3306/rahul","newuser","deepak");
                String query="select * from admin where empid=? and pwd=? and userid=?";
                PreparedStatement ps=con.prepareStatement(query);
                ps.setString(1, eid);
                ps.setString(2, pwd);
               ps.setString(3, uid);
                 ResultSet rs=ps.executeQuery();
                
                if(rs.next())
                {
                     String active=rs.getString(12);
                if(active.compareTo("off")==0)
                {
                    Random rand=new Random();
            int r=rand.nextInt(5);
            if(r==0)
                r=1;
           munm=uid;
           mpwd=pwd;
           meid=eid;
            String query1="select * from security where empid=?";
            PreparedStatement ps1=con.prepareStatement(query1);
            ps1.setString(1, eid);
             ResultSet rs1=ps1.executeQuery();
              
             if(rs1.next())
             {
                String sq1=rs1.getString(r);
                String sq2=rs1.getString(r+1);
                l8.setText(sq1);
                l9.setText(sq2);
                  sa1=(rs1.getString(r+5)).trim();
                sa2=(rs1.getString(r+1+5)).trim();
               
                  l8.setVisible(true);
       l9.setVisible(true);
       t7.setVisible(true);
       t8.setVisible(true);
       b4.setVisible(true);  
                }
                }
                else
                     JOptionPane.showMessageDialog(null,"somebody already logged in.......");
                }
                else
                {
                JOptionPane.showMessageDialog(null,"wrong user id  pwd....");
                }
            } catch (SQLException ex) {
                Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
           
         }
        else if(ae.getSource()==b3)
        {
            int otp=Integer.parseInt(t6.getText());
        if(otp==rd)
        {
           
            try {
                  Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://34.208.185.11:3306/rahul","newuser","deepak");
                String query="UPDATE `admin` SET `active`=? WHERE  empid=? and pwd=?";
                PreparedStatement ps=con.prepareStatement(query);
                  ps.setString(1, "on");
                ps.setString(2, meid);
                ps.setString(3, mpwd);
                
                int i=ps.executeUpdate();
                if(i>0)
                {
              
                query="INSERT INTO `track`(`tid`, `ipadd`, `macadd`) VALUES (?,?,?)";
                ps=con.prepareStatement(query);
                ps.setString(1,munm);
                ps.setString(2, App.getIP());
                ps.setString(3, App.getMAC());
                ps.executeUpdate();
                 this.setVisible(false);
                new AdminHome(meid,mpwd);
                }
                else
                     JOptionPane.showMessageDialog(null,"somebody already logged in..");
            } catch (SQLException ex) {
                Logger.getLogger(MainLogin.class.getName()).log(Level.SEVERE, null, ex);
            }   catch (ClassNotFoundException ex) {
                    Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
            JOptionPane.showMessageDialog(null,"Succeed...Go Ahead....");
        }
        else if(ae.getSource()==b4)
        {
            String ans1=(t7.getText()).trim();
        String ans2=(t8.getText()).trim();
         
         
        if(ans1.compareToIgnoreCase(sa1)==0)
        {
            if(ans2.compareToIgnoreCase(sa2)==0)
            {
                 rd=rnd.hashCode()%10000;
              MobileSms.sendMsg("Your OTP is "+rd);
               JOptionPane.showMessageDialog(null, "OTP has sent to your registered mobile.. ");
            l4.setVisible(false);
           jp1.setVisible(false);
           jp3.setVisible(true);
         
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Enter 2nd Correct ans...");
            }
        }
        else
        {
         JOptionPane.showMessageDialog(null, "Enter Ist Correct ans...");
        }
        }
    }
    
      public static void main(String[] args)
    {
        new AdminLogin();
    }
    
    
}
