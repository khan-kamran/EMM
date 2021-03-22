package com.example.EMM.controller;

import com.example.EMM.dto.EmployeeDto;
import com.example.EMM.entity.City;
import com.example.EMM.entity.Employee;
import com.example.EMM.entity.OfficeAddress;
import com.example.EMM.entity.User;
import com.example.EMM.service.EMMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class EmmController {
    @Autowired
    EMMService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }
    @GetMapping(path = "/login")
    public ModelAndView getLoginPage(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }
    @PostMapping(path = "/operations")
    public ModelAndView verify(@ModelAttribute("user") User user) {
        ModelAndView mv = new ModelAndView();
        if ("admin".equals(user.getUsername())&& "admin".equals(user.getPassword())) {
            mv.setViewName("userHome");
            System.out.println("Authenticated ...");
        } else {
            mv.setViewName("login");
            mv.addObject("msg","Wrong username and password");
            //mv.addObject("str", "Wrong username and password");
            System.out.println("Wrong username and password");
        }
        return mv;
    }
    @GetMapping(path = "/dashboard")
    public ModelAndView getDashboard() {
        ModelAndView modelAndView = new ModelAndView();
        Integer totalCount = service.getTotalEmployeeCount();
        Integer enableCount = service.getEnableCount();
        Integer disableCount = totalCount-enableCount;
        modelAndView.addObject("count",totalCount);
        modelAndView.addObject("enable",enableCount);
        modelAndView.addObject("disable",disableCount);
        modelAndView.setViewName("dashboard");
        return modelAndView;
    }
    @PostMapping(path = "/register")
    public ModelAndView register(@ModelAttribute("employee") EmployeeDto employee) {
        ModelAndView modelAndView = new ModelAndView();
        Employee saved = service.save(employee);
        if(saved != null){
            List<EmployeeDto> employeeDtoList = service.getAllEmployeesData();
            modelAndView.addObject("employeeDtoList",employeeDtoList);
            modelAndView.setViewName("employeeList");
        }else{
            modelAndView.setViewName("registration");
        }
        return modelAndView;
    }
    @GetMapping(path = "/registration")
    public ModelAndView getRegisterPage(@ModelAttribute("employee") EmployeeDto employee) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("employeeRegistration");
        List<City> cityList = service.getCities();;
        modelAndView.addObject("clist",cityList);
        return modelAndView;
    }
    @GetMapping(path = "/employeeList")
    public ModelAndView getEmployeeListPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("employeeList");
        List<EmployeeDto> employeeDtoList = service.getAllEmployeesData();
        modelAndView.addObject("employeeDtoList",employeeDtoList);
        return modelAndView;
    }
    @GetMapping(path = "/changeStatus/{id}")
    public ModelAndView changeStatus(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        Employee changed = service.changeStatus(id);
        modelAndView.setViewName("employeeList");
        List<EmployeeDto> employeeDtoList = service.getAllEmployeesData();
        modelAndView.addObject("employeeDtoList",employeeDtoList);
        return modelAndView;
    }
    @GetMapping(path = "/getDepartmentAddress")
    public ResponseEntity<List<String>> getDepartmentAddress(@RequestParam("dname") String dname){
        List<OfficeAddress> officeAddressList = service.getDepartmentAddress(dname);
        if(!officeAddressList.isEmpty()) {
            List<String> addresslist = officeAddressList.stream().map(OfficeAddress::getOfficeAddress).collect(Collectors.toList());
            return new ResponseEntity<>(addresslist, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(path = "/backToUserHome")
    public ModelAndView backToUSerHome(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userHome");
        return modelAndView;
    }
}
