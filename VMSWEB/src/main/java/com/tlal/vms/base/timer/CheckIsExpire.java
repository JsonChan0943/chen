package com.tlal.vms.base.timer;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.tlal.vms.vms.func.user.sbook.dao.SBookDAO;
import com.tlal.vms.vms.func.user.sbook.entity.SBook;

/**
 * 定时任务
 * 每隔一定时间轮询租赁表 判断租赁是否过期
 * @author Administrator
 *
 */
@Component
public class CheckIsExpire {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LoggerFactory.getLogger(CheckIsExpire.class);
	
	@Resource
	private SBookDAO sBookDAO;
    
    public void checkIsExpire() {
    	logger.info("-----------------------------定时任务，循环租赁表，设置已过期未过期-----开始--------------------------------");
    	Date now = new Date();
    	List<SBook> list = sBookDAO.findAllSBook();//获取所有记录
    	if(list!=null&&list.size()!=0){
    		for(SBook book:list){
        		if(book.getEnddate().after(now)){
        			sBookDAO.setUnExpire(book.getIdsbook().toString().trim());
        			logger.info("----------修改了车辆的过期标志,未过期,租赁信息id是："+book.getIdsbook().toString().trim());
        		}else{
        			sBookDAO.setExpire(book.getIdsbook().toString().trim());
        			logger.info("----------修改了车辆的过期标志,已过期,租赁信息id是："+book.getIdsbook().toString().trim());
        		}
        	}
    	}
    	logger.info("-----------------------------定时任务，循环租赁表，设置已过期未过期-----结束--------------------------------");
    }
}
