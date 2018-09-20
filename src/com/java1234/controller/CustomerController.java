package com.java1234.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java1234.entity.Customer;
import com.java1234.entity.CustomerFw;
import com.java1234.entity.CustomerGc;
import com.java1234.entity.CustomerGx;
import com.java1234.entity.PageBean;
import com.java1234.service.CustomerService;
import com.java1234.util.DateUtil;
import com.java1234.util.ResponseUtil;
import com.java1234.util.StringUtil;

/**
 * ???Controller??
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Resource
	private CustomerService customerService;
	
	/**
	 * ??????????
	 * @param page
	 * @param rows
	 * @param s_customer
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value="page",required=false)String page,@RequestParam(value="rows",required=false)String rows,Customer s_customer,HttpServletResponse response)throws Exception{
		PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("name", StringUtil.formatLike(s_customer.getName()));
		map.put("khno", StringUtil.formatLike(s_customer.getKhno()));
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<Customer> customerList=customerService.findCustomer(map);
		Long total=customerService.getTotalCustomer(map);
		JSONObject result=new JSONObject();
		JSONArray jsonArray=JSONArray.fromObject(customerList);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * ?????
	 * @param customer
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String save(Customer customer,HttpServletResponse response)throws Exception{
		int resultTotal=0; // ????????????
		if(customer.getId()==null){
			customer.setKhno("KH"+DateUtil.getCurrentDateStr());
			resultTotal=customerService.addCustomer(customer);
		}else{
			resultTotal=customerService.updateCustomer(customer);
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
			customerService.deleteCustomer(Integer.parseInt(idsStr[i]));
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
		Customer customer=customerService.findById(Integer.parseInt(id));
		JSONObject jsonObject=JSONObject.fromObject(customer);
		ResponseUtil.write(response, jsonObject);
		return null;
	}
	
	/**
	 * ??????????
	 * @param s_customer
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findCutomerGx")
	public String findCutomerGx(String name,HttpServletResponse response)throws Exception{
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("name", StringUtil.formatLike(name));
		List<CustomerGx> customerGxList=customerService.findCutomerGx(map);
		Long total=customerService.getTotalCustomerGx(map);
		JSONObject result=new JSONObject();
		JSONArray jsonArray=JSONArray.fromObject(customerGxList);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * ??????????
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findCutomerGc")
	public String findCustomerGc(HttpServletResponse response)throws Exception{
		List<CustomerGc> customerGcList=customerService.findCustomerGc();
		JSONArray jsonArray=JSONArray.fromObject(customerGcList);
		ResponseUtil.write(response, jsonArray);
		return null;
	}
	
	/**
	 * ??????????
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findCutomerFw")
	public String findCustomerFw(HttpServletResponse response)throws Exception{
		List<CustomerFw> customerFwList=customerService.findCustomerFw();
		JSONArray jsonArray=JSONArray.fromObject(customerFwList);
		ResponseUtil.write(response, jsonArray);
		return null;
	}
	
	
}
