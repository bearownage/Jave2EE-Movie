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
                        <li><a href="<%=request.getContextPath()%>/result" class="nav-link">Home</a></li>
                    </ul>
                </nav>
            </header>
            <br>
            <table class = "table table-bordered table-striped table-hover">                        
            <thead>
                            <tr>
                                <td>${movie.name}</td>
                                <td>${movie.director}></td>
                                <td>${movie.rating}</td>
                                <td>${movie.poster}</td>

                            </tr>
             </thead>
              </table>
            </body>

                        