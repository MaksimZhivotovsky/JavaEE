package max.servlet.json;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import max.model.Book;

@WebServlet("/json_data")
public class JsonHandlerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	
        final Book book = new Book(6,"War and Peace","Толстой Л.Н.");
        final String json = new ObjectMapper().writeValueAsString(book);
        resp.getWriter().write(json);
    }
}
