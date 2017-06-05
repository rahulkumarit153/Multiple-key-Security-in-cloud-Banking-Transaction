
import com.mysql.jdbc.PreparedStatement;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;
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
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
public class AdminHome extends JFrame  implements ActionListener 
{
    JPanel jp1,jp2,jp3,jp4,jp5,jp6,jp7,jp8,jp9;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,cl,l11,l12;
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
    Image img;
    JTextArea jt1;
    byte[]image=null;
    private int i=0;
             private Timer timer;
        private ImageIcon pictures1,pictures2,pictures3,pictures4,pictures5,pictures6,pictures7,pictures8,pictures9,pictures10;
String path="",newpath="";
String munm="",mpwd="";
static JTable table,table1;
    String[] columnNames1 = {"A/C No", "User Requests", "Action"};
      String[] columnNames = {"Hisory And Activities"};
        DefaultTableModel  model= new DefaultTableModel();
        DefaultTableModel  model1= new DefaultTableModel();
        byte[] userpdf;
    public AdminHome(String unm,String pwd) throws SQLException
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
        jp2.setBackground(new Color(135,206,235));
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
                
                ImageIcon i3=new ImageIcon("admin4.png");
                l9=new JLabel(i3);
               cl.add(l9);
                l9.setBounds(0,18,253,100);
               
                
                l2=new JLabel("Welcome Mr/Mrs. ");
                cl.add(l2);
                l2.setBounds(260,90,520,30);
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
                 b1.addActionListener(this);
                
        
                
        jp3=new JPanel();
        jp3.setBounds(0,120,300,700);
         jp3.setLayout(null);
        jp3.setBackground(Color.yellow);
        jp1.add(jp3);
        
        l4=new JLabel();
        l4.setBounds(0,-40,300,700);
        jp3.add(l4);
        
        jp4=new JPanel();
        jp4.setBounds(1066,120,300,700);
         jp4.setLayout(null);
        jp4.setBackground(Color.yellow);
        jp1.add(jp4);
        
       
        
