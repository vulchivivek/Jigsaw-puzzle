package test1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class startgame extends HttpServlet{
	 private static final long serialVersionUID = 1L;  
	  
	    public void doPost(HttpServletRequest request, HttpServletResponse response)    
	            throws ServletException, IOException {
	    	
	    	java.sql.PreparedStatement pst = null;
	    	Connection conn = null;    
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
	            String reqid=request.getParameter("r");  
	            
	            HttpSession session = request.getSession(false);  
	            if(session.getAttribute("gameid")!=null)  
	            session.setAttribute("gameid", reqid);  
	          
	        	HttpSession sess=request.getSession(false);
	        	String userid2=sess.getAttribute("name").toString();  
	        	 
	        	 pst = conn.prepareStatement("update games set userid2=? where gameid=?");  
	     pst.setString(1, userid2);  
	     pst.setString(2, reqid);  
	     
	     
	     
	  
	     rs = pst.execute();  
	     
	     
	     
	  if(!rs)
	  {
		  response.sendRedirect("./testgame.html");
	  }
	  else{
		  response.sendRedirect("./Error.jsp");
	  }
	        } catch (Exception e) {  
	            System.out.println(e);  
	        }
	       
        	
        	
	        

	    }    
}
