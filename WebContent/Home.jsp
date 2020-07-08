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
            <br>
            <div class="container">
				<form class="form-inline" method="post" action="search.jsp">
				<input type="text" name="roll_no" class="form-control" placeholder="Search roll no..">
				<button type="submit" name="save" class="btn btn-primary">Search</button>
				</form>
			</div>
          </body>
          </html>