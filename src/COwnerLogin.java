
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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
public class COwnerLogin extends JFrame implements ActionListener
 {
    JPanel jp1,jp2,jp3,jp4;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    JTextField t1,t3,t4,t5;
    JPasswordField t2,t6;
    JButton b1,b2,b3,b4;
    String munm="",mpwd="";
     String sa1="",sa2="";Random rnd=new Random();Random rnd1=new Random();
                int rd=0,rd1=0;
  
public COwnerLogin()
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
        jp1.setBounds(400,100,700,400);
        jp1.setBackground(Color.blue);
          jp1.setLayout(null);
        jp4.add(jp1);
        
        
        jp2=new JPanel();
        jp2.setBounds(0,50,700,300);
        jp2.setLayout(null);
        jp2.setBackground(Color.white);
        jp1.add(jp2);
        
        
        
         Font f=new Font("Arial",Font.BOLD,20);
        l3=new JLabel("CLOUD OWNER LOGIN ");
        l3.setBounds(250,10,400,25);
        l3.setFont(f);
        l3.setForeground(Color.ORANGE);
        jp1.add(l3);
         
        l1=new JLabel("ENTER USERID");
        l1.setBounds(250,50,200,25);
        l1.setFont(f);
        l1.setForeground(Color.blue);
        jp2.add(l1);
        
        t1=new JTextField("");
       // t1.setEditable(false);
        t1.setBounds(450,50,200,30);
        t1.setFont(f);
        t1.setForeground(Color.darkGray);
        t1.setBackground(Color.white);
        jp2.add(t1);
        
        
        l2=new JLabel("ENTER PASSWORD");
        l2.setBounds(250,120,200,25);
        l2.setFont(f);
        l2.setForeground(Color.blue);
        jp2.add(l2);
        
        t2=new JPasswordField();
       // t1.setEditable(false);
        t2.setBounds(450,120,200,30);
        t2.setFont(f);
        t2.setForeground(Color.darkGray);
        t2.setBackground(Color.white);
        jp2.add(t2);
        
         ImageIcon im=new ImageIcon("ad1.png");
	l4=new JLabel(im);
	l4.setBounds(-50,0,300,300);
	jp2.add(l4);
        
       b1=new JButton("Sign In ");
       b1.setBounds(300,200,250,30);
	jp2.add(b1);
       
        
         b1.addActionListener(this);
          
          
            this.invalidate();
this.validate();
this.repaint();
        
       
        
}
public void actionPerformed(ActionEvent ae)
{
    if(ae.getSource()==b1)
    {
        try {
            String unm=t1.getText();
           // String pwd=AESAlgo.encrypt(t2.getText());
             String pwd=t2.getText();
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://34.208.185.11:3306/rahul","newuser","deepak");
            String query="select * from cloudowner where userid=? and pwd=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1, unm);
            ps.setString(2, pwd);
            
            ResultSet rs=ps.executeQuery();
           
            if(rs.next())
            {
                String active=rs.getString(3);
                
                if(active.compareTo("off")==0)
                {
                munm=unm;
                mpwd=pwd;
                this.setVisible(false);
             new COwnerHome(unm,pwd);
             }
                 else
                JOptionPane.showMessageDialog(null,"Somebody already logged in....");
            }
           
            else
            {
                JOptionPane.showMessageDialog(null,"userid or pwd wrong");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    
                 
}
public static void main(String[] args)
{
    new COwnerLogin();
}
}