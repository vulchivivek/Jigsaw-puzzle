<%@ page import="java.sql.*" %>

<% Class.forName("com.mysql.jdbc.Driver"); %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result</title>
</head>
<body>
<p>The user 
  <% 
        Connection conn = null; 
        String url = "jdbc:mysql://localhost:3306/";  
        String dbName = "form";  
        String driver = "com.mysql.jdbc.Driver";  
        String userName = "root";  
        String password = "vivek2132";
        ResultSet rs=null;
        
        PreparedStatement pst = null;

         Class.forName(driver).newInstance();  
         conn = DriverManager  
        .getConnection(url + dbName, userName, password);

            pst=conn.prepareStatement("select won from games where gameid=?");
            String gameid=session.getAttribute("gameid").toString();
            pst.setString(1, gameid);
            rs=pst.executeQuery();
            
            while(rs.next())
            {
            	String Winer=rs.getString(1);
            	System.out.println(Winer);
            }
            
        %>
         won the game </p>
         
<a href="welcome.jsp">Start a new game</a>
</body>
</html>