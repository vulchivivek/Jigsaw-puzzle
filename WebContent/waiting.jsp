<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*" %>

<% Class.forName("com.mysql.jdbc.Driver"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your game id is:  <%=session.getAttribute("gameid")%></title>  
<!-- <meta http-equiv="REFRESH" content="1;url=http://localhost:8081/test1/waiting.jsp"> -->
</head>
<body>



<p>
Waiting for another user to join the game  and game id is 
</p>
   <%
        Connection conn = null; 
        String url = "jdbc:mysql://localhost:3306/";  
        String dbName = "form";  
        String driver = "com.mysql.jdbc.Driver";  
        String userName = "root";  
        String password = "vivek2132";

         Class.forName(driver).newInstance();  
         conn = DriverManager  
        .getConnection(url + dbName, userName, password);
         PreparedStatement pst = null;  
         ResultSet rs = null;  
    %>    
    <%
            try {
	        	String open="1";
	            Class.forName(driver).newInstance();  
	            conn = DriverManager  
	                    .getConnection(url + dbName, userName, password);  
	            HttpSession sess=request.getSession(false);
	            String userid1=sess.getAttribute("name").toString();  
	  
	            pst = conn  
	                    .prepareStatement("select gameid from games where userid1=? and status=1 and userid2 is null");  
	            pst.setString(1, userid1);
	           
	  
	            rs = pst.executeQuery();  
	           
	  			if(rs.next())
	  			{
	  				%>
	  				<script language="javascript">
	  				window.location="http://localhost:8081/test1/waiting.jsp";
	  				</script>
	  				<%
	  			}
	  			else
	  			{
	  				%>
	  				<script language="javascript">
	  				window.location="http://localhost:8081/test1/testgame.html";
	  				</script>
	  				<%
	  			}
	        } 
            catch (Exception e) {  
	            System.out.println(e);  
	        }
            finally
            {
            	conn.close();
            }
            %>
</body>
</html>