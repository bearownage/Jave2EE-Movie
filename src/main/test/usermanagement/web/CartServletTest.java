package usermanagement.web;



import usermanagement.web.CartServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
<<<<<<< HEAD
/*
=======


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


>>>>>>> 8883ee59e14d289c36b21fed72e85ea6eef82b93
public class CartServletTest {
    @Mock private HttpServletRequest request;
    @Mock private HttpServletResponse response;
    @Mock private RequestDispatcher requestDispatcher;
	
    @InjectMock 
    private CartServlet cartServlet;
	
    // Initialize all the Mocked objects before the tests starts.
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void doGet() throws Exception {
    	StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        
        System.out.println(request + " " + response);
        
        request.getServletPath();
        new CartServlet().doGet(request, response);
        
        assertEquals("Random", stringWriter.toString());
    }
    
    
}
*/