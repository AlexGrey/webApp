package base;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zver on 23.11.2015.
 */
public class MainServlet extends HttpServlet {
    List<String> users = new ArrayList<String>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter writer = resp.getWriter();
        writer.append(
                "<!DOCTYPE html>" +
                        "<html>" +
                        "<head>" +
                            "<title>Clinic Pets</title>" +
                        "</head>" +
                        "<body>" +
                            "<form action='"+ req.getContextPath() +"/web-app' method='post'>" +
                                "Name: <input type='text' name='name'>" +
                                "<input type='submit' value='Submit'>" +
                            "</form>" +
                        this.view() +
                        "</body>" +
                        "</html>"
        );
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.users.add(req.getParameter("name"));
        doGet(req, resp);
    }

    private String view() {
        StringBuilder res = new StringBuilder();
        if (users.size() == 0) {
            res.append("список клиентов пуст!");
        }
        else {
            for (String user : this.users) {
                res.append("<div>" + user  + "</div>");
            }
        }
        return res.toString();
    }
}
