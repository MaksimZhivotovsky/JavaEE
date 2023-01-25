package max.servlet;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import max.model.Book;
import max.util.Utils;

@WebServlet("/add_book")
public class AddBookServlet extends HttpServlet {

    private Map<Integer, Book> books;

    private AtomicInteger id;

    @Override
    public void init() throws ServletException {

        final Object books = getServletContext().getAttribute("books");

        if (books == null || !(books instanceof ConcurrentHashMap)) {

            throw new IllegalStateException("You're repo does not initialize!");
        } else {

            this.books = (ConcurrentHashMap<Integer, Book>) books;
        }

        id = new AtomicInteger(3);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        if (Utils.requestIsValid(req)) {

            final String title = req.getParameter("title");
            final String author = req.getParameter("author");

            final Book book = new Book();
            final int id = this.id.getAndIncrement();
            book.setId(id);
            book.setTitle(title);
            book.setAuthor(author);

            books.put(id, book);
        }

        resp.sendRedirect(req.getContextPath() + "/books");
    }
}
