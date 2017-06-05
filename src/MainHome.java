
import com.mysql.jdbc.PreparedStatement;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
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
public class MainHome extends JFrame  implements ActionListener 
{
    JPanel jp1,jp2,jp3,jp4,jp5,jp6,jp7,jp8,jp9;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,cl,l11,l12;
    JButton b1,b2,b3,b4,b5,b6,b7,b8;
    JTextArea jt1;
    Image img;
    byte[]image=null;
    private int i=0;
             private Timer timer;
        private ImageIcon pictures1,pictures2,pictures3,pictures4,pictures5,pictures6,pictures7,pictures8,pictures9,pictures10;

String munm="",mpwd="";
static JTable table;
    //String[] columnNames = {"User name", "Email", "Password", "Country"};
      String[] columnNames = {"ID/AC No","IP ADDress","MAC Address","Login Time"};
        DefaultTableModel model = new DefaultTableModel();
    public MainHome(String unm,String pwd) throws SQLException
    {
       munm=unm;
       mpwd=pwd;

         setSize(1366,769);
        setLayout(null);
       // this.pack();
        jp1=new JPanel();
        jp1.setBounds(0,0,1366,768);
         jp1.setLayout(null);
        jp1.setBackground(Color.red);
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
                b1=new JButton(i4); cl.add(b1);
                b1.setBounds(970,0,269,75);
                b1.setFont(new Font("Arial",Font.BOLD,25));
                b1.setBackground(Color.red);
                b1.addActionListener(this);
                
        
                
        jp3=new JPanel();
        jp3.setBounds(0,120,300,700);
         jp3.setLayout(null);
        jp3.setBackground(Color.yellow);
        jp1.add(jp3);
        
        l4=new JLabel();
        l4.setBounds(0,-50,300,700);
        jp3.add(l4);
        
        jp4=new JPanel();
        jp4.setBounds(1066,120,300,700);
         jp4.setLayout(null);
        jp4.setBackground(Color.yellow);
        jp1.add(jp4);
        
       
        
         l5=new JLabel();
        l5.setBounds(0,-50,300,700);
        jp3.add(l5);
         jp4.add(l5);
         
         
         
       
        try {  
            Class.forName("com.mysql.jdbc.Driver");
       Connection con=DriverManager.getConnection("jdbc:mysql://34.208.185.11:3306/rahul","newuser","deepak");  
//here sonoo is database name, newuser is username and password  
String query="select * from manager where userid=? and pwd=?";
PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
ps.setString(1,munm);
ps.setString(2,mpwd);

ResultSet rs=ps.executeQuery();
if(rs.next())
{
    String nm=rs.getString(5);
    String time=rs.getString(4);
     image= rs.getBytes(3);
     Image img=Toolkit.getDefaultToolkit().createImage(image);
     ImageIcon icon=new ImageIcon(img);
     l1.setIcon(icon);
        
    l2.setText(l2.getText()+ ""+nm);
    l3.setText(l3.getText()+ ""+time);
    
} 
         } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        jp5=new JPanel();
        jp5.setBounds(300,120,766,648);
         jp5.setLayout(null);
        jp5.setBackground(Color.white);
        jp1.add(jp5);
        
         ImageIcon i2=new ImageIcon("manager3.jpg");
                l8=new JLabel(i2);
                jp5.add(l8);
                l8.setBounds(0,-50,766,700);
                
     
        
                b2=new JButton("Activities and Hisory");
                l8.add(b2);
                b2.setBounds(210,50,300,30);
                b2.setFont(new Font("Arial",Font.BOLD,25));
                b2.setBackground(Color.GREEN);
                b2.addActionListener(this);
                
                 jp6=new JPanel();
        jp6.setBounds(300,120,766,648);
         jp6.setLayout(null);
        jp6.setBackground(Color.blue);
        jp1.add(jp6);
        jp6.setVisible(false);
        
                b6=new JButton("Back To Home");
                jp6.add(b6);
                b6.setBounds(210,590,300,30);
                b6.setFont(new Font("Arial",Font.BOLD,25));
                b6.setBackground(Color.RED);
                b6.addActionListener(this);
                
        
         l6=new JLabel("");
        l6.setBounds(200,-1,700,30);
         l6.setFont(new Font("Arial",Font.BOLD,20));
           l6.setForeground(Color.orange);
           //l6.setVisible(false);
        jp6.add(l6);
        
        
        model.setColumnIdentifiers(columnNames);
//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames());
//table = new JTable(model);
        table = new JTable();
        table.setModel(model);
        table.setBounds(0, 25, 780, 560);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
          table.setFont(new Font("Arial",Font.PLAIN,20));
            l6.setForeground(Color.RED);
            table.setRowHeight(20);
           table.setBackground(Color.CYAN);
       table.setVisible(false);
        jp6.add(table);

         jp8=new JPanel();
        jp8.setBounds(300,120,766,648);
         jp8.setLayout(null);
        jp8.setBackground(Color.lightGray);
        jp1.add(jp8);
        jp8.setVisible(false);
        
             b7=new JButton("Back To Home");
                jp8.add(b7);
                b7.setBounds(210,590,300,30);
                b7.setFont(new Font("Arial",Font.BOLD,25));
                b7.setBackground(Color.RED);
                b7.addActionListener(this);
           
        
        jt1=new JTextArea();
       jt1.setBounds(0, 25, 780, 560);
       jt1.setBackground(Color.cyan);
       jt1.setForeground(Color.red);
       jt1.setVisible(false);
       jt1.setEditable(false);
       jp8.add(jt1);
        
       
       l9=new JLabel("");
        l9.setBounds(200,-1,700,30);
         l9.setFont(new Font("Arial",Font.BOLD,20));
           l9.setForeground(Color.orange);
           //l6.setVisible(false);
        jp8.add(l9);
         
       
                b3=new JButton("Admin Requests");
               l8.add(b3);
                b3.setBounds(0,80,230,30);
                b3.setFont(new Font("Arial",Font.BOLD,25));
                b3.setBackground(Color.GREEN);
                b3.addActionListener(this);
                
                 b4=new JButton("Create Admin");
               l8.add(b4);
                b4.setBounds(0,50,200,30);
                b4.setFont(new Font("Arial",Font.BOLD,25));
                b4.setBackground(Color.GREEN);
                b4.addActionListener(this);
                
                  b5=new JButton("Tracking System");
               l8.add(b5);
                b5.setBounds(510,50,260,30);
                b5.setFont(new Font("Arial",Font.BOLD,25));
                b5.setBackground(Color.GREEN);
                b5.addActionListener(this);
 
 
         jp7=new JPanel();
        jp7.setBounds(300,120,766,648);
         jp7.setLayout(null);
        jp7.setBackground(Color.lightGray);
        jp1.add(jp7);
        jp7.setVisible(false);
        
        
        
         l7=new JLabel("Admin Requests");
        l7.setBounds(100,20,700,40);
         l7.setFont(new Font("Arial",Font.BOLD,25));
           l7.setForeground(Color.orange);
        jp7.add(l7);
        
        b8=new JButton("Back To Home");
                jp7.add(b8);
                b8.setBounds(210,590,300,30);
                b8.setFont(new Font("Arial",Font.BOLD,25));
                b8.setBackground(Color.RED);
                b8.addActionListener(this);
        this.setVisible(true);
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
        System.out.println(tm);
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://34.208.185.11:3306/rahul","newuser","deepak");
//here sonoo is database name, newuser is username and password
                String query="update manager set lastactive=?,active=? where userid=? and pwd=?";
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
            } catch (Exception ex) {
                Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(ae.getSource()==b2)
        {
                try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://34.208.185.11:3306/rahul","newuser","deepak");
//here sonoo is database name, newuser is username and password
                String query="select * from history order by doh desc";
                PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
                ResultSet rs=ps.executeQuery();
                 String text="";
                while(rs.next())
                {
                    String eid=rs.getString(1);
                    String msg=rs.getString(2);
                    String fmsg=msg+" by "+eid;
                  //  model.addRow(new Object[]{fmsg});
                   
                    text+=fmsg+"\n";
                      }
                l9.setText("History and activities of Admin");
                    jp5.setVisible(false);
                    jt1.setText(text);
                    jt1.setVisible(true);
                    jp8.setVisible(true);
              
                } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                else if(ae.getSource()==b3)
                {
                    jp5.setVisible(false);
                    jp7.setVisible(true);
                    
                }
                else  if(ae.getSource()==b4)
                {
                    this.setVisible(false);
                    new AdminRegister();
                }
                 
         else  if(ae.getSource()==b5)
                {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://34.208.185.11:3306/rahul","newuser","deepak");
//here sonoo is database name, newuser is username and password
                String query="select * from track order by time desc";
                PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
                ResultSet rs=ps.executeQuery();
                 
                 model.addRow(columnNames);
                while(rs.next())
                {
                    String eid=rs.getString(1);
                    String ip=rs.getString(2);
                    String mac=rs.getString(3);
                    String tym=rs.getString(4);
                   
                    model.addRow(new Object[]{eid,ip,mac,tym});
                }
                jp5.setVisible(false);
                l6.setText("Global Tracking of Systems");
                table.setVisible(true);
                jp6.setVisible(true);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
            }
              
                }
               else  if(ae.getSource()==b6)
               {
                   jp6.setVisible(false);
           jp5.setVisible(true);
                }
                else  if(ae.getSource()==b7)
               {
                   jp8.setVisible(false);
           jp5.setVisible(true);
                }
              else  if(ae.getSource()==b8)
               {
                   jp7.setVisible(false);
           jp5.setVisible(true);
                }
             
