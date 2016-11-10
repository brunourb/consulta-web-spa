package pe.gob.sunat.sivep.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pe.gob.sunat.sivep.web.util.WebUtil;


@WebFilter(filterName = "requestFilter", urlPatterns = { "/*" })
public class RequestFilterServlet extends HttpServlet implements Filter {
	
	private Logger logger = LoggerFactory.getLogger(RequestFilterServlet.class);

	private static final long serialVersionUID = 1L;

	public static ServletContext servletContext = null;

	public void init(FilterConfig filterConfig) throws ServletException {
		servletContext = filterConfig.getServletContext();
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
	    String uri = ((HttpServletRequest)request).getRequestURI();
	    long start = System.currentTimeMillis();
	    logger.debug("doFilter start ---> " + uri);
	    
        if(!uri.endsWith(".srv")) {
            WebUtil.removeAll();
            WebUtil.processRequest((HttpServletRequest) request);
            chain.doFilter(request, response);
            WebUtil.removeAll();
        } else {
            chain.doFilter(request, response);
        }
        logger.debug("doFilter end ---> " + uri + "; time=" + (System.currentTimeMillis() - start));
	}

}
