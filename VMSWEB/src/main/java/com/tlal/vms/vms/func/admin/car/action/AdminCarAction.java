package com.tlal.vms.vms.func.admin.car.action;


import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.tlal.vms.base.action.BaseAction;
import com.tlal.vms.vms.func.admin.car.handler.AdminCarIHandler;

/**
 * 管理员-汽车逻辑控制器
 * @author Administrator
 * 我会很好的
 */
@Namespace("/admin/car")
public class AdminCarAction extends BaseAction{
	private static final long serialVersionUID = 1877523299211116686L;

	@Resource
	private AdminCarIHandler adminCarHandler;
	
	@Override
	public Object getModel() {
		return adminCarHandler.getModel();
	}
	
	/**
	 * 列表显示
	 * @return
	 */
	@Action(value="goMain",results={@Result(location="/pages/admin/car/AdminCarMain.jsp")})
	public String goMain(){
		return adminCarHandler.goMain();
	}
	
//	/**
//	 * 添加
//	 * @return
//	 */
//	@Action(value="doAdd",results={@Result(location="/pages/admin/car/AdminCarMain.jsp")})
//	public String doAdd(){
//		logger.info(WebUtil.getCurrentUserInfo()+"----管理员：增加车辆信息----");
//		Car car = model.getCar();
//		car.setCarid(UUID.randomUUID().toString().trim());
//		car.setStatus(CarStatusEnum.N.getEnValue());//默认未被租用
//		car.setCompany(getUserCompany());
//		try {
//			adminCarService.addCar(car);
//			addMsg("添加成功！", TipTypeEnum.SUCCESS);
//			logger.info(WebUtil.getCurrentUserInfo()+"----管理员：增加车辆信息->成功----");
//			superLogService.addLog(getUserInfoForLog(), new Date(), "增加车辆,id:"+car.getCarid()+",车牌号："+car.getPlate_num(),
//					LogOpeTypeEnum.ADDCAR.getEnValue());
//		} catch (Exception e) {
//			addMsg("添加失败！", TipTypeEnum.ERROR);
//			logger.info(WebUtil.getCurrentUserInfo()+"----管理员：增加车辆信息->失败----");
//			LogUtil.log(e);
//		}
//		logger.info(WebUtil.getCurrentUserInfo()+"----管理员：车辆增加结束----");
//		return goMain();
//	}
//	
//	/**
//	 * 验证车牌号是否可用
//	 * @return
//	 */
//	@Action(value="isPalteNumExists")
//	public String isPalteNumExists(){
//		logger.info(WebUtil.getCurrentUserInfo()+"----管理员：添加车辆信息判断车牌号是否可用----");
//		String plate_num = model.getPlate_num();
//		JsonModel jsonModel;
//		try {
//			Car car = adminCarService.findCarByPlateNum(plate_num);
//			jsonModel = new JsonModel();
//			if(car!=null){
//				jsonModel.setSuccess(true);
//				jsonModel.setMsg("车牌号已存在!");
//				logger.info(WebUtil.getCurrentUserInfo()+"----管理员：添加车辆信息判断车牌号是否可用->车牌号已存在----");
//			}else{
//				jsonModel.setSuccess(false);
//				jsonModel.setMsg("车牌号不存在!");
//				logger.info(WebUtil.getCurrentUserInfo()+"----管理员：添加车辆信息判断车牌号是否可用->车牌号不存在----");
//			}
//			super.writeJson(jsonModel);
//		} catch (Exception e) {
//			e.printStackTrace();
//			logger.info(WebUtil.getCurrentUserInfo()+"----管理员：添加车辆信息判断车牌号是否可用->异常----");
//			LogUtil.log(e);
//		}
//		logger.info(WebUtil.getCurrentUserInfo()+"----管理员：添加车辆信息判断车牌号是否可用结束----");
//		return NONE;
//	}
//	
//	/**
//	 * 删除
//	 * @return
//	 */
//	@Action(value="doDel",results={@Result(location="/pages/admin/car/AdminCarMain.jsp")})
//	public String doDel(){
//		logger.info(WebUtil.getCurrentUserInfo()+"----管理员：删除车辆记录----");
//		String carid = model.getCarid();
//		try {
//			adminCarService.deleteCarById(carid);
//			addMsg("删除成功！", TipTypeEnum.SUCCESS);
//			logger.info(WebUtil.getCurrentUserInfo()+"----管理员：删除车辆记录->成功----");
//			superLogService.addLog(getUserInfoForLog(), new Date(), "删除车辆,id:"+carid,
//					LogOpeTypeEnum.DELCAR.getEnValue());
//		} catch (Exception e) {
//			addMsg("存在与该车辆关联的租赁记录或台账记录！", TipTypeEnum.WARN);
//			logger.info(WebUtil.getCurrentUserInfo()+"----管理员：删除车辆记录->失败----");
//			LogUtil.log(e);
//		}
//		logger.info(WebUtil.getCurrentUserInfo()+"----管理员：删除车辆记录结束----");
//		return goMain();
//	}
//	
//	/**
//	 * 编辑
//	 * @return
//	 */
//	@Action(value="doEdit",results={@Result(location="/pages/admin/car/AdminCarMain.jsp")})
//	public String doEdit(){
//		logger.info(WebUtil.getCurrentUserInfo()+"----管理员：修改车辆信息----");
//		Car car = model.getCar();
//		Car dto = adminCarService.findCarById(car.getCarid());
//		dto.setName(car.getName());
//		dto.setPlate_num(car.getPlate_num());
//		dto.setOrigin(car.getOrigin());
//		dto.setType(car.getType());
//		try {
//			adminCarService.updateCar(dto);
//			addMsg("修改成功！", TipTypeEnum.SUCCESS);
//			logger.info(WebUtil.getCurrentUserInfo()+"----管理员：修改车辆信息->成功----");
//			superLogService.addLog(getUserInfoForLog(), new Date(), "修改车辆信息,id:"+car.getCarid(),
//					LogOpeTypeEnum.EDITCAR.getEnValue());
//		} catch (Exception e) {
//			addMsg("修改失败！", TipTypeEnum.ERROR);
//			logger.info(WebUtil.getCurrentUserInfo()+"----管理员：修改车辆信息->失败----");
//			LogUtil.log(e);
//		}
//		logger.info(WebUtil.getCurrentUserInfo()+"----管理员：修改车辆信息结束----");
//		return goMain();
//	}
}
