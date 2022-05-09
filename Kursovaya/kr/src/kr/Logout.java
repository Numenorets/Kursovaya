package kr;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.users;

@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Logout() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		users user = new users();
		
		request.getSession().removeAttribute("email");
		request.getSession().removeAttribute("password");
		request.getSession().removeAttribute("role");	
		Cookie[] cookies = request.getCookies();
			String cookieName = "name";
			Cookie cookie = null;
			if(cookies !=null) {
			    for(Cookie c: cookies) {
			        if(cookieName.equals(c.getName())) {
			            c.setMaxAge(0);
			            response.addCookie(c);
			        }
			    }
			}
			response.sendRedirect(request.getContextPath()+"/MainPage.html");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
