package max.servlets;

import static max.model.User.ROLE.ADMIN;
import static max.model.User.ROLE.USER;

import java.util.concurrent.atomic.AtomicReference;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import max.dao.UserDAO;
import max.model.User;

/**
 * ContextListener put user dao to servlet context.
 */
@WebListener
public class ContextListener implements ServletContextListener {
    /**
     * Fake database connector.
     */
    private AtomicReference<UserDAO> dao;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        dao = new AtomicReference<>(new UserDAO());

        dao.get().add(new User(1, "a", "1", ADMIN));
        dao.get().add(new User(2, "u", "1", USER));

        final ServletContext servletContext =
                servletContextEvent.getServletContext();

        servletContext.setAttribute("dao", dao);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        dao = null;
    }
}
