<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<script>
function validate() {
    var result = null;
    var username = document.forms["regform"]["name"].value;
    var emailid = document.forms["regform"]["emailid"].value;
    
    var phone_no = document.forms["regform"]["phoneno"].value;
    var pwd = document.forms["regform"]["pwd"].value;
    var cpwd = document.forms["regform"]["cpwd"].value;        
   
    var user = /^[A-Z,a-z]+$/;
    var email = /^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/;
    var phone = /^(\+\d{1,2}\s)?\(?\d{3}\)?[\s.-]\d{3}[\s.-]\d{4}$/;  
    var pass = /^(?=.*[A-Z].*[A-Z])(?=.*[!@#$&*])(?=.*[0-9].*[0-9])(?=.*[a-z].*[a-z].*[a-z]).+$/;
        if (username==null || username=="") {
        alert("Name missing");
        return false;
    }
    else
    {
    result = username.match(user); 
     if (result==null || result=="") {
        alert("Name should have only charcters and full name is required(First and Last)");
        return false;
    }
    else
    {
        if (emailid == null || emailid == "") {
        alert("Email ID missing");
        return false;
    }
    else
    {
    result = emailid.match(email); 
     if (result==null || result=="") {
        alert("Email should be of the form abc@xyz.com");
        return false;
    }    
    else
    {
        if (phone_no==null || phone_no=="") {
        alert("Phone number missing");
        return false;
        
        }
        else
    {
    result = phone_no.match(phone); 
     if (result==null || result=="") {
        alert("Phone number can have only numbers and of the format 123-456-7890 OR (123) 456-7890 OR 123 456 7890 OR 123.456.7890 OR +1 (123) 456-7890");
        return false;
    }    
    else
    {
        if (pwd==null || pwd=="") {
        alert("Password missing");
        return false;
        
        }
        else
        {
            if (cpwd==null || cpwd=="") {
        alert("Please confirm your password");
        return false;
        
        }
        else
        {
            if (cpwd != pwd) {
        alert("Passwords do not match!");
        return false;
        
        }
        else
        {
    result = pwd.match(pass); 
     if (result==null || result=="") {
        alert("Password should follow the below given requirements");
        return false;
    }        
            
        }
            
        }
        }
            
        }
    }
                        
    }
    }
    
    }
    }
return true;            
}
</script>
</head>
<body>
    <center>
<div>
  <form name ="regform" action="./Register" onsubmit="return validate()" method="post" >
      
      Your name   <center>  <input name="username" type="text" id="name" maxlength="15" required="required"  /><br><br></center>
      Email ID     <center> <input name="emailid" type="text" id="emailid" maxlength="25" required="required" /><br><br></center>
      Password <center>     <input name="pass" type="password" id="pwd" maxlength="15" required="required" /><br><br></center>
      Confirm Password <center>     <input name="confirmpassword" type="password" id="cpwd" maxlength="15" required="required"  /><br><br></center>
	  Phone Number  <center>      <input name="phone_no" type="text" id="phoneno" maxlength="15" required="required"  /><br><br></center>
   
    <input type="submit" value="Register" /><br><br>
    
    <tr> <td colspan="2" ><b>Requirements for password:</b>
                 <br><br>
                 1) Must have one uppercase letter
             <br></br>
                  2) Must have at least 1 digit
             <br></br>
                  3) Must have one lowercase letter
             <br></br>
                  4) Length of the password must be greater than or equal to 6
             
             </td></tr>
    
  </form>
</div>
</center>
</body>
</html>