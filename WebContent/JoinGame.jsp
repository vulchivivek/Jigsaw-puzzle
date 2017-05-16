<%@ page import="java.sql.*" %>

<% Class.forName("com.mysql.jdbc.Driver"); %>

<HTML>
    <HEAD>
<title>Hi <%=session.getAttribute("name")%>, SELECT GAME</title>  
    </HEAD>

    <BODY>
        <H1>Select Game</H1>
        
        <form id="theForm" action="startgame" method="post">  

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

            Statement statement = conn.createStatement() ;
            ResultSet resultset = statement.executeQuery("select * from games where userid2 is null") ; 
        %>

        <TABLE BORDER="1" id="table1">
            <TR>
                <TH>Game ID</TH>
                <TH>Select</TH>
            </TR>
            <%
           
            while(resultset.next())
            	
            { 
            %>
           
            <TR>
                <TD name="gid"> <%= resultset.getString(1) %> </td>
                <TD> <input type="radio" name="selectedgame" /></TD>
            </TR>
            
            <% } 
            conn.close();
            %>
        </TABLE>
        
        <input type="text" name="r"/>
        <input type="button" value="Submit "onclick="Redirect(r)">
        
        
        
        
        <script type="text/javascript">
        function Redirect(r)
        {
        	

        	var test = document.getElementsByName('selectedgame');
        	var gameId = document.getElementsByName('gid');
        	var isChecked = false;
        	var reqid=null;
        	
        	for(var i=0; i<test.length;i++){
        		
        		if(test[i].checked){
        			isChecked = true;
        			reqid=gameId[i].innerHTML;
        		}
        		if(isChecked){
        			r.value= reqid;
         			break;
        		}
        	}
        	
        	document.getElementById('theForm').submit();

        }
        </script> 
        
        </form>
        
        
    </BODY>
</HTML>