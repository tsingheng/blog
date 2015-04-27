package net.shangtech.blog.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.shangtech.blog.entity.Admin;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AdminInterceptor implements HandlerInterceptor {

	@Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
    }

	@Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {
    }

	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		String uri = request.getRequestURI();
		if("/admin/login".equals(uri)){
			return true;
		}
		Admin admin = (Admin) request.getSession().getAttribute("LOGIN_ADMIN");
		if(admin != null){
			return true;
		}
		response.sendRedirect("/admin/login");
		return false;
    }
	
}
