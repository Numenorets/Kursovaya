package kr;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdminFeedback")
public class AdminFeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminFeedback() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("feedbackList", krdb.FeedbackOutput());
		getServletContext().getRequestDispatcher("/AdminAnswers.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				request.setCharacterEncoding("UTF-8");
				String id = request.getParameter("numberQuestion");
	            String answer = request.getParameter("Answer"); 
	            krdb.addAnswer(id, answer);
	            response.sendRedirect(request.getContextPath()+"/AdminFeedback");
	}

}
