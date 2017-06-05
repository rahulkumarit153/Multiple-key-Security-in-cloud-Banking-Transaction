
import com.mysql.jdbc.PreparedStatement;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
public class UserHome extends JFrame  implements ActionListener,ItemListener
{
    JPanel jp1,jp2,jp3,jp4,jp5,jp6,jp7,jp8,jp9;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,cl,l11,l12;
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20;
    JRadioButton r1,r2,r3,r4,r5,r6,r7,r8,r9,r10;
    JCheckBox jc1,jc2,jc3,jc4,jc5,jc6,jc7,jc8,jc9,jc10;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    Image img;
    JTextArea jt1;
    byte[]image=null;
    private int i=0;
             private Timer timer;
        private ImageIcon pictures1,pictures2,pictures3,pictures4,pictures5,pictures6,pictures7,pictures8,pictures9,pictures10;
String req="",ano="";
String munm="",mpwd="";
static JTable table;
    //String[] columnNames = {"User name", "Email", "Password", "Country"};
      String[] columnNames = {"Hisory And Activities"};
        DefaultTableModel model = new DefaultTableModel();
    public UserHome(String unm,String pwd) throws SQLException
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
                b1=new JButton(i4);
                cl.add(b1);
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
        l5.setBounds(0,-50,300,708);
        jp3.add(l5);
         jp4.add(l5);
         
         
         
       
        try {  
            Class.forName("com.mysql.jdbc.Driver");
       Connection con=DriverManager.getConnection("jdbc:mysql://34.208.185.11:3306/rahul","newuser","deepak");  
//here sonoo is database name, newuser is username and password  
String query="select * from customer where cid=? and pwd=?";
PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
ps.setString(1,munm);
ps.setString(2,mpwd);
ResultSet rs=ps.executeQuery();
if(rs.next())
{
    ano=rs.getString(1);
    String nm=rs.getString(4);
    String time=rs.getTimestamp(16).toGMTString();
     image= rs.getBytes(14);
     Image img=Toolkit.getDefaultToolkit().createImage(image);
     ImageIcon icon=new ImageIcon(img);
     l1.setIcon(icon);
        
    l2.setText(l2.getText()+ ""+nm);
    l3.setText(l3.getText()+ ""+time);
    
} 
         } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        jp5=new JPanel();
        jp5.setVisible(true);
        jp5.setBounds(300,120,766,648);
         jp5.setLayout(null);
        jp5.setBackground(Color.lightGray);
        jp1.add(jp5);
        
        ImageIcon i2=new ImageIcon("bank.jpg");
                l8=new JLabel(i2);
                jp5.add(l8);
                l8.setBounds(0,0,766,648);
                
       
                b2=new JButton("Change Request");
                l8.add(b2);
                b2.setBounds(0,5,200,30);
                b2.setFont(new Font("Arial",Font.BOLD,20));
                b2.setBackground(Color.GREEN);
                b2.addActionListener(this);
                
                b3=new JButton("Profile");
                l8.add(b3);
                b3.setBounds(200,5,150,30);
                b3.setFont(new Font("Arial",Font.BOLD,20));
                b3.setBackground(Color.GREEN);
                b3.addActionListener(this);
                
                b4=new JButton("Balance Enquiry");
                l8.add(b4);
                b4.setBounds(350,5,200,30);
                b4.setFont(new Font("Arial",Font.BOLD,20));
                b4.setBackground(Color.GREEN);
                b4.addActionListener(this);
                
                b5=new JButton("Fund Transfer");
                l8.add(b5);
                b5.setBounds(550,5,215,30);
                b5.setFont(new Font("Arial",Font.BOLD,20));
                b5.setBackground(Color.GREEN);
                b5.addActionListener(this);
                
                 b6=new JButton("Withdraw");
                l8.add(b6);
                b6.setBounds(0,35,200,30);
                b6.setFont(new Font("Arial",Font.BOLD,20));
                b6.setBackground(Color.GREEN);
                b6.addActionListener(this);
                
                 b10=new JButton("Notification");
                l8.add(b10);
                b10.setBounds(200,35,200,30);
                b10.setFont(new Font("Arial",Font.BOLD,20));
                b10.setBackground(Color.GREEN);
                b10.addActionListener(this);
                
                 b12=new JButton("Latest News");
                l8.add(b12);
                b12.setBounds(400,35,200,30);
                b12.setFont(new Font("Arial",Font.BOLD,20));
                b12.setBackground(Color.GREEN);
                b12.addActionListener(this);
                
                
                
