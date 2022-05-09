package kr;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/RegUser")
public class RegUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/Registration.html").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		 try {
			 String surname = request.getParameter("surname");
             String name = request.getParameter("name");           
             String adres = request.getParameter("adres");
             String telnumb = request.getParameter("telnumb");
             String email = request.getParameter("email");
             String password = request.getParameter("pass");           
             users users = new users("0",surname,name,adres,email,telnumb,password,"user");
            int rows = krdb.insert(users);
            if(rows!=0)
            {         	 
            	String role = "user";
      			request.getSession().setAttribute("email",email );
      			request.getSession().setAttribute("password",password );
      			request.getSession().setAttribute("role",role);		
      			Cookie[] cookies = request.getCookies();
      			String cookieName = "name";
      			Cookie cookie = null;
      			boolean cookieChanged=false;
      			if(cookies !=null) {
      			    for(Cookie c: cookies) {
      			        if(cookieName.equals(c.getName())) {
      			            c.setValue(name);
      			            c.setMaxAge(24*60*60);
      			            cookieChanged=true;
      			          response.addCookie(c);
      			        }
      			    }
      			}
      			if(cookieChanged==false)
      			{   				
      				Cookie cookie2 = new Cookie("name",users.getName());
      				cookie2.setMaxAge(24*60*60);
      				response.addCookie(cookie2);
      			}
      			if (role.equals("user"))
      			{
      				response.sendRedirect(request.getContextPath()+"/UserAccount.jsp");
      			}
      			else if(role.equals("admin"))
      			{
      				response.sendRedirect(request.getContextPath()+"/AdminAccount.jsp");
      			}
            }
            else
            {
            	response.sendRedirect(request.getContextPath()+"/Registration.html");
            }
         }
         catch(Exception ex) {
              
         }
	}

}
