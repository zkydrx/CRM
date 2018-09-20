package com.java1234.controller;

import com.java1234.entity.CustomerReprieve;
import com.java1234.service.CustomerReprieveService;
import com.java1234.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ????????????Controller??
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/customerReprieve")
public class CustomerReprieveController {

	@Resource
	private CustomerReprieveService customerReprieveService;
	
	/**
	 * ???????????????????
	 * @param lossId
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value="lossId")String lossId,HttpServletResponse response)throws Exception{
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("lossId", lossId);
		List<CustomerReprieve> customerReprieveList=customerReprieveService.findCustomerReprieve(map);
		JSONObject result=new JSONObject();
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.setExcludes(new String[]{"customerLoss"});
		JSONArray jsonArray=JSONArray.fromObject(customerReprieveList,jsonConfig);
		result.put("rows", jsonArray);
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * ??????????????
	 * @param customerReprieve
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String save(CustomerReprieve customerReprieve,HttpServletResponse response)throws Exception{
		int resultTotal=0; // ????????????
		if(customerReprieve.getId()==null){
			resultTotal=customerReprieveService.addCustomerReprieve(customerReprieve);
		}else{
			resultTotal=customerReprieveService.updateCustomerReprieve(customerReprieve);
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
	 * ???????????????
	 * @param id
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam(value="id")String id,HttpServletResponse response)throws Exception{
		customerReprieveService.deleteCustomerReprieve(Integer.parseInt(id));
		JSONObject result=new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
}