        jp6=new JPanel();
        jp6.setBounds(300,120,766,648);
         jp6.setLayout(null);
        jp6.setBackground(Color.lightGray);
        jp1.add(jp6);
        jp6.setVisible(false);
        
        
        
         l6=new JLabel("Hisory and Activities Of Admins");
        l6.setBounds(100,20,700,40);
         l6.setFont(new Font("Arial",Font.BOLD,25));
           l6.setForeground(Color.orange);
        jp6.add(l6);
        
        
        model.setColumnIdentifiers(columnNames);
//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames());
//table = new JTable(model);
        table = new JTable();
        table.setModel(model);
        table.setBounds(20, 80, 700, 400);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
          table.setFont(new Font("Arial",Font.BOLD,25));
            l6.setForeground(Color.RED);
            table.setRowHeight(20);
       
        jp6.add(table);


         jp7=new JPanel();
        jp7.setBounds(300,120,766,648);
         jp7.setLayout(null);
        jp7.setBackground(Color.lightGray);
        jp1.add(jp7);
        jp7.setVisible(false);
        
        
        
             b11=new JButton("Back To Home");
                jp7.add(b11);
                b11.setBounds(210,580,300,30);
                b11.setFont(new Font("Arial",Font.BOLD,25));
                b11.setBackground(Color.RED);
                b11.addActionListener(this);
           
        
        jt1=new JTextArea();
       jt1.setBounds(0, 25, 780, 560);
       jt1.setBackground(Color.cyan);
       jt1.setForeground(Color.red);
       //jt1.setVisible(false);
       jt1.setEditable(false);
       jp7.add(jt1);
        
       
        
         l7=new JLabel("Notification With Time");
        l7.setBounds(200,-1,700,30);
         l7.setFont(new Font("Arial",Font.BOLD,20));
           l7.setForeground(Color.orange);
        jp7.add(l7);
        
       
         jp8=new JPanel();
        jp8.setBounds(100,300,450,250);
         jp8.setLayout(null);
        jp8.setBackground(Color.white);
        l8.add(jp8);
        jp8.setVisible(false);
        
        
        b7=new JButton("Change Single Record");
                jp8.add(b7);
                b7.setBounds(50,70,300,30);
                b7.setFont(new Font("Arial",Font.BOLD,20));
                b7.setBackground(Color.BLUE);
                b7.addActionListener(this);
                
          b8=new JButton("Change Multi Records");
                jp8.add(b8);
                b8.setBounds(50,175,300,30);
                b8.setFont(new Font("Arial",Font.BOLD,20));
                b8.setBackground(Color.blue);
                b8.addActionListener(this);
        
                jp9=new JPanel();
        jp9.setBounds(300,120,766,648);
         jp9.setLayout(null);
        jp9.setBackground(Color.CYAN);
        jp1.add(jp9);
        jp9.setVisible(false);
        
        ButtonGroup bg=new ButtonGroup();
        r1=new JRadioButton("Change Profile Name");
        jp9.add(r1);
         r1.setBounds(50,100,400,30);
          r1.setBackground(Color.cyan);
                r1.setFont(new Font("Arial",Font.BOLD,20));
                r1.addItemListener(this);
         
          t1=new JTextField("");
       // t1.setEditable(false);
        t1.setBounds(500,100,200,30);
        t1.setFont(new Font("Arial",Font.BOLD,20));
        t1.setForeground(Color.darkGray);
        t1.setBackground(Color.white);
        jp9.add(t1);
        
         r2=new JRadioButton("Change Father Name");
        jp9.add(r2);
         r2.setBounds(50,150,400,30);
         r2.setBackground(Color.cyan);
          
                r2.setFont(new Font("Arial",Font.BOLD,20));
                r2.addItemListener(this);
         
