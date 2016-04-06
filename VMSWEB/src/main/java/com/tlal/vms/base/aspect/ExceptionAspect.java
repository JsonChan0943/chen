package com.tlal.vms.base.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 异常日记记录处理类
 * @author Administrator
 *
 */
@Component
@Aspect
public class ExceptionAspect {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LoggerFactory.getLogger(ExceptionAspect.class);
//	@AfterThrowing(throwing="e",pointcut="within(com.tlal.vms..*)")
//	public void execute(Exception e){
//		StackTraceElement[] st = e.getStackTrace();
//		Date now = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		logger.info("报错时间："+sdf.format(now));
//		logger.info("异常类型："+e);
//		logger.info("\n异常信息："+st[0]);
//		logger.error("错误堆栈信息",e);
//	}	
}
