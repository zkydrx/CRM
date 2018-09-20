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

import com.java1234.entity.CustomerService;
import com.java1234.entity.PageBean;
import com.java1234.service.CustomerServiceService;
import com.java1234.util.ResponseUtil;
import com.java1234.util.StringUtil;

/**
 * ???????Controller??
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/customerService")
public class CustomerServiceController {

	@Resource
	private CustomerServiceService customerServiceService;
	
	@InitBinder
	 public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   //true:????????????false:????????
	}
	
	/**
	 * ???????????
	 * @param page
	 * @param rows
	 * @param s_customerService
	 * @param createTimefrom
	 * @param createTimeto
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value="page",required=false)String page,@RequestParam(value="rows",required=false)String rows,CustomerService s_customerService,String createTimefrom,String createTimeto,HttpServletResponse response)throws Exception{
		PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("customer", StringUtil.formatLike(s_customerService.getCustomer()));
		map.put("overview", StringUtil.formatLike(s_customerService.getOverview()));
		map.put("serveType", s_customerService.getServeType());
		map.put("state", s_customerService.getState());
		map.put("createTimefrom", createTimefrom);
		map.put("createTimeto", createTimeto);
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		JSONObject result=new JSONObject();
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		List<CustomerService> customerServiceList=customerServiceService.findCustomerService(map);
		Long total=customerServiceService.getTotalCustomerService(map);
		JSONArray jsonArray=JSONArray.fromObject(customerServiceList,jsonConfig);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * ?????????????
	 * @param customerService
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String save(CustomerService customerService,HttpServletResponse response)throws Exception{
		int resultTotal=0; // ????????????
		if(customerService.getId()==null){
			resultTotal=customerServiceService.addCustomerService(customerService);
		}else{
			resultTotal=customerServiceService.updateCustomerService(customerService);
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
	 * @param ids
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam(value="ids")String ids,HttpServletResponse response)throws Exception{
		JSONObject result=new JSONObject();
		String []idsStr=ids.split(",");
		for(int i=0;i<idsStr.length;i++){
			customerServiceService.deleteCustomerService(Integer.parseInt(idsStr[i]));
		}
		result.put("success", true);
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
		CustomerService customerService=customerServiceService.findById(Integer.parseInt(id));
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONObject jsonObject=JSONObject.fromObject(customerService,jsonConfig);
		ResponseUtil.write(response, jsonObject);
		return null;
	}
}
