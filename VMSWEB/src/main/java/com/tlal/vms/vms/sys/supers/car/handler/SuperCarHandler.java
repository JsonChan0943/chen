package com.tlal.vms.vms.sys.supers.car.handler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tlal.vms.base.enums.enumc.CarOriginEnum;
import com.tlal.vms.base.enums.enumc.CarStatusEnum;
import com.tlal.vms.base.enums.enumc.LogOpeTypeEnum;
import com.tlal.vms.base.enums.enumc.TipTypeEnum;
import com.tlal.vms.base.handler.VMSHandler;
import com.tlal.vms.base.utils.FileUtil;
import com.tlal.vms.base.utils.JsonModel;
import com.tlal.vms.base.utils.LogUtil;
import com.tlal.vms.base.utils.PageModel;
import com.tlal.vms.base.utils.Pager;
import com.tlal.vms.base.utils.WebUtil;
import com.tlal.vms.vms.func.admin.car.entity.Car;
import com.tlal.vms.vms.func.admin.user.pojo.AdminUserPOJO;
import com.tlal.vms.vms.func.user.sbook.entity.SBook;
import com.tlal.vms.vms.func.user.sbook.service.UserSbookIService;
import com.tlal.vms.vms.sys.login.dao.UserDAO;
import com.tlal.vms.vms.sys.supers.car.action.SuperCarModel;
import com.tlal.vms.vms.sys.supers.car.action.SuperCarSearch;
import com.tlal.vms.vms.sys.supers.car.pojo.CarPOJO;
import com.tlal.vms.vms.sys.supers.car.pojo.FilePOJO;
import com.tlal.vms.vms.sys.supers.car.service.SuperCarIService;
import com.tlal.vms.vms.sys.supers.company.dto.Company;
import com.tlal.vms.vms.sys.supers.company.service.SuperCompanyIService;
import com.ylink.eu.office.excel.imp.ExcelReadUtil;
import com.ylink.eu.office.excel.imp.enums.ExcelVerEnum;
import com.ylink.eu.report.ReportUtil;
import com.ylink.eu.util.tools.CharSetUtil;
import com.ylink.eu.util.tools.enums.ExportEnum;

public class SuperCarHandler extends VMSHandler implements SuperCarIHandler{
	private static final Logger logger = LoggerFactory.getLogger(SuperCarHandler.class);
	@Resource
	private SuperCarIService superCarService;
	@Resource
	private SuperCompanyIService superConpanyService;
	@Resource
	private UserSbookIService userSbookService;
	@Resource
	private UserDAO userDAO;
	
	//===============================productModel===========================================
	private SuperCarModel productModel;
	
	@Override
	public SuperCarModel getModel() {
		if(null == productModel){
			productModel = getExtendModel();
			if(null == productModel){
				productModel = new SuperCarModel();
			}
		}
		return productModel;
	}

	/**
	 * 获取拓展模型
	 * @return
	 */
	public SuperCarModel getExtendModel(){
		return null;
	}
	
	//===============================goMain===========================================
	/**
	 * 列表
	 */
	@Override
	public String goMain() {
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		for(Company company:superConpanyService.findAllCompany()){
			Map<String, String> map  = new HashMap<String,String>();
			map.put("company_id", company.getCompany_id());
			map.put("company_name", company.getCompany_name());
			list.add(map);
		}
		productModel.setCompanies(list);
		logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：车辆列表显示----");
		productModel.setStatus(CarStatusEnum.values());
		productModel.setOrigins(CarOriginEnum.values());
		//获取页面传过来的页码和页面大小
		PageModel pageModel = productModel.getPageModel();
		SuperCarSearch search = productModel.getSearch();
		int toPage = pageModel.getToPage()==null?1:pageModel.getToPage();
		search.setToPage(toPage);
		try {
			Pager<Car> page = superCarService.findCarByPage(search);
			productModel.setCars(page.getList());
			pageModel.setCurrent_page(toPage);
			pageModel.setFindCnt(page.getList().size());
			pageModel.countPage(page.getCount(),pageModel.getFindCnt());
			logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：车辆列表显示->成功获取用户记录----");
		} catch (Exception e) {
			logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：车辆列表显示->获取用户记录失败----");
			LogUtil.log(e);
		}
		logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：车辆列表显示结束----");
		return SUCCESS;
	}
	
	//===============================doAdd===========================================
	/**
	 * 增加
	 */
	@Override
	public String doAdd() {
		logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：增加车辆信息----");
		Car car = productModel.getCar();
		car.setCarid(UUID.randomUUID().toString().trim());
		car.setStatus(CarStatusEnum.N.getEnValue());//默认未被租用
		try {
			superCarService.addCar(car);
			addMsg("添加成功！", TipTypeEnum.SUCCESS);
			logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：增加车辆信息->成功----");
			superLogService.addLog(getUserInfoForLog(), new Date(), "增加车辆,id:"+car.getCarid()+",车牌号："+car.getPlate_num(),
					LogOpeTypeEnum.ADDCAR.getEnValue());
		} catch (Exception e) {
			addMsg("添加失败！", TipTypeEnum.ERROR);
			logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：增加车辆信息->失败----");
			LogUtil.log(e);
		}
		logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：车辆增加结束----");
		return goMain();
	}
	
