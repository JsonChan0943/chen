package com.tlal.vms.user;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.rowset.serial.SerialArray;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tlal.vms.base.utils.Pager;
import com.tlal.vms.vms.func.user.finishbook.entity.FinishSBook;
import com.tlal.vms.vms.func.user.finishbook.pojo.UserFinishSBookPOJO;
import com.tlal.vms.vms.func.user.sbook.action.UserSbookSearch;
import com.tlal.vms.vms.func.user.sbook.entity.SBook;
import com.tlal.vms.vms.func.user.sbook.pojo.UserSBookPOJO;
import com.tlal.vms.vms.func.user.sbook.service.UserSbookIService;

/**
 * UserSbookServiceTest
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-*.xml" })
public class UserSbookServiceTest {
	private static Logger logger = LoggerFactory.getLogger(UserSbookServiceTest.class);
	@Resource
	private UserSbookIService userSbookService;
	
	/**
	 * testFindSBookByPage
	 */
	@Test
	public void testFindSBookByPage(){
		UserSbookSearch search = new UserSbookSearch();
		search.setToPage(1);
		Pager<UserSBookPOJO> pager = userSbookService.findSBookByPage(search);
		logger.info("=======================================================");
		logger.info("总记录数："+pager.getCount());
		logger.info("本次查询总数:"+pager.getFindCnt());
		for(UserSBookPOJO pojo:pager.getList()){
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
			logger.info("承载人:"+pojo.getDriver());
			logger.info("承载人:"+pojo.getComment());
		}
		logger.info("=======================================================");
	}
	

	/**
	 * testFindSBookById
	 */
	@Test
	public void testFindSBookById(){
		SBook sBook = userSbookService.findSbookById("d3e7b323-2e86-41aa-88d7-d94fb9a60401");
		logger.info("================================");
		logger.info("租赁记录id:"+sBook.getIdsbook());
		logger.info("经办人id:"+sBook.getUserid());
		logger.info("汽车id:"+sBook.getCarid());
		logger.info("承租方:"+sBook.getLessee());
		logger.info("出租方:"+sBook.getLease());
		logger.info("起租时间:"+sBook.getStartDateString());
		logger.info("到租时间:"+sBook.getEndDateString());
		logger.info("使用部门:"+sBook.getUsedept());
		logger.info("是否过期:"+sBook.getIsexpireString());
		logger.info("承载人:"+sBook.getDriver());
		logger.info("承载人:"+sBook.getComment());
	}

}
