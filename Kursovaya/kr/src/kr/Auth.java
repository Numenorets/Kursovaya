package kr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Auth")
public class Auth extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Auth() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
			HttpSession session = request.getSession();
		if((session.getAttribute("email")!=null && (session.getAttribute("password")!=null))  && (session.getAttribute("role")!=null))
		{
			users user = new users();
			user = krdb.getUser(session.getAttribute("email").toString(), session.getAttribute("password").toString());
 			Cookie[] cookies = request.getCookies();
 			String cookieName = "name";
 			boolean cookieChanged=false;
 			if(cookies !=null) {
 			    for(Cookie c: cookies) {
 			        if(cookieName.equals(c.getName())) {
 			            c.setValue(user.getName());
 			            c.setMaxAge(24*60*60);
 			            cookieChanged=true;
 			            response.addCookie(c);
 			         }
 			    }
 			}
 			if(cookieChanged==false)
 			{
 				Cookie cookie2 = new Cookie("name",user.getName());
 				cookie2.setMaxAge(24*60*60);
 				response.addCookie(cookie2);
 			}
			if (user.getRole().equals("user"))
			{
				response.sendRedirect(request.getContextPath()+"/UserAccount.jsp");
			}
			else if(user.getRole().equals("admin"))
			{
				response.sendRedirect(request.getContextPath()+"/AdminAccount.jsp");
			}

		}
		else
		{
			response.sendRedirect(request.getContextPath()+"/Authorization.html");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("userEmail");
		String password = request.getParameter("userPassword");
		users user = new users();
		user = krdb.getUser(email, password);
		if(user!=null)
		{		
			request.getSession().setAttribute("email",email );
			request.getSession().setAttribute("password",password);
			request.getSession().setAttribute("role",user.getRole());
 			Cookie[] cookies = request.getCookies();
 			String cookieName = "name";
 			boolean cookieChanged=false;
 			if(cookies !=null) {
 			    for(Cookie c: cookies) {
 			        if(cookieName.equals(c.getName())) {
 			            c.setValue(user.getName());
 			            c.setMaxAge(24*60*60);
 			            cookieChanged=true;
 			            response.addCookie(c);
 			        }
 			    }
 			}
 			if(cookieChanged==false)
 			{
 				Cookie cookie2 = new Cookie("name",user.getName());
 				cookie2.setMaxAge(24*60*60);
 				response.addCookie(cookie2);
 			}
			if (user.getRole().equals("user"))
			{
				response.sendRedirect(request.getContextPath()+"/UserAccount.jsp");
			}
			else if(user.getRole().equals("admin"))
			{
				response.sendRedirect(request.getContextPath()+"/AdminAccount.jsp");
			}
		}
		else
		{
			response.sendRedirect(request.getContextPath()+"/Authorization.html");
		}
	}
}