package max.servlet;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import max.model.Book;
import max.util.Utils;
@WebServlet("/update")
public class UpdateBookServlet extends HttpServlet {

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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        final String id = req.getParameter("id");
        final String title = req.getParameter("title");
        final String author = req.getParameter("author");

        final Book book = books.get(Integer.parseInt(id));
        book.setTitle(title);
        book.setAuthor(author);

        resp.sendRedirect(req.getContextPath() + "/books");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        final String id = req.getParameter("id");

        if (Utils.idIsInvalid(id, books)) {
            resp.sendRedirect(req.getContextPath() + "/books");
            return;
        }

        final Book book = books.get(Integer.parseInt(id));
        req.setAttribute("book", book);

        req.getRequestDispatcher("/WEB-INF/view/update.jsp")
                .forward(req, resp);
    }
}
