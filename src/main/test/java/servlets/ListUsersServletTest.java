package servlets;

import core.impl.ClinicImpl;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.Assert.*;

/**
 * Created by Zver on 28.11.2015.
 */
public class ListUsersServletTest extends Mockito {

    @Test
    public void testDoGet() throws Exception {
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpServletRequest request = mock(HttpServletRequest.class);
        final ClinicImpl clinic = ClinicImpl.getInstance();

        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        when(request.getRequestDispatcher("/views/ListUsers.jsp")).thenReturn(dispatcher);

        new  ListUsersServlet().doGet(request, response);
        verify(dispatcher, atLeast(1)).forward(request, response);


    }
}