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
  
public class game extends HttpServlet{  
  
    private static final long serialVersionUID = 1L;  
  
    public void doPost(HttpServletRequest request, HttpServletResponse response)    
            throws ServletException, IOException {    
  
        response.setContentType("text/html");    
        PrintWriter out = response.getWriter();    
          
        String r11=request.getParameter("11");    
        String r12=request.getParameter("l2");  
        String r13=request.getParameter("l3");  
        String r21=request.getParameter("21");
        String r22=request.getParameter("22");
        String r23=request.getParameter("23");  
        String r31=request.getParameter("31");
        String r32=request.getParameter("32");
        String r33=request.getParameter("33");  
        
    	HttpSession sess=request.getSession(false);
    	System.out.println(sess.getAttribute("gameid").toString());
  
    	int gameid=Integer.parseInt(sess.getAttribute("gameid").toString());
    	String userid=sess.getAttribute("name").toString();
    	System.out.println(gameid);
    	
    	
    	 boolean status = false;  
		 boolean status2 = false;  
	        Connection conn = null;  
	        PreparedStatement pst = null;
	        PreparedStatement pst1 = null;
	        PreparedStatement pst2 = null;
	        PreparedStatement pst3 = null;
	        ResultSet rs = null;  
	        ResultSet rs1 = null;  
	        ResultSet rs2 = null; 
	  
	        String url = "jdbc:mysql://localhost:3306/";  
	        String dbName = "form";  
	        String driver = "com.mysql.jdbc.Driver";  
	        String userName = "root";  
	        String password = "vivek2132";  
	        try {  
	            Class.forName(driver).newInstance();  
	            conn = DriverManager  
	                    .getConnection(url + dbName, userName, password);  
	            pst=conn.prepareStatement("select * from games where gameid=? and won is null");
	            
	            pst.setInt(1, gameid);
	            rs1=pst.executeQuery();
	            status=rs1.next();
	            
	            if (status)
	            {
	            
	            
	            pst1 = conn  
	                    .prepareStatement("select * from jigs where puzzle=1 and r1=? and r2=? and r3=? and r4=? and r5=? and r6=? and r7=? and r8=? and r9=?");  

	            pst1.setString(1, r11);
	            pst1.setString(2, r12);
	            pst1.setString(3, r13);
	            pst1.setString(4, r21);
	            pst1.setString(5, r22);
	            pst1.setString(6, r23);
	            pst1.setString(7, r31);
	            pst1.setString(8, r32);
	            pst1.setString(9, r33);
	  
	            rs = pst.executeQuery();  
	           
	            status2 = rs.next();
	            if(status2)
	            {
	            	pst2=conn.prepareStatement("Update games set won=?, status=2 where gameid=?");
	            	pst2.setString(1,userid );
	 	            pst2.setInt(2, gameid);
	 	            
	 	            pst2.execute();
	 	            response.sendRedirect("./success.jsp");
	            }
	            else
	            {
	            	pst2=conn.prepareStatement("select userid1, userid2 from games where gameid=?");
	 	            pst2.setInt(1, gameid);
	 	            rs2=pst2.executeQuery();
	 	            if(userid==rs2.getString(1))
	 	            {
	 	            	pst3=conn.prepareStatement("update games set won=?, status=2 where gameid=? ");
	 	            	pst3.setString(1,rs2.getString(2));
	 	            	pst3.setInt(1,gameid);
	 	            	pst3.execute();
	 	            }
	 	            else
	 	            {
	 	            	pst3=conn.prepareStatement("update games set won=? , status=2 where gameid=? ");
	 	            	pst3.setString(1,rs.getString(1));
	 	            	pst3.setInt(1,gameid);
	 	            	pst3.execute();
	 	            }
	 	            response.sendRedirect("./unsuccessful.jsp");
	            }
	            }
	            else
	            {
	            	response.sendRedirect("./results.jsp");
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
	            }   if (pst1 != null) {  
	                try {  
	                    pst1.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }  
	            }   if (pst2 != null) {  
	                try {  
	                    pst2.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }  
	            }   if (pst3 != null) {  
	                try {  
	                    pst3.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }  
	            }   if (rs1 != null) {  
	                try {  
	                    rs1.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }  
	            }   if (rs2 != null) {  
	                try {  
	                    rs2.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	            if (rs != null) {  
	                try {  
	                    rs.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	        }     
  
        out.close();    
    }

	   
}   