package com.gk.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gk.dao.CustomerDao;
import com.gk.entity.Customer;
import com.gk.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// need to inject the service in the controller
	@Autowired
	private CustomerService customerService;

	

	@GetMapping("/list")
	public String listCUstomers(Model theModel) {
		
		
		// get customer from the service
		List<Customer> theCustomers = customerService.getCustomers();

		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);

		return "list-customer";
	}
}
