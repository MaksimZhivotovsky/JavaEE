package max.servlet.http_session;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter("/session")
public class EncodingFilter implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req,
                         ServletResponse resp,
                         FilterChain chain)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        chain.doFilter(req, resp);
    }

}
