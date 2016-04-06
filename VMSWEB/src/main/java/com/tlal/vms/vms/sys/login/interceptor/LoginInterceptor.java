package com.tlal.vms.vms.sys.login.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.tlal.vms.base.sysparam.ConstantsIHandler;


/**
 * 项目名称：VMS
 * 类描述：登陆拦截器，禁止未登陆访问页面
 */
public class LoginInterceptor implements Interceptor{
	private static final long serialVersionUID = 4302242687530169241L;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		String name = (String) session.getAttribute(ConstantsIHandler.NAME);
		if(name!=null){
			invocation.invoke();
		}
		return "toLogin";
	}	
}
