package com.tlal.vms.base.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

/**
 * 文件工具类
 * @author Administrator
 *
 */
public class FileUtil {
	/**
	 * 下载文件
	 * @param fileName 文件名
	 * @param file 文件对象
	 */
	public static void fileDownload(String fileName,File file){
		HttpServletResponse response = WebUtil.getCurrentServletResponse();
		response.setContentType(ServletActionContext.getServletContext().getMimeType(fileName));//设置文件的MIME类型
		try {
			//服务器通过这个头，告诉浏览器以下载方式打开数据
			response.setHeader("content-disposition", "attachment;filename="+URLEncoder.encode(fileName,"UTF-8"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(file);
			out = response.getOutputStream();
			byte[] buffer = new byte[1024];
			int len = 0;
			while((len=in.read(buffer))>0){
				out.write(buffer,0,len);
			}
			out.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(in!=null){in.close();}
				if(out!=null){out.close();}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
