<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Movie Application</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a class="navbar-brand"> Movie App </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/home" class="nav-link">Home</a></li>
                    </ul>
                </nav>
            </header>
			<h3>Login Form</h3>  
			<%  
			String profile_msg=(String)request.getAttribute("profile_msg");  
			if(profile_msg!=null){  
			out.print(profile_msg);  
			}  
			String login_msg=(String)request.getAttribute("login_msg");  
			if(login_msg!=null){  
			out.print(login_msg);  
			}  
			 %>  
			 <br/>  
			<form action="loginprocess.jsp" method="post">  
			Email:<input type="text" name="email"/><br/><br/>  
			Password:<input type="password" name="password"/><br/><br/>  
			<input type="submit" value="login"/>"  
			</form> 
			
			</body>
          </html> 
