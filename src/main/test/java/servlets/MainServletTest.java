package servlets;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.cglib.proxy.Dispatcher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.Assert.*;

/**
 * Created by Zver on 26.11.2015.
 */
public class MainServletTest extends Mockito {

    @Test
    public void testDoGet() throws Exception, ServletException, NullPointerException {
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpServletRequest request = mock(HttpServletRequest.class);

        when(request.getRequestDispatcher("/views/Index.jsp")).thenReturn(dispatcher);
        when(request.getPathInfo()).thenReturn("/");

        new MainServlet().doGet(request, response);
        verify(dispatcher).forward(request,response);
    }

}