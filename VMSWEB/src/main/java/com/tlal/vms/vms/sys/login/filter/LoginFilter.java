package com.tlal.vms.vms.sys.login.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tlal.vms.base.sysparam.ConstantsIHandler;
import com.tlal.vms.vms.sys.login.entity.User;

/**
 * 项目名称：VMSWEB
 * 类描述：登陆过滤器
 * 作者：chenhuaijie
 * 时间：2016-04-12 10：20
 */
public class LoginFilter extends HttpServlet implements Filter{
	private static final long serialVersionUID = 8641439521312698391L;
	private Logger logger = LoggerFactory.getLogger(getClass());
	private static List<String> urls = new ArrayList<String>();//不拦截这些请求

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
      urls.add("/VMSWEB/");
	}

	/**
	 * 过滤实现
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;  
        HttpServletResponse response = (HttpServletResponse) resp;  
        HttpSession session = request.getSession(true);  
        String url = request.getRequestURI();  //获取访问路径url
        if(url.endsWith(".html")){
        	User user = (User) session.getAttribute(ConstantsIHandler.LOGIN_USER); 
        	if(user!=null){//用户已登录 不拦截任何请求
            	chain.doFilter(request, response);  
            }else{
            	boolean doFilter = false;//默认不拦截
            	if(urls!=null&&urls.size()>0){
            		for(String str:urls){
                		if(url.equals(str)){//请求不路径与集合里的路径匹配
                			doFilter = true;
                			break;
                		}
                	}
            	}
            	if(doFilter){
            		chain.doFilter(request, response);
            	}else{
            		String location = "login/toLogin.html";  
        	        request.getRequestDispatcher(location).forward(request, response);  
        	        logger.info("成功拦截到外星人企图入侵网站后台   :  " + url);  
        	        response.setHeader("Cache-Control", "no-store");  
        	        response.setDateHeader("Expires", 0);  
        	        response.setHeader("Pragma", "no-cache");  
            	}
            }
        }else{
        	chain.doFilter(request, response);  
        }
	}
}
