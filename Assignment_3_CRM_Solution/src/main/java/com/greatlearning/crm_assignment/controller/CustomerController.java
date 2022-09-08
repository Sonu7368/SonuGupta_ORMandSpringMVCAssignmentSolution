package com.greatlearning.crm_assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.crm_assignment.entity.Customer;
import com.greatlearning.crm_assignment.service.CustomerService;

@Controller
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		List<Customer> customers = customerService.getCustomerList();
		model.addAttribute("customers", customers);

		return "customer-list";
	}

	@GetMapping("/add")
	public String add(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		
		return "customer-form";
	}

	@GetMapping("/update")
	public String update(@RequestParam("id") int id, Model model) {
		Customer customer = customerService.getCustomer(id);
		model.addAttribute("customer", customer);
		
		return "customer-form";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("customer") Customer customer) {
		customerService.save(customer);
		
		return "redirect:/customer/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		customerService.delete(id);
		
		return "redirect:/customer/list";
	}

}