          t2=new JTextField("");
       // t1.setEditable(false);
        t2.setBounds(500,150,200,30);
        t2.setFont(new Font("Arial",Font.BOLD,20));
        t2.setForeground(Color.darkGray);
        t2.setBackground(Color.white);
        jp9.add(t2);
        
        
                bg.add(r1);
                bg.add(r2);
          b9=new JButton("Send Request");
                jp9.add(b9);
                b9.setBounds(300,575,200,30);
                b9.setFont(new Font("Arial",Font.BOLD,20));
                b9.setBackground(Color.blue);
                b9.addActionListener(this);
        
        
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
                String query="update customer set lastactive=?,active=? where cid=? and pwd=?";
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
            jp8.setVisible(true);
            
        }
         else if(ae.getSource()==b3)
        {
            //this.setVisible(false);
            new CustomerProfile(ano);
        }
         else if(ae.getSource()==b4)
        {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://34.208.185.11:3306/rahul","newuser","deepak");
//here sonoo is database name, newuser is username and password
                String query="select * from customer where ano=?";
                PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
                ps.setString(1,ano);
                ResultSet rs=ps.executeQuery();
                if(rs.next())
                {
                    int amt=rs.getInt(11);
                      JOptionPane.showMessageDialog(null,"Your Available Balance Is"+amt);
                
                }           } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserHome.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(UserHome.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         
         else  if(ae.getSource()==b5)
                {
            try {
                String tano=JOptionPane.showInputDialog("Enter A/C No To Transfer Amount :");
                int amt=Integer.parseInt(JOptionPane.showInputDialog("Enter Amount To Transfer :"));
                
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://34.208.185.11:3306/rahul","newuser","deepak");
//here sonoo is database name, newuser is username and password
                String query="select * from customer where ano=?";
                PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
                ps.setString(1,ano);
                ResultSet rs=ps.executeQuery();
                if(rs.next())
                {
                    int aamt=rs.getInt(11);
                    if(amt<=aamt)
                    {
                query="update customer set bal=bal-? where ano=?";
                ps = (PreparedStatement) con.prepareStatement(query);
                ps.setInt(1,amt);
                ps.setString(2,ano);
                int i=ps.executeUpdate();
                query="update customer set bal=bal+? where ano=?";
                ps = (PreparedStatement) con.prepareStatement(query);
                ps.setInt(1,amt);
                ps.setString(2,tano);
                i=ps.executeUpdate();
                if(i>0)
                     JOptionPane.showMessageDialog(null,"Your refund successful !!");
                  
                    }
                    else
                    {
                      JOptionPane.showMessageDialog(null,"Sorry ! You have no sufficient balance in your account");
                  
                    }
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserHome.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(UserHome.class.getName()).log(Level.SEVERE, null, ex);
            }
                }
         
         else  if(ae.getSource()==b6)
                {
            try {
                int amt=Integer.parseInt(JOptionPane.showInputDialog("Enter Amount To Withraw:"));
                
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://34.208.185.11:3306/rahul","newuser","deepak");
//here sonoo is database name, newuser is username and password
                String query="select * from customer where ano=?";
                PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
                ps.setString(1,ano);
                ResultSet rs=ps.executeQuery();
                if(rs.next())
                {
                    int aamt=rs.getInt(11);
                    if(amt<=aamt)
                    {
                query="update customer set bal=bal-? where ano=?";
                ps = (PreparedStatement) con.prepareStatement(query);
                ps.setInt(1,amt);
                ps.setString(2,ano);
                int i=ps.executeUpdate();
                if(i>0)
                     JOptionPane.showMessageDialog(null,"Your transaction is successful !!");
                  
                    }
                    else
                    {
                      JOptionPane.showMessageDialog(null,"Sorry ! You have no sufficient balance in your account");
                  
                    }
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserHome.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(UserHome.class.getName()).log(Level.SEVERE, null, ex);
            }
                }
         else  if(ae.getSource()==b7)
                {
                    jp5.setVisible(false);
                    jp9.setVisible(true);
                    
                }
         else  if(ae.getSource()==b9)
                {
                   try {  
                String code=AESAlgo.encrypt(munm+mpwd);
                String cod[]=new String[4];
                 cod[0]=code.substring(0, 6);
                cod[1]=code.substring(6, 12);
                cod[2]=code.substring(12, 18);
                cod[3]=code.substring(18, 24);
                req+=" " +t1.getText();
                Class.forName("com.mysql.jdbc.Driver");
                 String query="INSERT INTO `request`(`ano`, `msg`, `full`) VALUES (?,?,?)";
                Connection con=DriverManager.getConnection("jdbc:mysql://34.208.185.11:3306/rahul","newuser","deepak");
                PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
                ps.setString(1, ano);
                ps.setString(2, req);
                ps.setString(3, code);
              
                int rs=ps.executeUpdate();
                
                query="select * from admin where 1";
                 PreparedStatement ps1 = (PreparedStatement) con.prepareStatement(query);
                 ResultSet rs1=ps1.executeQuery();
                 int i=0;
                   while(rs1.next())
                   {
                      
                       String eid=rs1.getString(2);
                       query="INSERT INTO `seccode`(`empid`, `code`, `ano`) VALUES(?,?,?)";
                        PreparedStatement ps2 = (PreparedStatement) con.prepareStatement(query);
                        ps2.setString(1, eid);
                        ps2.setString(2, cod[i]);
                        ps2.setString(3, ano);
                        i++;
                        ps2.executeUpdate();    
                   }
                 
                if(rs>0)
                    JOptionPane.showMessageDialog(null,"Your Request has sent successfully !!");
                
                
            } catch (Exception ex) {
                Logger.getLogger(UserHome.class.getName()).log(Level.SEVERE, null, ex);
            }
                   jp8.setVisible(false);
                    jp9.setVisible(false);
                    jp5.setVisible(true);
                    
                }

        else if(ae.getSource()==b3)
        {
                try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://34.208.185.11:3306/rahul","newuser","deepak");
//here sonoo is database name, newuser is username and password
                String query="select * from history order by doh desc";
                PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
                ResultSet rs=ps.executeQuery();
                while(rs.next())
                {
                    String eid=rs.getString(1);
                    String msg=rs.getString(2);
                    String fmsg=msg+" by "+eid;
                    model.addRow(new Object[]{fmsg});
                      }
                    jp5.setVisible(false);
                    jp6.setVisible(true);
              
                } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
            }
                
               
            } 
        else if(ae.getSource()==b10)
        {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://34.208.185.11:3306/rahul","newuser","deepak");
//here sonoo is database name, newuser is username and password
                String query="select * from cnotify order by time desc";
                PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
                ResultSet rs=ps.executeQuery();
                String text="";
                while(rs.next())
                {
                     String msg=rs.getString(1);
                    String tym=rs.getString(2);
                   
                    text+=msg+" At "+tym +" \n";
                    
                }
                jt1.setText(text);
                jp5.setVisible(false);
                jp7.setVisible(true);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserHome.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(UserHome.class.getName()).log(Level.SEVERE, null, ex);
            }
                    
                
        }
        else if(ae.getSource()==b11)
        {
             jp7.setVisible(false);
            jp5.setVisible(true);
           
        }
        else if(ae.getSource()==b12)
        {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://34.208.185.11:3306/rahul","newuser","deepak");
//here sonoo is database name, newuser is username and password
                String query="select * from cnotify order by time desc";
                PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
                ResultSet rs=ps.executeQuery();
                String text="";  
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserHome.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(UserHome.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
         i++;
                if(i==1)
                {
                    pictures1=new ImageIcon("c1.jpg");
                    l4.setIcon(pictures1);l5.setIcon(pictures1);
                }
                if(i==2)
                {
                    pictures2=new ImageIcon("c2.jpg");
                    l4.setIcon(pictures2);l5.setIcon(pictures2);
                }
                if(i==3)
                {
                    pictures3=new ImageIcon("c3.png");
                    l4.setIcon(pictures3);l5.setIcon(pictures3);
                }
                
                if(i==4)
                {
                    pictures4=new ImageIcon("c4.jpg");
                    l4.setIcon(pictures4);l5.setIcon(pictures4);
                }
                if(i==5)
                {
                    pictures5=new ImageIcon("c5.jpg");
                    l4.setIcon(pictures5);l5.setIcon(pictures5);
                }
                if(i==6)
                {
                    pictures6=new ImageIcon("c6.jpg");
                    l4.setIcon(pictures6);l5.setIcon(pictures6);
                }
                if(i==7)
                {
                    pictures7=new ImageIcon("c7.jpg");
                    l4.setIcon(pictures7);l5.setIcon(pictures7);
                }
                if(i==8)
                {
                    pictures8=new ImageIcon("c8.jpg");
                    l4.setIcon(pictures8);l5.setIcon(pictures8);
                }
                if(i==9)
                {
                    pictures9=new ImageIcon("c9.jpg");
                    l4.setIcon(pictures9);l5.setIcon(pictures9);
                }
                if(i==10)
                {
                    pictures10=new ImageIcon("c10.jpg");
                    l4.setIcon(pictures10);l5.setIcon(pictures10);
                }
                if(i==11)
                {
                    //timer.stop();
                    timer.start();
                    i=0;
                }

    }
     public void itemStateChanged(ItemEvent ie)
                {
                    if(ie.getSource()==r1)
                    {
                        
                     req=ano+ " Requested To  "+ r1.getLabel()+"  Existing With ";  
                
                     
                    }
                    if(ie.getSource()==r2)
                    {
                        req=ano+ " Requested To  "+ r2.getLabel()+"  Existing With "; 
                    }
                    
                    
                }
                    
    
    public static void main(String[] args)
    {
        try { 
            String pwd=AESAlgo.encrypt("rahul");
            new UserHome("raja123",pwd);
        } catch (SQLException ex) {
            Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UserHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
