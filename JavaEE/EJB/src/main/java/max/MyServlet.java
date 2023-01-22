package max;

import java.io.IOException;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/hello")
public class MyServlet extends HttpServlet {

	@EJB
//	@Inject
	private HelloWorld helloWorld = new HelloWorld();
	
	@Override
	protected void doGet(HttpServletRequest reg, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write(helloWorld.helloWorld());
	}
}
