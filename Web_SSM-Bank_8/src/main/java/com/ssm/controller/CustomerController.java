package com.ssm.controller;

import com.ssm.controller.validation.ValidGroupByCustomer;
import com.ssm.pojo.Customer;
import com.ssm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@SessionAttributes({"customer","custObjectErrors"})
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("regist")
    public @ResponseBody
    Customer regist(@Validated(ValidGroupByCustomer.class)Customer customer, BindingResult bindingResult, Model model){
        //进行校验
        if (bindingResult.hasErrors()){
            List<ObjectError> objectErrors = bindingResult.getAllErrors();
            model.addAttribute("custObjectErrors",objectErrors);
        }
        //效验通过后进行主体操作
        Customer newCustomer = null;

        try {
            newCustomer = customerService.inserCustomer(customer);
            model.addAttribute("customer",newCustomer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newCustomer;
    }

    @RequestMapping("login")
    public @ResponseBody
    Customer login(Customer customer, Model model){
        Customer newCustomer = null;
        try {
            newCustomer = customerService.findCustomerByPid(customer);
            model.addAttribute("customer",newCustomer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newCustomer;
    }

    @RequestMapping("update")
    public @ResponseBody
    Customer update(@Validated(ValidGroupByCustomer.class)Customer customer, BindingResult bindingResult,Model model){
        //进行校验
        if (bindingResult.hasErrors()){
            List<ObjectError> objectErrors = bindingResult.getAllErrors();
            model.addAttribute("custObjectErrors",objectErrors);
        }
        //效验通过后进行主体操作
        Customer newCustomer = null;
        try {
            newCustomer = customerService.updateCustomer(customer);
            model.addAttribute("customer",newCustomer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newCustomer;
    }

    @RequestMapping("logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }
}
