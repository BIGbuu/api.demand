package api.demand;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author BIG_bu
 */

public class EncodingFilter implements Filter{
    private String encoding = null;
    private boolean active  = false;
    
    private static final Logger logger = 
            Logger.getLogger(EncodingFilter.class.getName());
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) 
            throws IOException, ServletException{            
        if (active) response.setCharacterEncoding(encoding);
        filterChain.doFilter(request, response);
    }
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.encoding = filterConfig.getInitParameter("encoding");
        try {
            Charset testCS = Charset.forName(this.encoding);
            this.active = true;
        } catch (Exception e) {
            this.active = false;
            logger.warning(encoding + " character set not supported ("+e.getMessage()+"). SetCharacterEncodingFilter de-activated.");
        }
    }
    
    @Override
    public void destroy() {
        this.encoding = null;
    }
}
