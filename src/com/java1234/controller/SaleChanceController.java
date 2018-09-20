package com.java1234.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java1234.entity.PageBean;
import com.java1234.entity.SaleChance;
import com.java1234.service.SaleChanceService;
import com.java1234.util.ResponseUtil;
import com.java1234.util.StringUtil;

/**
 * ???????Controller??
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/saleChance")
public class SaleChanceController {

	@Resource
	private SaleChanceService saleChanceService;
	
	 @InitBinder
	 public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   //true:????????????false:????????
	}
	
	/**
	 * ????????????
	 * @param page
	 * @param rows
	 * @param s_saleChance
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value="page",required=false)String page,@RequestParam(value="rows",required=false)String rows,SaleChance s_saleChance,HttpServletResponse response)throws Exception{
		PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("customerName",StringUtil.formatLike(s_saleChance.getCustomerName()));
		map.put("overView", StringUtil.formatLike(s_saleChance.getOverView()));
		map.put("createMan", StringUtil.formatLike(s_saleChance.getCreateMan()));
		map.put("state", s_saleChance.getState());
		map.put("devResult", s_saleChance.getDevResult());
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<SaleChance> saleChanceList=saleChanceService.findSaleChance(map);
		Long total=saleChanceService.getTotalSaleChance(map);
		JSONObject result=new JSONObject();
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd HH:mm"));
		JSONArray jsonArray=JSONArray.fromObject(saleChanceList,jsonConfig);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * ??????????
	 * @param saleChance
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String save(SaleChance saleChance,HttpServletResponse response)throws Exception{
		int resultTotal=0; // ????????????
		if(StringUtil.isNotEmpty(saleChance.getAssignMan())){
			saleChance.setState(1);
		}else{
			saleChance.setState(0); // ???¦Ä??????
		}
		if(saleChance.getId()==null){
			saleChance.setDevResult(0); // ??????? ???¦Ä???????
			resultTotal=saleChanceService.addSaleChance(saleChance);
		}else{
			resultTotal=saleChanceService.updateSaleChance(saleChance);
		}
		JSONObject result=new JSONObject();
		if(resultTotal>0){ // ??§Ô??
			result.put("success", true);
		}else{
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * ??????????
	 * @param ids ?????????id?????????????
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam(value="ids")String ids,HttpServletResponse response)throws Exception{
		JSONObject result=new JSONObject();
		String []idsStr=ids.split(",");
		for(int i=0;i<idsStr.length;i++){
			saleChanceService.deleteSaleChance(Integer.parseInt(idsStr[i]));
		}
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * ???????????
	 * @param id
	 * @param devResult
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateSaleChanceDevResult")
	public String updateSaleChanceDevResult(@RequestParam(value="id")String id,@RequestParam(value="devResult")String devResult,HttpServletResponse response)throws Exception{
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("id", id);
		map.put("devResult", devResult);
		int resultTotal=saleChanceService.updateSaleChanceDevResult(map);
		JSONObject result=new JSONObject();
		if(resultTotal>0){ // ??§Ô??
			result.put("success", true);
		}else{
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * ???id???????
	 * @param id
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findById")
	public String findById(@RequestParam(value="id")String id,HttpServletResponse response)throws Exception{
		SaleChance saleChance=saleChanceService.findById(Integer.parseInt(id));
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd HH:mm"));
		JSONObject jsonObject=JSONObject.fromObject(saleChance,jsonConfig);
		ResponseUtil.write(response, jsonObject);
		return null;
	}
}
