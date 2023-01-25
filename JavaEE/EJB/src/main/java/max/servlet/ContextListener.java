package max.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import max.model.Book;
import max.util.Utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebListener
public class ContextListener implements ServletContextListener {

    private Map<Integer, Book> books;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        final ServletContext servletContext =
                servletContextEvent.getServletContext();

        books = new ConcurrentHashMap<>();

        servletContext.setAttribute("books", books);

        final Book book1 = Utils.createStubBook(1, "Мертвые души", "Гоголь Н.В.");
        final Book book2 = Utils.createStubBook(2, "Идиот", "Достоевский Ф.М.");
        this.books.put(book1.getId(), book1);
        this.books.put(book2.getId(), book2);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //Close recourse.
        books = null;
    }
}
