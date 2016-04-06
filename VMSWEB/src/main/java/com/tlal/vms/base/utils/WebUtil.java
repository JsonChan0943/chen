package com.tlal.vms.base.utils;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class WebUtil {
	/**
	 * 后台向后台转发action请求
	 * @param forwardUrl
	 */
	public static void dispatcherForward(String forwardUrl){
		ServletContext servletContext = ServletActionContext.getServletContext();
		if(servletContext==null||forwardUrl.equals("")){
			return;
		}
		try {
			servletContext.getRequestDispatcher(forwardUrl).forward(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取当前对话的HttpServletRequest
	 * @return
	 */
	public static HttpServletRequest getCurrentServletRequest(){
		return ServletActionContext.getRequest();
	}
	
	/**
	 * 获取当期对话的HttpServletResponse
	 * @return
	 */
	public static HttpServletResponse getCurrentServletResponse(){
		return ServletActionContext.getResponse();
	}
	
	/**
	 * 获取当前对话的Session
	 * @return
	 */
	public static HttpSession getCurrentSession(){
		return ServletActionContext.getRequest().getSession();
	}
	
	/**
	 * 获取当前登陆用户的信息 
	 * @return
	 */
	public static String getCurrentUserInfo(){
		return getCurrentSession().getAttribute("name")+
				"("+getCurrentSession().getAttribute("nickname")+")";
	}
}
