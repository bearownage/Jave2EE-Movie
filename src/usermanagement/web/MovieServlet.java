package usermanagement.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import usermanagement.dao.MovieDao;

public class MovieServlet {
	private static final long serialVersionUID = 1L;
	private MovieDao movieDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieServlet() {
    	this.movieDao = new MovieDao();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		switch(action) {
		case "/result":
			showResultPage(request, response);
			break;
		}
    }
    
    protected void showResponsePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("Home.jsp");
		dispatcher.forward(request, response);	
	}
    
}