         l5=new JLabel();
        l5.setBounds(0,-40,300,700);
        jp3.add(l5);
         jp4.add(l5);
         
         
         
       
        try {  
            Class.forName("com.mysql.jdbc.Driver");
       Connection con=DriverManager.getConnection("jdbc:mysql://34.208.185.11:3306/rahul","newuser","deepak");  
//here sonoo is database name, newuser is username and password  
String query="select * from admin where empid=? and pwd=?";
PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
ps.setString(1,munm);
ps.setString(2,mpwd);
ResultSet rs=ps.executeQuery();
 
if(rs.next())
{
    //System.out.print("nm+time");
    String nm=rs.getString(3);
    String time=rs.getTimestamp(9).toString();
     image= rs.getBytes(10);
     Image img=Toolkit.getDefaultToolkit().createImage(image);
     ImageIcon icon=new ImageIcon(img);
     l1.setIcon(icon);
       
    l2.setText(l2.getText()+ ""+nm);
    l3.setText(l3.getText()+ ""+time);
    
} 
        
        
        
        jp5=new JPanel();
        jp5.setBounds(300,120,766,648);
         jp5.setLayout(null);
        jp5.setBackground(Color.white);
        jp1.add(jp5);
        
        ImageIcon i2=new ImageIcon("adminpage2.jpg");
         l8=new JLabel(i2);
         jp5.add(l8);
         l8.setBounds(0,-50,766,700);
                
     
        
                b2=new JButton("Create New Customer Account");
                l8.add(b2);
                b2.setBounds(200,80,450,30);
                b2.setFont(new Font("Arial",Font.BOLD,25));
                b2.setBackground(Color.GREEN);
                b2.addActionListener(this);
                
               
       
                
                b3=new JButton("User Requests");
                l8.add(b3);
                b3.setBounds(200,130,450,30);
                b3.setFont(new Font("Arial",Font.BOLD,25));
                b3.setBackground(Color.GREEN);
                b3.addActionListener(this);
                
         jp7=new JPanel();
        jp7.setBounds(300,120,766,648);
         jp7.setLayout(null);
        jp7.setBackground(Color.lightGray);
        jp1.add(jp7);
        jp7.setVisible(false);
        
        
        
         l7=new JLabel("USER RQUESTS");
        l7.setBounds(100,20,700,40);
         l7.setFont(new Font("Arial",Font.BOLD,25));
           l7.setForeground(Color.orange);
        jp7.add(l7);
        
         
         l10=new JLabel("User Requests");
        l10.setBounds(20,120,500,40);
         l10.setFont(new Font("Arial",Font.BOLD,12));
           l10.setForeground(Color.orange);
        jp7.add(l10);
        
        b5=new JButton("Key Veify ");
                jp7.add(b5);
                b5.setBounds(550,120,150,30);
                b5.setFont(new Font("Arial",Font.BOLD,15));
                b5.setBackground(Color.red);
                b5.addActionListener(this);
        b6=new JButton("Proceed ");
                jp7.add(b6);
               b6.setBounds(550,120,150,30);
                b6.setFont(new Font("Arial",Font.BOLD,15));
                b6.setBackground(Color.red);
                b6.addActionListener(this);
                b6.setVisible(false);
        
        query="select * from  seccode where empid=? and ano=?";
                        PreparedStatement ps1 = (PreparedStatement) con.prepareStatement(query);
                        ps1.setString(1, munm);
                        ps1.setString(2, "12345678");
                        ResultSet rs1=ps1.executeQuery();
                        if(rs1.next())
                        {
                            String vcode=rs1.getString(5);
                            if((vcode.trim()).compareTo("no")==0)
                            {
                                         }
                            else
                            {
                                b5.setVisible(false);
                                b6.setVisible(true);  
                 
                            }
                            
                        }
                         } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
        }
         model1.setColumnIdentifiers(columnNames1);
        table1 = new JTable();
        table1.setModel(model1);
        table1.setBounds(0, 80, 780, 400);
        table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table1.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table1);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
          table1.setFont(new Font("Arial",Font.BOLD,25));
            //l6.setForeground(Color.RED);
            table1.setRowHeight(25);
       
        jp7.add(table1);

       
           b8=new JButton("Back To Home");
                jp7.add(b8);
                b8.setBounds(210,570,300,30);
                b8.setFont(new Font("Arial",Font.BOLD,25));
                b8.setBackground(Color.RED);
                b8.addActionListener(this);
            b9=new JButton("Deposit");
                l8.add(b9);
                b9.setBounds(20,605,200,30);
                b9.setFont(new Font("Arial",Font.BOLD,25));
                b9.setBackground(Color.MAGENTA);
                b9.addActionListener(this);
           
        b10=new JButton("Upload Info");
                l8.add(b10);
                b10.setBounds(220,605,200,30);
                b10.setFont(new Font("Arial",Font.BOLD,25));
                b10.setBackground(Color.MAGENTA);
                b10.addActionListener(this);
           
        
                
                
        
        b4=new JButton("History and Activity ");
                l8.add(b4);
                b4.setBounds(200,190,450,30);
                b4.setFont(new Font("Arial",Font.BOLD,25));
                b4.setBackground(Color.GREEN);
                b4.addActionListener(this);
        
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
        table = new JTable();
        table.setModel(model);
        table.setBounds(20, 80, 700, 400);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll1 = new JScrollPane(table);
        scroll1.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll1.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
          table.setFont(new Font("Arial",Font.BOLD,25));
            l6.setForeground(Color.RED);
            table.setRowHeight(20);
       
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
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://34.208.185.11:3306/rahul","newuser","deepak");
                String query="update admin set lastactive=?,active=? where empid=? and pwd=?";
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
            
            this.setVisible(false);
            new UserRegister(munm,mpwd);
        }
        else if(ae.getSource()==b3)
        {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://34.208.185.11:3306/rahul","newuser","deepak");
//here sonoo is database name, newuser is username and password
                String query="select * from request where flag=0 order by time desc";
                PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
                ResultSet rs=ps.executeQuery();
                if(rs.next())
                {
                    String aco=rs.getString(1);
                    String msg=rs.getString(2);
                    l10.setText(msg);
                    jp5.setVisible(false);
                    jp7.setVisible(true);
                    // new UserRegister(munm,mpwd);
                }
                else
                JOptionPane.showMessageDialog(null, "NO Reuest");
            } catch (SQLException ex) {
                Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
                
                else if(ae.getSource()==b4)
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
         else if(ae.getSource()==b5)
                {
                String pwd= JOptionPane.showInputDialog("Please input Password ");
                System.out.println("hhh");
                if(pwd.compareTo(mpwd)==0)
                {System.out.println("hhh");
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con=DriverManager.getConnection("jdbc:mysql://34.208.185.11:3306/rahul","newuser","deepak");
//here sonoo is database name, newuser is username and password
                        String query="select * from  seccode where empid=? and ano=?";
                        PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
                        ps.setString(1, munm);
                        ps.setString(2, "12345678");
                        ResultSet rs=ps.executeQuery();
                        if(rs.next())
                        {
                            String code=rs.getString(2);
                            JOptionPane.showMessageDialog(null,"Your verify code is:"+code);
                              String cod= JOptionPane.showInputDialog("Please input verify code ");
                              if(code.compareTo(cod)==0)
                              {
                                query="update seccode set vcode=? where empid=? and ano=? ";
                        PreparedStatement ps1 = (PreparedStatement) con.prepareStatement(query);
                        ps1.setString(1, cod);
                        ps1.setString(2, munm);
                        ps1.setString(3, "12345678");
                        int i=ps1.executeUpdate();
                        if(i>0)
                        {
                           JOptionPane.showMessageDialog(null,"Ok");
                           b5.setVisible(false);
                           b6.setVisible(true);
                           
                        }
                              }
                              else
                                   JOptionPane.showMessageDialog(null,"code mismatch");
                       
                              
                        }
                        else
                            JOptionPane.showMessageDialog(null,"password mismatch");
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(AdminHome.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(AdminHome.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                }
         else if(ae.getSource()==b6)
                {
            try {
                String fcode="",code="";
               
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://34.208.185.11:3306/rahul","newuser","deepak");
                String query1="select * from request where 1";
                PreparedStatement ps = (PreparedStatement) con.prepareStatement(query1);
                ResultSet rs=ps.executeQuery();
                if(rs.next())
                {
                    fcode=rs.getString(3);
                }
                
                
                String query="select * from admin where 1";
                 ps = (PreparedStatement) con.prepareStatement(query);
                 rs=ps.executeQuery();
                while(rs.next())
                {
                    String eid=rs.getString(2);
                    query="select * from seccode where empid=? and ano=? ";
                    PreparedStatement ps1 = (PreparedStatement) con.prepareStatement(query);
                    ps1.setString(1, eid);
                    ps1.setString(2, "12345678");
                    ResultSet rs1=ps1.executeQuery();
                    if(rs1.next())
                    {
                      code+=rs1.getString(5);
                       //JOptionPane.showMessageDialog(null,code+" "+fcode);
                    }
                    
                                    }
                if((fcode.trim()).compareTo(code.trim())==0)
                {
                           JOptionPane.showMessageDialog(null,"Granted !!!!!!");
                           new UpdateCust("12345678");
                    
                }
                else
                {
                  JOptionPane.showMessageDialog(null,"Something wrong or some admin didn't grant permission !!!!");  
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AdminHome.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(AdminHome.class.getName()).log(Level.SEVERE, null, ex);
            }
              
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
        
          else  if(ae.getSource()==b9)
               {
                   try
                   {
                    String ano=JOptionPane.showInputDialog("Enter A/C No for Deposit :");    
                 int amt=Integer.parseInt(JOptionPane.showInputDialog("Enter Amount To Deposit:"));
                
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://34.208.185.11:3306/rahul","newuser","deepak");
//here sonoo is database name, newuser is username and password
                String  query="update customer set bal=bal+? where ano=?";
                PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
                ps.setInt(1,amt);
                ps.setString(2,ano);
                int i=ps.executeUpdate();
                String msg=munm +"Deposited Rs."+amt+ "in account  no "+ano;
                query="insert into history(empid,msg) values (?,?)";
                 ps = (PreparedStatement) con.prepareStatement(query);
                ps.setString(1,munm);
                ps.setString(2,msg);
                 i=ps.executeUpdate();
                
                
                if(i>0)
                     JOptionPane.showMessageDialog(null,"Your transaction is successful !!");
                  
                    
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserHome.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(UserHome.class.getName()).log(Level.SEVERE, null, ex);
            }
             
               }
                   
        else  if(ae.getSource()==b10)
               {
                   JFileChooser chooser = new JFileChooser();
                   
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename = f.getAbsolutePath();
        path = filename;
         newpath = path.replace('\\', '/');
         
         JOptionPane.showInputDialog("You selected "+newpath);
         
         try{
        File newpdf = new File(newpath);
        FileInputStream fis = new FileInputStream(newpdf);
        ByteArrayOutputStream baos= new ByteArrayOutputStream();
        byte[] buff = new byte[2048000];
        for(int readNum; (readNum=fis.read(buff)) !=-1 ; ){
            baos.write(buff,0,readNum);
        }

        userpdf=baos.toByteArray();
            Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://34.208.185.11:3306/rahul","newuser","deepak");
//here sonoo is database name, newuser is username and password
                String  query="Insert into  inform(info) values(?)";
                PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
               // byte[] pdfData = new byte[(int) userpdf.length()];
                ps.setBytes(1,userpdf);
                int i=ps.executeUpdate();
                String msg=munm +" Uploaded one Information file ";
                query="insert into history(empid,msg) values (?,?)";
                 ps = (PreparedStatement) con.prepareStatement(query);
                ps.setString(1,munm);
                ps.setString(2,msg);
                 i=ps.executeUpdate();
          if(i>0)      
         JOptionPane.showMessageDialog(null,"You have successfully uploaded file");
             Blob blob = null;
          query="select * from inform where 1";
          ps = (PreparedStatement) con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
          if(rs.next())
          {
            blob=rs.getBlob(1);
          }
          byte[] b=null;
           if (blob != null) 
               b=blob.getBytes((long)1, (int)blob.length());
                
            JOptionPane.showMessageDialog(null,b.toString());

    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
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
           String pwd= AESAlgo.encrypt("6AK323X5");
            new AdminHome("emp101",pwd);
        } catch (SQLException ex) {
            Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AdminHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
/*
 query="select * from  seccode where empid=? and ano=?";
                        PreparedStatement ps1 = (PreparedStatement) con.prepareStatement(query);
                        ps1.setString(1, munm);
                        ps1.setString(2, aco);
                        ResultSet rs1=ps1.executeQuery();
                        if(rs1.next())
                        {
                            String vcode=rs1.getString(5);
                            if((vcode.trim()).compareTo("no")==0)
                            {
                                    model1.addRow(new Object[]{aco,msg,b5});     
                            }
                            else
                            {
                               // b5.setVisible(false);
                                //b6.setVisible(true);  
                  model1.addRow(new Object[]{aco,msg,b6});
                            }
                            
                        }
       
*/