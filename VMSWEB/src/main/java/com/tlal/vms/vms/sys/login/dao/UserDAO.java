package com.tlal.vms.vms.sys.login.dao;

import java.util.List;

import com.tlal.vms.base.annotation.MyBatisRepository;
import com.tlal.vms.vms.func.admin.user.action.AdminUserSearch;
import com.tlal.vms.vms.func.admin.user.pojo.AdminUserPOJO;
import com.tlal.vms.vms.sys.login.entity.User;
import com.tlal.vms.vms.sys.supers.admin.action.SuperAdminSearch;
import com.tlal.vms.vms.sys.supers.admin.pojo.SuperAdminPOJO;

@MyBatisRepository
public interface UserDAO {
	/**
	 * 根据id查找User记录
	 * @param id 主键id
	 * @return
	 */
	public User findById(String userid);
	
	/**
	 * 根据用户名查找User记录
	 * @param username 用户名
	 * @return
	 */
	public User findByUserName(String name);
	
	/**
	 * 添加记录
	 * @param user 需要添加的User记录
	 * @return
	 */
	public void addUser(User user);
	
	/**
	 * 登陆验证
	 * @param user
	 * @return 
	 */
	public User findByUserNameAndPwd(User user);
	
	/**
	 * 列出所有的管理员的信息
	 * @return
	 */
	public List<SuperAdminPOJO> listAdmins();
	
	/**
	 * 更新User记录
	 * @param user
	 */
	public void updateUser(User user);
	
	/**
	 * 删除User记录
	 * @param userid
	 */
	public void deleteUser(String userid);
	
	/**
	 * 列表显示所有的用户
	 * @return
	 */
	public List<User> findAllUsers();
	
	/**
	 * 查找分公司的用户
	 * @param company
	 * @return
	 */
	public List<User> findAllUsersByConpanyId(String company);
	
	/**
	 * 分页查找管理员
	 * @param page
	 * @return
	 */
	public List<SuperAdminPOJO> findAdminsByPage(SuperAdminSearch model);
	/**
	 * 获取管理员的数量
	 * @return
	 */
	public Integer countAdmins(SuperAdminSearch model);
	
	/**
	 * 分页查找用户
	 * @param page
	 * @return
	 */
	public List<AdminUserPOJO> findUsersByPage(AdminUserSearch search);
	/**
	 * 获取用户的数量
	 * @return
	 */
	public Integer countUsers(AdminUserSearch search);
	
	/**
	 * 根据公司查找信息
	 * @param company
	 * @return
	 */
	public List<AdminUserPOJO> findUsersByCompany(String company);
}
