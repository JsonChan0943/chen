package com.tlal.vms.vms.sys.supers.company.dao;

import java.util.List;

import com.tlal.vms.base.annotation.MyBatisRepository;
import com.tlal.vms.vms.sys.supers.company.action.SuperCompanySearch;
import com.tlal.vms.vms.sys.supers.company.dto.Company;

@MyBatisRepository
public interface CompanyDAO {
	/**
	 * 分页查询
	 * @param search
	 * @return
	 */
	public List<Company> findCompanyByPage(SuperCompanySearch search);
	
	/**
	 * 统计公司个数
	 * @param search
	 * @return
	 */
	public Integer countCompany(SuperCompanySearch search);
	
	/**
	 * 添加公司信息
	 * @param company
	 */
	public void addCompany(Company company);
	
	/**
	 * 根据id查找公司信息
	 * @param company_id
	 * @return
	 */
	public Company findCompanyById(String company_id);
	
	/**
	 * 根据id
	 * @param company_id
	 */
	public void deleteCompanyById(String company_id);
	
	/**
	 * 更新Company信息
	 * @param company
	 */
	public void updateCompany(Company company);
	
	/**
	 * 查找所有公司实体类
	 * @return
	 */
	public List<Company> findAllCompany();
}
