package com.ablf.controller;

import com.ablf.bean.Department;
import com.ablf.bean.Employee;
import com.ablf.mapper.DepartmentMapper;
import com.ablf.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by du on 2019/2/19.
 */
@RestController
public class DeptController {

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping("/dept")
    public Department insertDept(Department department){

        departmentMapper.insertDept(department);

        return department;
    }

    @GetMapping("/dept/{id}")
    public Department getDeptById(@PathVariable("id") Integer id){

        Department dept = departmentMapper.getDeptById(id);
        return dept;
    }


    @GetMapping("/dept/{id}/{deptName}")
    public Department updateDept(@PathVariable("id") Integer id,@PathVariable("deptName") String deptName){

        Department department = new Department();
        department.setId(id);
        department.setDepartmentName(deptName);
        departmentMapper.updateDept(department);
        return department;
    }

    @GetMapping("/emp/{id}")
    public Employee getEmpById(@PathVariable("id") Integer id){
        return employeeMapper.getEmpById(id);
    }


}
