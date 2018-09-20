package com.java1234.quartz;

import com.java1234.service.CustomerService;

/**
 * ?????????????????
 * @author Administrator
 *
 */
public class FindLossCustomerJob {

	private CustomerService customerService; // ???Service
	
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public void work() {  
		customerService.checkCustomerLoss();
    }  
}
