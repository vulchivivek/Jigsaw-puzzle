package test1;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class RegisterDao {
	
	public static boolean validate(String name, String email, String pass, String phone ) {          
        boolean status = false;  
        Connection conn = null;  
        PreparedStatement pst = null;  
        Boolean rs = null;  
        
        
        
  
        String url = "jdbc:mysql://localhost:3306/";  
        String dbName = "form";  
        String driver = "com.mysql.jdbc.Driver";  
        String userName = "root";  
        String password = "vivek2132";  
        try {  
            Class.forName(driver).newInstance();  
            conn = DriverManager  
                    .getConnection(url + dbName, userName, password);  
  
            pst = conn  
                    .prepareStatement("insert into login (username,password,emailid,phone) values "
                    		+ " (?,?,?,?)");  
            pst.setString(1, name); 
            pst.setString(2, pass);
            pst.setString(3, email);
            pst.setString(4, phone);  
  
            if(!pst.execute()){
            	status = true;
            	return status;
            }  
            return status;
  
        }
        catch(SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException se)
        {
        	se.printStackTrace();
        }finally {  
            if (conn != null) {  
                try {  
                    conn.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }  
            if (pst != null) {  
                try {  
                    pst.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }  
         
        }  
        return status; 
        }
        
}
