package pe.gob.sunat.sivep.web.util;

import javax.servlet.http.HttpServletRequest;

public class WebUtil {

	 private static ThreadLocal<HttpServletRequest> _request = new ThreadLocal<HttpServletRequest>();

	    public static HttpServletRequest getRequest() {
	        return _request.get();
	    }

	    public static void processRequest(HttpServletRequest request) {
	        _request.set(request);
	    }

	    public static void removeAll() {
	        _request.remove();
	    }
	    
}
