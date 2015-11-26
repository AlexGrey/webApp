package servlets;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.cglib.proxy.Dispatcher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.Assert.*;

/**
 * Created by Zver on 26.11.2015.
 */
public class MainServletTest extends Mockito {

    @Test
    public void testDoGet() throws Exception, ServletException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);

        when(req.getParameter("login")).thenReturn("test");

        new MainServlet().doGet(req, resp);

        verify(req, atLeast(1)).getParameter("login");
    }



}