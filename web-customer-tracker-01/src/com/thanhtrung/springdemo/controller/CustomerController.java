package com.thanhtrung.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thanhtrung.springdemo.entity.Customer;
import com.thanhtrung.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	private String listCustomer(Model theModel) {
		
		// get customer 
		List<Customer> theCustomers = customerService.getCustomers();
		
		theModel.addAttribute("theCustomers", theCustomers);
		
		return "list-customer";
	}
	
	@GetMapping("/showFormForAdd")
	private String showFormForAdd(Model theModel) {
		
		Customer customer = new Customer();
		
		theModel.addAttribute("customer", customer);
		 
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	private String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	@GetMapping("/showFormForUpdate")
	private String showFormForUpdate(@RequestParam("customerId") int id, Model theModel) {
		
		// get the customer from the database
		Customer customer = customerService.getCustomer(id);
		//set customer
		theModel.addAttribute("customer", customer);
		//send form
		return "customer-form";
	}
	
	@GetMapping("/delete")
	private String deleteCustomer(@RequestParam("customerId") int id) {
		
		customerService.deleteCustomer(id);
		
		return "redirect:/customer/list";
	}
	
}
