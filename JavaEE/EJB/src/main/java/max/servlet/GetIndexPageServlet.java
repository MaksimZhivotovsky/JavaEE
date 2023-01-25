package max.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import max.model.Book;

@WebServlet("/books")
public class GetIndexPageServlet extends HttpServlet {
    private Map<Integer, Book> books;

    @Override
    public void init() throws ServletException {

        final Object books = getServletContext().getAttribute("books");

        if (books == null || !(books instanceof ConcurrentHashMap)) {

            throw new IllegalStateException("You're repo does not initialize!");
        } else {

            this.books = (ConcurrentHashMap<Integer, Book>) books;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("books", books.values());
        req.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(req, resp);
    }
}
