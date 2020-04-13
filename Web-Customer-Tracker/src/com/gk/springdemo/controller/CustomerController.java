package com.gk.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gk.dao.CustomerDao;
import com.gk.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// need to inject the dao in the controller
	@Autowired
	private CustomerDao customerDao;

	@RequestMapping("/list")
	public String listCUstomers(Model theModel) {
		// get customer from the dao
		List<Customer> theCustomers = customerDao.getCustomers();

		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);

		return "list-customer";
	}
}
