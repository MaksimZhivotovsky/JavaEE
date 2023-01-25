package max.util;

import javax.servlet.http.HttpServletRequest;

import max.model.Book;

import java.util.Map;

public class Utils {

    public static boolean idIsNumber(HttpServletRequest request) {
        final String id = request.getParameter("id");
        return id != null &&
                (id.length() > 0) &&
                id.matches("[+]?\\d+");
    }

    public static boolean requestIsValid(HttpServletRequest request) {
        final String title = request.getParameter("title");
        final String author = request.getParameter("author");

        return title != null && title.length() > 0 &&
                author != null && author.length() > 0;
    }

    public static Book createStubBook(final int id,
                                      final String title,
                                      final String author) {
        Book book = new Book();
        book.setId(id);
        book.setTitle(title);
        book.setAuthor(author);
        return book;
    }

    public static boolean idIsInvalid(final String id, Map<Integer, Book> repo) {
        return !(id != null &&
                id.matches("[+]?\\d+") &&
                repo.get(Integer.parseInt(id)) != null);
    }
}
