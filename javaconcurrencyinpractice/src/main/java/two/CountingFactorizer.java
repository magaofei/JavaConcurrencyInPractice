package two;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicInteger;

public class CountingFactorizer implements Servlet {

    private final AtomicInteger count = new AtomicInteger();

    public long getCount() {
        return count.get();
    }

    public void init(ServletConfig servletConfig) throws ServletException {

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        count.incrementAndGet();
    }
}
