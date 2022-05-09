package kr;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ChangeTarif")
public class ChangeTarif extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public ChangeTarif() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("TarifList", krdb.TarifOutput());
		getServletContext().getRequestDispatcher("/ChangeTarif.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");   
        String name = request.getParameter("name");   
        String speed = request.getParameter("speed"); 
        String price = request.getParameter("price");
        krdb.updateTarif(id,name, speed, price);
        response.sendRedirect(request.getContextPath()+"/ChangeTarif");
	}

}
