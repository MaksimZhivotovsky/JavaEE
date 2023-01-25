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

@WebServlet("/delete")
public class DeleteBookServlet extends HttpServlet {

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

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        if (Utils.idIsNumber(req)) {
            books.remove(Integer.valueOf(req.getParameter("id")));
        }

        resp.sendRedirect(req.getContextPath() + "/books");
    }
}
