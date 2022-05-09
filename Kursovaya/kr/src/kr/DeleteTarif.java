package kr;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/DeleteTarif")
public class DeleteTarif extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteTarif() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("TarifList", krdb.TarifOutput());
		getServletContext().getRequestDispatcher("/DeleteTarif.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");   
        krdb.removeTarif(id);
        response.sendRedirect(request.getContextPath()+"/DeleteTarif");
	}

}
