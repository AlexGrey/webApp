package servlets;

import core.base.User;
import core.impl.ClinicImpl;
import core.impl.UserImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.Assert.*;

/**
 * Created by Zver on 27.11.2015.
 */
public class UserEditServletTest extends Mockito {
    HttpServletResponse response = mock(HttpServletResponse.class);
    HttpServletRequest request = mock(HttpServletRequest.class);
    final ClinicImpl clinic = ClinicImpl.getInstance();
    User user;
    RequestDispatcher dispatcher;
    ClinicImpl clinicMock;

    @Before
    public void addUser() {
        user = new UserImpl("john", "pet");
        clinic.addUser(user);
        dispatcher = mock(RequestDispatcher.class);
        clinicMock = mock(ClinicImpl.class);
        when(request.getParameter("name")).thenReturn("john");
        when(clinicMock.findByName(request.getParameter("name"))).thenReturn(user);
    }

    /**
     * проверка вызова команды removeUser
     * @throws Exception
     */
    @Test
    public void testDoGetRemoveUser() throws Exception {
        when(request.getParameter("command")).thenReturn("removeUser");
        when(request.getRequestDispatcher("/views/Index.jsp")).thenReturn(dispatcher);

        new UserEditServlet().doGet(request, response);

        verify(request, atLeast(1)).getParameter("command");
        assertEquals(request.getParameter("command"), "removeUser");
        verify(dispatcher, atLeast(1)).forward(request, response);
    }

    /**
     * проверка вызова команды removePet
     * @throws Exception
     */
    @Test
    public void testDoGetRemovePet() throws Exception {
        when(request.getParameter("command")).thenReturn("removePet");
        when(request.getRequestDispatcher("/views/UserEdit.jsp")).thenReturn(dispatcher);

        new UserEditServlet().doGet(request, response);

        verify(request, atLeast(1)).getParameter("command");
        assertEquals(request.getParameter("command"), "removePet");
        verify(dispatcher, atLeast(1)).forward(request, response);
    }

    @Test
    public void testDoPost() throws Exception {
        User mockUser = mock(UserImpl.class);
        when(request.getParameter("petName")).thenReturn("pet");
        when(mockUser.getPet()).thenReturn(null);
        new UserEditServlet().doPost(request, response);
        verify(request, atLeast(1)).getParameter("petName");
        assertEquals(mockUser.getPet(),null);
    }
}