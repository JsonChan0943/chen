package com.tlal.vms.vms.sys.supers.company.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tlal.vms.base.utils.Pager;
import com.tlal.vms.vms.sys.supers.company.action.SuperCompanySearch;
import com.tlal.vms.vms.sys.supers.company.dao.CompanyDAO;
import com.tlal.vms.vms.sys.supers.company.dto.Company;

@Service
@Transactional(rollbackFor = Exception.class)  
public class SuperCompanyService implements SuperCompanyIService{
	@Resource
	private CompanyDAO companyDAO;

	/**
	 * 分页查询公司
	 */
	@Override
	public Pager<Company> findCompanyByPage(SuperCompanySearch search) {
		// TODO Auto-generated method stub
		Pager<Company> page = new Pager<Company>();
		page.setList(companyDAO.findCompanyByPage(search));
		page.setCount(companyDAO.countCompany(search));
		return page;
	}

	/**
	 * 添加公司信息
	 */
	@Override
	public void addCompany(Company company) {
		if(company!=null){
			companyDAO.addCompany(company);
		}
	}

	/**
	 * 根据id查找公司信息
	 */
	@Override
	public Company findCompanyById(String company_id) {
		if(company_id!=null){
			Company company = companyDAO.findCompanyById(company_id);
			if(company!=null){
				return company;
			}
		}
		return null;
	}

	/**
	 * 根据id删除公司信息
	 */
	@Override
	public void deleteCompanyById(String company_id) {
		if(company_id!=null){
			companyDAO.deleteCompanyById(company_id);
		}
	}

	/**
	 * 更新子公司信息
	 */
	@Override
	public void updateCompany(Company company) {
		if(company!=null){
			companyDAO.updateCompany(company);
		}
	}

	/**
	 * 查找所有公司信息
	 */
	@Override
	public List<Company> findAllCompany() {
		return companyDAO.findAllCompany();
	}
}
