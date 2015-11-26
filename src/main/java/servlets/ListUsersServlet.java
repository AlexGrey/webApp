package servlets;

import core.impl.ClinicImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Zver on 24.11.2015.
 */
public class ListUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", ClinicImpl.getInstance().getUsers());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/ListUsers.jsp");
        dispatcher.forward(req, resp);
    }
}
