package net.shangtech.blog.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class StartUpListener implements ServletContextListener {

	private ServletContext sc;
	
	@Override
    public void contextDestroyed(ServletContextEvent event) {
	    
    }

	@Override
    public void contextInitialized(ServletContextEvent event) {
	    sc = event.getServletContext();
	    
	    sc.setAttribute("ctx", sc.getContextPath());
	    sc.setAttribute("keywords", "keywords.default");
	    sc.setAttribute("description", "description.default");
	    sc.setAttribute("title", "title.default");
    }

}
