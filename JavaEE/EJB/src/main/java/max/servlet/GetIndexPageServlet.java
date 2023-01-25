package max.servlet;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import max.model.Book;

@WebServlet("/books")
public class GetIndexPageServlet extends HttpServlet {

    private final static String index = "/WEB-INF/view/index.jsp";

    private List<Book> books;

    @Override
    public void init() throws ServletException {
    	books = new CopyOnWriteArrayList<>();
    	books.add(new Book("Мертвые души", "Гоголь Н.В."));
    	books.add(new Book("Идиот", "Достоевский Ф.М."));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("books", books);
        req.getRequestDispatcher(index).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF8");

        if (!requestIsValid(req)) {
            doGet(req, resp);
        }

        final String title = req.getParameter("title");
        final String author = req.getParameter("author");

        final Book book = new Book(title, author);
//        final Book book = new Book(name, Integer.valueOf(age));

        books.add(book);

        doGet(req, resp);
    }

    private boolean requestIsValid(final HttpServletRequest req) {

        final String title = req.getParameter("title");
        final String author = req.getParameter("author");

        return title != null && title.length() > 0 &&
                author != null && author.length() > 0; //&&
//                age.matches("[+]?\\d+");
    }
}
