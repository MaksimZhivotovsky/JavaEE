package max.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import max.connection.DbCon;
import max.dao.UserDao;
import max.model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.sendRedirect("login.jsp");
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
		
			String email = request.getParameter("login-email");
			String password = request.getParameter("login-password");

			UserDao udao = new UserDao(DbCon.getConnection());
			User user = udao.userLogin(email, password);
			if (user != null) {
				request.getSession().setAttribute("auth", user);
//				System.out.println("user logged in");
				response.sendRedirect("index.jsp");
			} else {
				out.println("there is no user");
			}

		} catch (ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		} 

	}
}