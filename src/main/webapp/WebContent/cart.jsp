<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Cart Application</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    		<style><%@include file="/WEB-INF/css/style.css"%></style>
    		<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css"> !-->
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark bg-dark">
                    <div>
                        <a class="navbar-brand"> Cart App </a>
                    </div>

                    <ul class="navbar-nav ">
                        <li><a href="<%=request.getContextPath()%>/cart" class="nav-link">Display All Listings</a></li>
                    </ul>
                </nav>
            </header>
            <br>
            
            <div class="row">
            	<div class="col=md-4 offset-md-1">
            		<h3>Search Area</h3>
            	</div>
            	<div class="col-md-4 offset-md-2">
            		<form class="form-inline" method="get" action="">
            		 <div class="input-group-prepend">
    					<span class="input-group-text" id="basic-addon1?">Search here:</span>
  					</div>
						<input type="text" class="form-control" id = "search bar" name = "q" placeholder="Search for a particular item">
						  <div class="input-group-append">
						  	 <input type ="submit" class ="btn btn-primary" value = "Search">
						  </div>
							
					</form>
            	</div>
            	
			  
			</div>
			  

            <div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container">
                    <h3 class="text-center">List of Items For Purchase</h3>
                    <hr>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Image</th>
                                <th>Price</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="item" items="${listItem}">
	                            <div class="card" style="width: 17rem;">
								  <img src=<c:out value = "${item.image}"/> class="card-img-top" alt="...">
								  <div class="card-body">
								    <h5 class="card-title"><c:out value="${item.name}"/></h5>
								    <p class="card-text">Insert movie description</p>
								    <form action = "<%=request.getContextPath()%>/cart" method="post">
	                                    	<input class="btn btn-success" type = "submit" value = "Add to cart" />
	                                    	<input type = "hidden" name = "id" value="<c:out value='${item.id}'/>" />
	                                </form>
	                                <a class="btn btn-danger" href="delete?id=<c:out value='${item.price}' />">Delete From Cart</a></td>
								  </div>
								</div>
                            <!--  
                                <tr>
                                    <td>
                                        <c:out value="${item.name}" />
                                    </td>
                                    <td>
                                        <img height="200px" width="200px" src=<c:out value = "${item.image}"/> > 
                                    </td>
                                    <td>
                                        <c:out value="${item.price}" />
                                    </td>
                                    <td>
                                    <form action = "<%=request.getContextPath()%>/cart" method="post">
                                    	<input class="btn btn-success" type = "submit" value = "Add to cart" />
                                    	<input type = "hidden" name = "id" value="<c:out value='${item.id}'/>" />
                                    </form>
                                    -->
                                    	 <!-- &nbsp;&nbsp;&nbsp;&nbsp; <c:out value='${item.id}'/> --> 
                                <!-- </tr> -->
                            </c:forEach>
                        </tbody>

                    </table>
                </div>
                    <div class="container text-left">
                    	<!-- <a href="#" class="btn btn-info btn-lg">
          					<span class="glyphicon glyphicon-shopping-cart"></span> Shopping Cart
        				</a> -->
                    	<a href="<%=request.getContextPath()%>/checkout" class="btn btn-primary">Go To Checkout</a>
                    </div>
            </div>
        </body>

        </html>
