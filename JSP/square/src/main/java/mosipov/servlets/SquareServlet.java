package mosipov.servlets;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import mosipov.servlets.DBConnect;


/**
 * Created by mosipov on 14.09.2017.
 */

public class SquareServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DBConnect dbconn  = new DBConnect();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.getRequestDispatcher("WEB-INF/Views/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String name = (String) req.getSession().getAttribute("UserNameString").toString();
        if (name == null){
                name = "Anonymous";
        }

        String squareColor = (String) req.getParameter("color");

        if (squareColor == null) {
            squareColor = "NoColor";
        }

        //System.err.println(String.format(" Р—Р°Р»РѕРіРёРЅРёР»СЃСЏ РїРѕР»СЊР·РѕРІР°С‚РµР»СЊ - %s,  РІС‹Р±СЂР°Р» С†РІРµС‚ - %s", name, squareColor));

        req.setAttribute("color",squareColor);

        dbconn.writeDB(name,squareColor);

        req.getRequestDispatcher("WEB-INF/Views/index.jsp").forward(req,resp);


    }
}
