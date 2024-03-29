package com.sevcikondrej.controller;

import com.sevcikondrej.DAO.CustomerDAO;
import com.sevcikondrej.entity.Customer;
import com.sevcikondrej.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    //need to inject our customer service
    @Autowired
    private CustomerService customerService;

    @GetMapping("list")
    public String listCustomers(Model theModel){

        //get customers from the service
        List<Customer> theCustomers = customerService.getCustomers();

        //add the customers to the model
        theModel.addAttribute("customers",theCustomers);

        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){

        //create model attribute to bind data
        Customer theCustomer = new Customer();

        theModel.addAttribute("customer",theCustomer);
        return "customer-form";
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@ModelAttribute("customer") Customer theCustomer){

        //save the customer using service
        customerService.addCustomer(theCustomer);

        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel){
        //get customer from the database
        Customer theCustomer = customerService.getCustomer(theId);
        //add customer as a model attribute to pre-populate
        theModel.addAttribute("customer",theCustomer);

        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId){
        //delete the customer
        customerService.deleteCustomer(theId);

        return "redirect:/customer/list";
    }
    @GetMapping("/search")
    public String searchCustomers(@RequestParam("theSearchName") String theSearchName, Model theModel){

        //search for customers from the service
        List<Customer> theCustomers = customerService.searchCustomers(theSearchName);

        //add the customers to the model
        theModel.addAttribute("customers",theCustomers);

        return "list-customers";

    }


}
