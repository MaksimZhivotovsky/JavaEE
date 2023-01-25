package max.servlet.json;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import max.model.Book;

/**
 * Json example:
 * {"id":6,"title":"Война и Мир","author":"Толстой Л.Н."}
 */
@WebServlet("/json")
public class JsonFormServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	
    	req.setCharacterEncoding("UTF-8");
    	
        req.getRequestDispatcher("/WEB-INF/view/json_example.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    	req.setCharacterEncoding("UTF-8");
    	
        final String data = req.getParameter("data");
        final Book book = new ObjectMapper().readValue(data, Book.class);

        logBook(book);
    }

    private void logBook(final Book book) {
        System.out.println();
        System.out.println();
        System.out.println("************************************************");
        System.out.println("******* User unmarshalling : " + book +" *******");
        System.out.println("************************************************");
        System.out.println("        Id   : " + book.getId());
        System.out.println("        Title : " + book.getTitle());
        System.out.println("        Author  : " + book.getAuthor());
        System.out.println("************************************************");
    }
}