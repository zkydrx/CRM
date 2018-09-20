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

import com.java1234.entity.CusDevPlan;
import com.java1234.service.CusDevPlanService;
import com.java1234.service.SaleChanceService;
import com.java1234.util.ResponseUtil;

/**
 * ??????????Controller??
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/cusDevPlan")
public class CusDevPlanController {

	@Resource
	private CusDevPlanService cusDevPlanService;
	
	@Resource
	private SaleChanceService saleChanceService;
	
	@InitBinder
	 public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   //true:????????????false:????????
	}
	
	/**
	 * ?????????????????
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value="saleChanceId")String saleChanceId,HttpServletResponse response)throws Exception{
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("saleChanceId", saleChanceId);
		List<CusDevPlan> cusDevPlanList=cusDevPlanService.findCusDevPlan(map);
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.setExcludes(new String[]{"saleChance"});
		jsonConfig.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONObject result=new JSONObject();
		JSONArray jsonArray=JSONArray.fromObject(cusDevPlanList,jsonConfig);
		result.put("rows", jsonArray);
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * ??????????????
	 * @param cusDevPlan
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String save(CusDevPlan cusDevPlan,HttpServletResponse response)throws Exception{
		int resultTotal=0; // ????????????
		if(cusDevPlan.getId()==null){
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("id", cusDevPlan.getSaleChance().getId());
			map.put("devResult", 1); // ?????¨À??????§³?
			saleChanceService.updateSaleChanceDevResult(map);
			resultTotal=cusDevPlanService.addCusDevPlan(cusDevPlan);
		}else{
			resultTotal=cusDevPlanService.updateCusDevPlan(cusDevPlan);
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
	 * @param id
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam(value="id")String id,HttpServletResponse response)throws Exception{
		cusDevPlanService.deleteCusDevPlan(Integer.parseInt(id));
		JSONObject result=new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
}
