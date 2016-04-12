package com.tlal.vms.email;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tlal.vms.base.utils.SendMailUtil;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-*.xml" })
public class SendEmailTest {
	@Test
	public void testSendEmail(){
		String toMailAddr = "chenhuaijie@aliyun.com";
		String subject = "测试发送邮件";
		String message = "发送邮件成功2123231232132"+Math.random()*100;
		SendMailUtil.sendCommonMail(toMailAddr, subject, message);
	}
}