	//===============================isPalteNumExists===========================================
	/**
	 * 判断车牌是否可用
	 */
	@Override
	public String isPalteNumExists() {
		logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：添加车辆信息判断车牌号是否可用----");
		String plate_num = productModel.getPlate_num();
		JsonModel jsonModel;
		try {
			Car car = superCarService.findCarByPlateNum(plate_num);
			jsonModel = new JsonModel();
			if(car!=null){
				jsonModel.setSuccess(true);
				jsonModel.setMsg("车牌号已存在!");
				logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：添加车辆信息判断车牌号是否可用->车牌号已存在----");
			}else{
				jsonModel.setSuccess(false);
				jsonModel.setMsg("车牌号不存在!");
				logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：添加车辆信息判断车牌号是否可用->车牌号不存在----");
			}
			super.writeJson(jsonModel);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：添加车辆信息判断车牌号是否可用->异常----");
			LogUtil.log(e);
		}
		logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：添加车辆信息判断车牌号是否可用结束----");
		return NONE;
	}
	
	//===============================doDel===========================================
	/**
	 * 删除
	 */
	@Override
	public String doDel() {
		logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：删除车辆记录----");
		String carid = productModel.getCarid();
		try {
			superCarService.deleteCarById(carid);
			addMsg("删除成功！", TipTypeEnum.SUCCESS);
			logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：删除车辆记录->成功----");
			superLogService.addLog(getUserInfoForLog(), new Date(), "删除车辆,id:"+carid,
					LogOpeTypeEnum.DELCAR.getEnValue());
		} catch (Exception e) {
			addMsg("存在与该车辆关联的租赁记录或台账记录！", TipTypeEnum.WARN);
			logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：删除车辆记录->失败----");
			LogUtil.log(e);
		}
		logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：删除车辆记录结束----");
		return goMain();
	}
	
	//===============================doEdit===========================================
	/**
	 * 修改
	 */
	@Override
	public String doEdit() {
		logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：修改车辆信息----");
		Car car = productModel.getCar();
		Car dto = superCarService.findCarById(car.getCarid());
		dto.setName(car.getName());
		dto.setPlate_num(car.getPlate_num());
		dto.setOrigin(car.getOrigin());
		dto.setType(car.getType());
		dto.setCompany(car.getCompany());
		try {
			superCarService.updateCar(dto);
			List<AdminUserPOJO> list = userDAO.findUsersByCompany(car.getCompany());
			if(list!=null&&list.size()>0){
				String userid = list.get(0).getUserid();
				SBook sBook=userSbookService.findByCarId(car.getCarid());
				if(sBook!=null){
					sBook.setUserid(userid);
					userSbookService.updateSbook(sBook);
				}
			}
			addMsg("修改成功！", TipTypeEnum.SUCCESS);
			logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：修改车辆信息->成功----");
			superLogService.addLog(getUserInfoForLog(), new Date(), "修改车辆信息,id:"+car.getCarid(),
					LogOpeTypeEnum.EDITCAR.getEnValue());
		} catch (Exception e) {
			addMsg("修改失败！", TipTypeEnum.ERROR);
			logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：修改车辆信息->失败----");
			LogUtil.log(e);
		}
		logger.info(WebUtil.getCurrentUserInfo()+"----超级管理员：修改车辆信息结束----");
		return goMain();
	}

	//===============================doReport===========================================
	@Override
	public String doReport() {
		List<Car> cars = superCarService.findAllCar_Super();
		Map<String,Object> map = new HashMap<String,Object>();
		int i= cars.size();
		map.put("SIZE", i);
		map.put("title", "汽车信息清单");
		ReportUtil.exportToResponse(ExportEnum.excel,"report-jasper-common", "SuperCarList_goMain.jasper", cars,map,CharSetUtil.UTF_8, "汽车信息清单");
		return NONE;
	}

