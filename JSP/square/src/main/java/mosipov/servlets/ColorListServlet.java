package mosipov.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;



public class ColorListServlet extends HttpServlet {


	DBConnect dbconn = new DBConnect();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.getRequestDispatcher("WEB-INF/Views/login.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        List<UserVisitBean> lst = dbconn.getUserColorListFromDB();

        req.setAttribute("usersList",lst);
        req.getRequestDispatcher("WEB-INF/Views/ColorList.jsp").forward(req, resp);


    }
}