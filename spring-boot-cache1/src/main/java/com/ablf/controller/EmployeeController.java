package com.ablf.controller;

import com.ablf.entity.Employee;
import com.ablf.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by du on 2019/2/21.
 */
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmpById(@PathVariable("id") Integer id){

        return employeeService.getEmpById(id);

    }

    @GetMapping("/emp")
    public Employee updateEmp(Employee employee){

        return employeeService.updateEmp(employee);

    }


    @GetMapping("/delemp/{id}")
    public String delEmp(@PathVariable("id") Integer id){

        employeeService.deleteEmp(id);
        return "SUCCESS";

    }

    @GetMapping("/emp/name/{lastName}")
    public Employee getEmpByName(@PathVariable("lastName") String lastName){
        Employee emp = employeeService.getEmpByLastName(lastName);
        return emp;
    }

    @GetMapping("/emp/nameCach/{lastName}")
    public Employee getEmpByNameFromCache(@PathVariable("lastName") String lastName){
        Employee emp = employeeService.getEmpByLastNameFromCache(lastName);
        return emp;
    }

}