	//===============================doAddBatch===========================================
	/**
	 * 批量上传汽车信息
	 */
	@Override
	public String doAddBatch(File some,String someFileName,String someContentType) {
		if(some==null){
			addMsg("上传文件为空，请重新上传！", TipTypeEnum.ERROR);
			return goMain();
		}
		String prefix = someFileName.substring(someFileName.lastIndexOf(".")+1).toLowerCase();
		if((!"xls".equals(prefix))&&(!"xlsx".equals(prefix))){
			addMsg("请上传Excel文件！", TipTypeEnum.WARN);
			return goMain();
		}
		List<CarPOJO> list = null;
		try {
			InputStream local = new FileInputStream(some);
			list = new ArrayList<CarPOJO>();
			// 解析excel
			list = ExcelReadUtil.readExcelByIndex(CarPOJO.class, ExcelVerEnum.XLSX, local, 0, 2);
			if(list==null||list.size()==0){
				addMsg("上传文件里没有记录！", TipTypeEnum.ERROR);
				return goMain();
			}
			for(int i=0;i<list.size();i++){
				CarPOJO pojo = list.get(i);
				String[] flds = {pojo.getName(),pojo.getPlate_num(),pojo.getType(),pojo.getOrigin(),pojo.getCompany()};
				for(int r=0;r<flds.length;r++){
					if(flds[r] == null){
						addMsg("上传文件里有记录数据项为空！", TipTypeEnum.ERROR);
						return goMain();
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return goMain();
		}
		int toTal = list.size();//一共要入表的汽车信息数
		int success = 0;//成功入表的车辆信息数
		Car car = new Car();
		List<CarPOJO> failCar = new ArrayList<CarPOJO>();//入表失败的汽车车牌号集合
		//逐一入表
		for(CarPOJO pojo:list){
			if(superCarService.findCarByPlateNum(pojo.getPlate_num())==null){
				car.setCarid(UUID.randomUUID().toString());
				car.setName(pojo.getName());
				car.setPlate_num(pojo.getPlate_num());
				car.setType(pojo.getType());
				car.setStatus(CarStatusEnum.N.getEnValue());
				car.setOrigin(pojo.getOrigin());
				car.setCompany(pojo.getCompany());
				superCarService.addCar(car);
				success++;
			}else{
				failCar.add(pojo);
			}
		}
		if(success==toTal){
			addMsg("批量导入车辆信息成功！", TipTypeEnum.SUCCESS);
		}else if(success==0){
			addMsg("批量导入车辆信息全部失败！", TipTypeEnum.ERROR);
		}else{
			String timeStr = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());//获取当前时间字符串
			String fileName = timeStr+".txt";//为文件命名
			/*
			 * 把错误记录写文件
			 */
			String fullFileName = ServletActionContext.getServletContext().getRealPath(File.separator+"batcherror"+File.separator+fileName);
			File file = new File(fullFileName);
			OutputStreamWriter fw = null;
			try {
				file.createNewFile();
				if (file.exists()) {
					file.setReadable(true);
					fw = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
					for (CarPOJO detail : failCar) {
						fw.write(detail.getDetailStr()+"\\n");
					}
					fw.flush();
				}
			} catch (IOException e2) {
				e2.printStackTrace();
			} finally{
				if(fw!=null){
					try {
						fw.close();//关闭输出流
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			addMsg("批量导入车辆信息部分失败,详情见"+fileName+"文件！", TipTypeEnum.WARN);
		}
		return goMain();
	}


	//===============================download===========================================
	/**
	 * 模板下载
	 */
	@Override
	public String download() {
		String fileName = "CarInfo.xlsx";
		String fullFileName = ServletActionContext.getServletContext().getRealPath(File.separator+"filemodel"+File.separator+fileName);
		File file = new File(fullFileName);
		if(!file.exists()){
			addMsg("模板不存在！", TipTypeEnum.ERROR);
			return goMain();
		}
		FileUtil.fileDownload(fileName, file);
		return NONE;
	}

	//===============================detailError===========================================
	/**
	 * 错误详情记录文件
	 */
	@Override
	public String detailError() {
		String fullFileName = ServletActionContext.getServletContext().getRealPath(File.separator+"batcherror"+File.separator);
		File dir = new File(fullFileName);
		List<FilePOJO> list = new ArrayList<FilePOJO>();//文件名集合
		if(dir.isDirectory()){
			File[] files = dir.listFiles();
			int i = 0;
			for(File file:files){
				i++;
				FilePOJO pojo = new FilePOJO();
				pojo.setNo(i+"");
				try {
					String time = file.getName().substring(0, file.getName().lastIndexOf("."));
					pojo.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new SimpleDateFormat("yyyyMMddHHmmss").parse(time)));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				pojo.setFileName(file.getName());
				list.add(pojo);
			}
		}
		productModel.setFilePOJO(list);
		return SUCCESS;
	}

	//===============================doErrFileDownload===========================================
	/**
	 * 系在错误详情文件下载
	 */
	@Override
	public String doErrFileDownload() {
		String fileName = productModel.getFileName();
		String fullFileName = ServletActionContext.getServletContext().getRealPath(File.separator+"batcherror"+File.separator+fileName);
		File file = new File(fullFileName);
		if(!file.exists()){
			addMsg("文件不存在！", TipTypeEnum.ERROR);
			return goMain();
		}
		FileUtil.fileDownload(fileName,file);
		return NONE;
	}

	//===============================doErrFileDel===========================================
	/**
	 * 删除错误详情文件
	 */
	@Override
	public String doErrFileDel() {
		String fileName = productModel.getFileName();
		String fullFileName = ServletActionContext.getServletContext().getRealPath(File.separator+"batcherror"+File.separator+fileName);
		File file = new File(fullFileName);
		if(file.exists()){
			boolean success = file.delete();
			if(success){
				addMsg("文件删除成功！", TipTypeEnum.SUCCESS);
			}else{
				addMsg("文件删除失败！", TipTypeEnum.ERROR);
			}
		}else{
			addMsg("文件不存在！", TipTypeEnum.ERROR);
		}
		return detailError();
	}
}
