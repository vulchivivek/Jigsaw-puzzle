package test1;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
  
public class Register extends HttpServlet{  
  
    private static final long serialVersionUID = 1L;  
  
    public void doPost(HttpServletRequest request, HttpServletResponse response)    
            throws ServletException, IOException {    
  
        response.setContentType("text/html");    
        PrintWriter out = response.getWriter();    
        Boolean flag = false;
        String name=request.getParameter("username");    
        String email=request.getParameter("emailid");
        String password=request.getParameter("pass");
        String phone=request.getParameter("phone_no");
        
         
  
        flag = RegisterDao.validate(name, email,password,phone);
        if(flag == true){    
          //  RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");    
            //rd.forward(request,response);    
        	response.sendRedirect("./login.jsp");
        }    
        else{    
          //  out.print("<p style=\"color:red\">Sorry username or password error</p>");    
            //RequestDispatcher rd=request.getRequestDispatcher("login.jsp");    
            //rd.include(request,response);    
        	response.sendRedirect("./Error.jsp");
        }    
  
        out.close();    
    }    
}   