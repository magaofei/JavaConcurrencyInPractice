package three;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;

public class VolatileCachedFactorizer implements Servlet {

    private volatile OneValueCache cache = new OneValueCache(null, null);

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    public OneValueCache getCache() {
        return cache;
    }

    @Override
    public void destroy() {

    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        BigInteger i = new BigInteger("1");
        BigInteger[] factors = cache.getFactors(i);
        if (factors == null) {
            factors = factor(i);
            cache = new OneValueCache(i, factors);
        }

        //
    }

    private BigInteger[] factor(BigInteger i) {
        return null;
    }
}
