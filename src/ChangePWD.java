import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import javax.swing.JComboBox;
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
public class  ChangePWD extends JFrame implements ActionListener
 {
    JPanel jp1,jp2,jp3,jp4;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
    JTextField t1,t3,t5;
    JPasswordField t2,t6,t7,t4;
    JButton b1,b2,b3,b4;
    String munm="",mpwd="";
     String s4="";Random rnd=new Random();Random rnd1=new Random();
                int rd=0,rd1=0;String unm="",rpwd="";
  JComboBox c1;
public ChangePWD()
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
        l3=new JLabel("Change Password ");
        l3.setBounds(250,10,200,25);
        l3.setFont(f);
        l3.setForeground(Color.ORANGE);
        jp1.add(l3);
         
        l1=new JLabel("ENTER USERID");
        l1.setBounds(250,10,200,25);
        l1.setFont(f);
        l1.setForeground(Color.blue);
        jp2.add(l1);
        
        t1=new JTextField("");
       // t1.setEditable(false);
        t1.setBounds(450,10,200,30);
        t1.setFont(f);
        t1.setForeground(Color.darkGray);
        t1.setBackground(Color.white);
        jp2.add(t1);
        
        
            l11=new JLabel("OLD PASSWORD");
        l11.setBounds(250,55,200,25);
        l11.setFont(f);
        l11.setForeground(Color.blue);
        jp2.add(l11);
   
         t4=new JPasswordField();
         t4.setBounds(450,55,200,30);
        t4.setFont(f);
        t4.setForeground(Color.darkGray);
        t4.setBackground(Color.white);
        jp2.add(t4);
       
        
        l2=new JLabel("NEW PASSWORD");
        l2.setBounds(250,100,200,25);
        l2.setFont(f);
        l2.setForeground(Color.blue);
        jp2.add(l2);
        
        t2=new JPasswordField();
       // t1.setEditable(false);
        t2.setBounds(450,100,200,30);
        t2.setFont(f);
        t2.setForeground(Color.darkGray);
        t2.setBackground(Color.white);
        jp2.add(t2);
        
         l10=new JLabel("CONFIRM PASSWORD");
        l10.setBounds(230,145,220,25);
        l10.setFont(f);
        l10.setForeground(Color.blue);
        jp2.add(l10);
        
        t7=new JPasswordField();
       // t1.setEditable(false);
        t7.setBounds(450,145,200,30);
        t7.setFont(f);
        t7.setForeground(Color.darkGray);
        t7.setBackground(Color.white);
        jp2.add(t7);
        
         ImageIcon im=new ImageIcon("ad1.png");
	l4=new JLabel(im);
	l4.setBounds(-50,0,300,300);
	jp2.add(l4);
        
      
         b2=new JButton("Generate OTP");
       b2.setBounds(300,200,250,30);
	jp2.add(b2);
          b2.addActionListener(this);
          
        jp3=new JPanel();
        jp3.setBounds(500,100,700,400);
        jp3.setBackground(Color.white);
          jp3.setLayout(null);
          jp3.setVisible(false);
        jp4.add(jp3);
        
        
        ImageIcon im1=new ImageIcon("mob.jpg");
	l8=new JLabel(im1);
	l8.setBounds(0,100,330,330);
	jp3.add(l8);
        
        
        l9=new JLabel("ENTER KEY");
        l9.setBounds(120,120,200,25);
        l9.setFont(new Font("Arial",Font.BOLD,12));
        l9.setForeground(Color.BLACK);
        l8.add(l9);
        
        t6=new JPasswordField();
        t6.setBounds(110,160,100,30);
        t6.setFont(f);
        t6.setForeground(Color.darkGray);
        t6.setBackground(Color.white);
        l8.add(t6);
        
        b4=new JButton("verify");
        
        b4.setBounds(120,200,80,30);
        b4.setBackground(Color.red);
         b4.addActionListener(this);
        l8.add(b4);
        
        
     this.invalidate();
this.validate();
this.repaint();
            
        
}
    @Override
    public void actionPerformed(ActionEvent ae)
{
    if(ae.getSource()==b2)
    {
        try {
             unm=t1.getText();
           // String pwd=AESAlgo.encrypt(t2.getText());
             String pwd=t2.getText();
             rpwd=t7.getText();
             String opwd=t4.getText();
             opwd=AESAlgo.encrypt(opwd);
             if(pwd.compareTo(rpwd)==0)
             {
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://34.208.185.11:3306/rahul","newuser","deepak");
            String query="select * from customer where cid=? and pwd=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1, unm);
            ps.setString(2, opwd);
            ResultSet rs=ps.executeQuery();
            
            if(rs.next())
            {
                  rd=rnd.hashCode()%10000;
                  System.out.print(rd);
              MobileSms.sendMsg("Your OTP is "+rd);
               JOptionPane.showMessageDialog(null, "OTP has sent to your registered mobile.. ");
            l4.setVisible(false);
           jp1.setVisible(false);
           jp3.setVisible(true);
       
             }
            else
            {
                JOptionPane.showMessageDialog(null,"userid or old pwd wrong");
            }
             }
             else
            {
              JOptionPane.showMessageDialog(null,"password and confirm does not match ");      
            }
        } catch (ClassNotFoundException | SQLException | HeadlessException ex) {
            Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ChangePWD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }
    
  
     else if(ae.getSource()==b4)
    {
        int otp=Integer.parseInt(t6.getText());
        if(otp==rd)
        {try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://34.208.185.11:3306/rahul","newuser","deepak");
                String query="update customer set pwd=? where cid=?";
                PreparedStatement ps=con.prepareStatement(query);
               rpwd=AESAlgo.encrypt(rpwd);
                ps.setString(1, rpwd);
                 ps.setString(2, unm);
                int i=ps.executeUpdate();
                if(i>0)
                {
                    JOptionPane.showMessageDialog(null, "pwd changed");
                this.setVisible(false);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ForgotPWD.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ForgotPWD.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(ChangePWD.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
                 
}
                
   
public static void main(String[] args)
{
        ChangePWD changePWD;
        changePWD = new ChangePWD();
}

}
