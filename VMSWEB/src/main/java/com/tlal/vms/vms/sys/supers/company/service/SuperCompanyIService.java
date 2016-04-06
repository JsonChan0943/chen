package com.tlal.vms.vms.sys.supers.company.service;

import java.util.List;

import com.tlal.vms.base.utils.Pager;
import com.tlal.vms.vms.sys.supers.company.action.SuperCompanySearch;
import com.tlal.vms.vms.sys.supers.company.dto.Company;

public interface SuperCompanyIService {
	
	/**
	 * 分页查询公司
	 * @param search
	 * @return
	 */
	public Pager<Company> findCompanyByPage(SuperCompanySearch search);
	
	/**
	 * 添加公司信息
	 * @param company
	 */
	public void addCompany(Company company);
	
	/**
	 * 根据id查找公司信息
	 * @param company_id
	 */
	public Company findCompanyById(String company_id);
	
	/**
	 * 根据id删除公司信息
	 * @param company_id
	 */
	public void deleteCompanyById(String company_id);
	
	/**
	 * 更新Company
	 * @param company
	 */
	public void updateCompany(Company company);
	
	/**
	 * 查找所有公司信息
	 * @return
	 */
	public List<Company> findAllCompany();
	
}
