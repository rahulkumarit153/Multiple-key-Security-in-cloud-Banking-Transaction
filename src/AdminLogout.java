
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rahul
 */
public class AdminLogout extends JFrame {
    JLabel l1,l2;
    
    public AdminLogout()
    {
        setSize(700,500);
        setVisible(true);
        setLayout(null);
        this.setLocation(500, 200);
        this.setTitle("Logout Window");
       setBackground(Color.white);
       
        ImageIcon i5=new ImageIcon("logout.jpg");
                l1=new JLabel(i5);
                this.add(l1);
                l1.setBounds(50,0,410,350);
                
                
               l2=new JLabel("You have successfully logout !!!");
                l2.setBounds(50,360,610,70);
                l2.setForeground(Color.red);
                l2.setFont(new Font("Arial",Font.BOLD,30));
                 this.add(l2);
                 
       
    }
    public static void main(String[] args)
    {
        new AdminLogout();
    }
    
}
