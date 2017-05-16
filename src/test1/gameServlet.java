package test1;

import java.io.IOException;  
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;  
  
public class gameServlet extends HttpServlet{  
	
  
    private static final long serialVersionUID = 1L;  
  
    public void doPost(HttpServletRequest request, HttpServletResponse response)    
            throws ServletException, IOException {
    	
    	HttpSession sess=request.getSession(false);

  
        response.setContentType("text/html");    
        PrintWriter out = response.getWriter();  
        
        String link=request.getParameter("game1");    
        String userid1=sess.getAttribute("name").toString();  
         

        Connection conn = null;  
        PreparedStatement pst = null;
        PreparedStatement pst2 = null; 
        ResultSet rs2= null;
        String gameid = null;
       String url = "jdbc:mysql://localhost:3306/";  
        String dbName = "form";  
        String driver = "com.mysql.jdbc.Driver";  
        String userName = "root";  
        String password = "vivek2132";  
        try {
        	//String open="1";
            Class.forName(driver).newInstance();  
            conn = DriverManager  
                    .getConnection(url + dbName, userName, password);  
            
            pst = conn  
                    .prepareStatement("insert into games (userid1,status,link) values (?,?,?)");  
            pst.setString(1, userid1);  
            pst.setInt(2, 1);
            pst.setString(3,link);
  
            pst.execute();  
            Thread.sleep(500);
            pst2 = conn  
                    .prepareStatement("select gameid from games where userid1= ? and status=1 and won is null");  
            pst2.setString(1, userid1);  
           // pst2.setInt(2, 1);
            
           rs2= pst2.executeQuery();
           
            
           while(rs2.next()){
            	System.out.println("vadadas" +rs2.getString(1));
            gameid=rs2.getString(1);
          System.out.println(  rs2.getInt(1));
            
            }
            
           
            
  
        } catch (Exception e) {  
            System.out.println(e);  
        } finally {  
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
    	
    	System.out.println(gameid);
    	
    	response.sendRedirect("./waiting.jsp");
    	
        //response.sendRedirect("./testgame.html");
        
        out.close();    
    }    
}   