package mosipov.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by mmx on 26.12.2017.
 */
public class LoginServlet extends HttpServlet {
    public LoginServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);

        HttpSession session = req.getSession(true);
        String name = (String) req.getParameter("name");

        if (name == null){
                name = "Anonymous";
        }

        session.setAttribute("UserNameString", name);

        req.setAttribute("color","000000");

        req.getRequestDispatcher("WEB-INF/Views/index.jsp").forward(req,resp);



    }
}
