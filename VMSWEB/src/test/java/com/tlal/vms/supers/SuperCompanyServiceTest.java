package com.tlal.vms.supers;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tlal.vms.base.utils.Pager;
import com.tlal.vms.vms.sys.supers.company.action.SuperCompanySearch;
import com.tlal.vms.vms.sys.supers.company.dto.Company;
import com.tlal.vms.vms.sys.supers.company.service.SuperCompanyIService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-*.xml" })
public class SuperCompanyServiceTest {
	@Resource
	private SuperCompanyIService superCompanyService;
	
	@Test
	public void testFindByPage(){
		SuperCompanySearch search = new SuperCompanySearch();
		search.setToPage(1);
		Pager<Company> pager = superCompanyService.findCompanyByPage(search);
	}
}
