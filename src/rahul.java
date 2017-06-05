/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rahul
 */
//package sql;
import java.sql.*;

/**
 * JdbcInsert1.java - Demonstrates how to INSERT data into an SQL
 *                    database using Java JDBC.
 */
/*public class rahul { 
  
    public static void main (String[] args) { 
        try { 
            
            String url = "jdbc:mysql://172.31.14.63:3306/rahul"; 
            Connection conn = DriverManager.getConnection(url,"newuser","rahul"); 
          
            //Statement st = conn.createStatement(); 
            String query="select * from track where 1";
           PreparedStatement st=conn.prepareStatement(query);
           
            ResultSet rs=st.executeQuery();
            while(rs.next())
            {
                System.out.println(rs.getString(1));
            }
            
            
            conn.close(); 
        } catch (Exception e) { 
            System.err.println("Got an exception! "); 
            System.err.println(e.getMessage()); 
        } 
    }
}
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class rahul { 
	  
		  
	    public static void main (String[] args) { 
	        try { 
	           /* String url = "jdbc:mysql://52.27.52.156:3306/rahul"; 
	            Connection conn = DriverManager.getConnection(url,"newuser","deepak"); 
	            Statement st = (Statement) conn.createStatement(); 
	           
	           54.245.207.37
	            st.executeUpdate("INSERT INTO tab " + 
	                "VALUES ('rajat')"); */
	             Class.forName("com.mysql.jdbc.Driver");
                     String url = "jdbc:mysql://54.245.207.37:3306/shik"; 
	            Connection conn = DriverManager.getConnection(url,"shikha","kumari"); 
	            Statement st = (Statement) conn.createStatement(); 
	           
	           
	            st.executeUpdate("INSERT INTO bank " + 
	                "VALUES ('rajat')"); 
	            
	            
	            conn.close(); 
	        } catch (Exception e) { 
	            System.err.println("Got an exception! "); 
	            System.err.println(e.getMessage()); 
	        } 
	    }
	}

