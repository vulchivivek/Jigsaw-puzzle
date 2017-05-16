package test1;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
  
public class LoginServlet extends HttpServlet{  
  
    private static final long serialVersionUID = 1L;  
  
    public void doPost(HttpServletRequest request, HttpServletResponse response)    
            throws ServletException, IOException {    
  
        response.setContentType("text/html");    
        PrintWriter out = response.getWriter();    
          
        String n=request.getParameter("username");    
        String p=request.getParameter("userpass");   
          
        HttpSession session = request.getSession(false);  
        if(session!=null)  
        session.setAttribute("name", n);     
        //session.setAttribute("gameid", "5");
  
        if(LoginDao.validate(n, p)){    
          //  RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");    
            //rd.forward(request,response);    
        	response.sendRedirect("./welcome.jsp");
        }    
        else{    
          //  out.print("<p style=\"color:red\">Sorry username or password error</p>");    
            //RequestDispatcher rd=request.getRequestDispatcher("login.jsp");    
            //rd.include(request,response);    
        	response.sendRedirect("./login.jsp");
        }    
  
        out.close();    
    }    
}   