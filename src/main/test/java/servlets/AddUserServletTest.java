package servlets;

import core.impl.ClinicImpl;
import core.impl.UserImpl;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.Assert.*;

/**
 * Created by Zver on 27.11.2015.
 */
public class AddUserServletTest extends Mockito {
    HttpServletResponse response = mock(HttpServletResponse.class);
    HttpServletRequest request = mock(HttpServletRequest.class);


    @Test
    public void testDoGet() throws Exception {
        String result = "";
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);

        when(request.getRequestDispatcher("/views/AddUser.jsp")).thenReturn(dispatcher);
        when(request.getPathInfo()).thenReturn("/users/add");

        new AddUserServlet().doGet(request, response);
        verify(dispatcher).forward(request,response);
        verify(request).setAttribute("result", result);
    }

    @Test
    public void testDoPost() throws Exception {
        final ClinicImpl clinic = ClinicImpl.getInstance();
        when(request.getParameter("name")).thenReturn("john");
        when(request.getParameter("pet")).thenReturn("sharik");

        new AddUserServlet().doPost(request, response);
        verify(request, atLeast(1)).getParameter("name");
        verify(request, atLeast(1)).getParameter("pet");

        clinic.removeUser(clinic.findByName("john").getId());
    }
}