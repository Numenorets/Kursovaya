package kr;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.krdb;

@WebServlet("/AddUserTarif")
public class AddUserTarif extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AddUserTarif() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        String idTarif = request.getParameter("id");
        String userEmail = request.getParameter("userEmail");
        String userPassword = request.getParameter("userPassword");
        krdb.insertUserTarif(idTarif,krdb.getUser(userEmail, userPassword).getID());
        response.sendRedirect(request.getContextPath()+"/UserAccount.jsp");
	}

}
