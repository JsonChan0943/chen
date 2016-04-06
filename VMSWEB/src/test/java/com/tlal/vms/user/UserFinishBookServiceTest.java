package com.tlal.vms.user;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tlal.vms.base.utils.Pager;
import com.tlal.vms.vms.func.user.finishbook.action.UserFinishSBookSearch;
import com.tlal.vms.vms.func.user.finishbook.pojo.UserFinishSBookPOJO;
import com.tlal.vms.vms.func.user.finishbook.service.UserFinishSBookIService;

/**
 * UserFinishBookServiceTest
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-*.xml" })
public class UserFinishBookServiceTest {
	private static Logger logger = LoggerFactory.getLogger(UserFinishBookServiceTest.class);
	@Resource
	private UserFinishSBookIService userFinishSBookService;
	
	/**
	 * testFindFinishSBookByPage
	 */
	@Test
	public void testFindFinishSBookByPage(){
		UserFinishSBookSearch search = new UserFinishSBookSearch();
		search.setToPage(1);
		Pager<UserFinishSBookPOJO> pager = userFinishSBookService.findFinishSBookByPage(search);
		logger.info("=======================================================");
		logger.info("总记录数："+pager.getCount());
		logger.info("本次查询总数:"+pager.getFindCnt());
		for(UserFinishSBookPOJO pojo:pager.getList()){
			logger.info("================================");
			logger.info("租赁记录id:"+pojo.getIdsbook());
			logger.info("经办人id:"+pojo.getUserid());
			logger.info("汽车id:"+pojo.getCarid());
			logger.info("承租方:"+pojo.getLessee());
			logger.info("出租方:"+pojo.getLease());
			logger.info("起租时间:"+pojo.getStartDateString());
			logger.info("到租时间:"+pojo.getEndDateString());
			logger.info("使用部门:"+pojo.getUsedept());
			logger.info("是否过期:"+pojo.getIsexpireString());
			logger.info("实际归还日期:"+pojo.getActual_dateString());
			logger.info("承载人:"+pojo.getDriver());
			logger.info("承载人:"+pojo.getComment());
		}
		logger.info("=======================================================");
	}
	
}