         i++;
                if(i==1)
                {
                    pictures1=new ImageIcon("m1.jpg");
                    l4.setIcon(pictures1);l5.setIcon(pictures1);
                }
                if(i==2)
                {
                    pictures2=new ImageIcon("m2.jpg");
                    l4.setIcon(pictures2);l5.setIcon(pictures2);
                }
                if(i==3)
                {
                    pictures3=new ImageIcon("m3.jpg");
                    l4.setIcon(pictures3);l5.setIcon(pictures3);
                }
                
                if(i==4)
                {
                    pictures4=new ImageIcon("m4.jpg");
                    l4.setIcon(pictures4);l5.setIcon(pictures4);
                }
                if(i==5)
                {
                    pictures5=new ImageIcon("m5.jpg");
                    l4.setIcon(pictures5);l5.setIcon(pictures5);
                }
                if(i==6)
                {
                    pictures6=new ImageIcon("m6.jpg");
                    l4.setIcon(pictures6);l5.setIcon(pictures6);
                }
                if(i==7)
                {
                    pictures7=new ImageIcon("m7.jpg");
                    l4.setIcon(pictures7);l5.setIcon(pictures7);
                }
                if(i==8)
                {
                    pictures8=new ImageIcon("m8.jpg");
                    l4.setIcon(pictures8);l5.setIcon(pictures8);
                }
                if(i==9)
                {
                    pictures9=new ImageIcon("m9.png");
                    l4.setIcon(pictures9);l5.setIcon(pictures9);
                }
                if(i==10)
                {
                    pictures10=new ImageIcon("m10.png");
                    l4.setIcon(pictures10);l5.setIcon(pictures10);
                }
                if(i==11)
                {
                    //timer.stop();
                    timer.start();
                    i=0;
                }

    }
    
    public static void main(String[] args)
    {
        try { 
            new MainHome("rahul123",AESAlgo.encrypt("rahul"));
        } catch (SQLException ex) {
            Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
