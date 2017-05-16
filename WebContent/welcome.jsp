<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>Welcome <%=session.getAttribute("name")%></title>  
</head>  
<body>  
    <h3>Login successful!!!</h3>  
    <h4>  
        Hello,  
        <%=session.getAttribute("name")%>
        </h4>  
    <form action="gameServlet" method="post">
     Game1: <input type="checkbox" name="game1" value="D:\apache-tomcat-8.0.33\Myapp\test1\WebContent\Images\jigsawpuzzle1.jpg"><br>
	Game2:<input type="checkbox" name="game1" value="D:\apache-tomcat-8.0.33\Myapp\test1\WebContent\Images\download2.jpg"><br>

  <input type="hidden" name="userid" value="abcd">
  
	<img  src="D:\apache-tomcat-8.0.33\Myapp\test1\WebContent\Images\download1.jpg">     
	   
        <input type="submit" value="Start a new game">     
        
    </form>
    
     
        
        <input type="submit" value="Join a game" onclick="redir();">     
        <script type="text/javascript">
        function redir(){
        window.location="http://localhost:8081/test1/JoinGame.jsp";
        }
        </script>
    
</body>  
</html> 