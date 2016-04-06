package com.tlal.vms.base.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;

/**
 * Ajax的公共类
 * @author Administrator
 *
 */
public class BaseAjax {
	/**
	 * 把Object对象以json方式写回前台
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
//			writer.close();//放在这里执行 如果程序出现异常 这里就不能正确关闭输出流
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			writer.close();//关闭输出流
		}
	}	
}
