package servlets;

import core.impl.ClinicImpl;
import core.impl.UserImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Zver on 24.11.2015.
 */
public class AddUserServlet extends HttpServlet {

    String result = "";
    String userName, petName;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("result", result);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/AddUser.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        userName = req.getParameter("name");
        petName = req.getParameter("pet");
        ClinicImpl.getInstance().addUser(new UserImpl(userName, petName));
        result = "клиент с именем: " + userName + " успешно создан!";
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/users/add"));
    }
}
