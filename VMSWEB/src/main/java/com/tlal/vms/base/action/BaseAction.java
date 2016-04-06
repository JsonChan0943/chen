package com.tlal.vms.base.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tlal.vms.base.enums.enumc.TipTypeEnum;
import com.tlal.vms.base.sysparam.ConstantsIHandler;
import com.tlal.vms.base.utils.WebUtil;
import com.tlal.vms.vms.sys.supers.log.service.SuperLogIService;

/**
 * Action的基础类
 * @author Administrator
 *
 */
@ParentPackage("basePackage")
@Namespace("/")
public abstract class BaseAction extends ActionSupport implements ModelDriven<Object>{
	private static final long serialVersionUID = 5958973675939419750L;
	@Resource
	protected SuperLogIService superLogService;
	/**
	 * 把Object对象用Json方式写回页面
	 * @param object
	 */
	public void writeJson(Object object) {
		PrintWriter writer = null;
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			String json = JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss");
			response.setContentType("text/html;charset=utf-8");
			writer = response.getWriter();
			writer.write(json);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			writer.close();//用完IO流必须要关闭，放在finally里保证无论程序执行是否正确都能关闭IO流
		}
	}	
	
	/**
	 * 向页面提示信息
	 * @param msg
	 * @param tipType
	 */
	public void addMsg(String msg,TipTypeEnum tipType){
		WebUtil.getCurrentServletRequest().setAttribute(ConstantsIHandler.MSG, msg);//提示的信息
		WebUtil.getCurrentServletRequest().setAttribute(ConstantsIHandler.TIPTYPE, tipType.getEnValue());//页面弹出相关的对话框
	}
	
	/**
	 * 获取用户所在公司
	 * @return
	 */
	protected String getUserCompany(){
		return (String) WebUtil.getCurrentSession().getAttribute(ConstantsIHandler.COMPANY);
	}
	
	/**
	 * 获取用户所在公司
	 * @return
	 */
	protected String getUserCompanyName(){
		return (String) WebUtil.getCurrentSession().getAttribute(ConstantsIHandler.COMPANY_NAME);
	}
	/**
	 * 获取用户角色
	 * @return
	 */
	protected String getUserRole(){
		return (String) WebUtil.getCurrentSession().getAttribute(ConstantsIHandler.ROLE); 
	}
	
	/**
	 * 获取用户名
	 * @return
	 */
	protected String getUserName(){
		return (String) WebUtil.getCurrentSession().getAttribute(ConstantsIHandler.NAME); 
	}
	
	/**
	 * 获取用户信息用于记录业务日志
	 * @return
	 */
	protected String getUserInfoForLog(){
		return getUserCompanyName()+" "+getUserRole()+" "+getUserName();
	}
	
}
