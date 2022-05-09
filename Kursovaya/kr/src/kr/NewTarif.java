package kr;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NewTarif")
public class NewTarif extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public NewTarif() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("TarifList", krdb.TarifOutput());
		getServletContext().getRequestDispatcher("/NewTarif.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");   
        String speed = request.getParameter("speed"); 
        String price = request.getParameter("price");
        krdb.insertTarif(name, speed, price);
        response.sendRedirect(request.getContextPath()+"/NewTarif");
	}

}
