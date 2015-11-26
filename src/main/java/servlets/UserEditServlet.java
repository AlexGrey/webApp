package servlets;

import core.base.User;
import core.impl.ClinicImpl;
import core.impl.PetImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Zver on 24.11.2015.
 */
public class UserEditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = ClinicImpl.getInstance().findByName(req.getParameter("name"));
        if (req.getParameter("command") != null && req.getParameter("command").equals("removePet")  ) {
            user.removePet();
        }
        if (req.getParameter("command") != null && req.getParameter("command").equals("removeUser")  ) {
            ClinicImpl.getInstance().removeUser(user.getId());
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/Index.jsp");
            dispatcher.forward(req, resp);
        } else {
            req.setAttribute("user", user);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/UserEdit.jsp");
            dispatcher.forward(req, resp);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("name");
        User user = ClinicImpl.getInstance().findByName(userName);
        if (req.getParameter("petName") != null && user.getPet() == null) {
            user.addPet(new PetImpl(req.getParameter("petName"), user));
        } else {
            String petName = req.getParameter("petName");
            user.getPet().setName(petName);
        }

        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/users/edit/?name=" + userName));
    }
}
