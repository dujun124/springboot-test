package com.ablf.controller;

import com.ablf.entity.Department;
import com.ablf.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by du on 2019/2/22.
 */
@RestController
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;


    @GetMapping("/dept/{id}")
    public Department getDeptById(@PathVariable("id") Integer id){
        return departmentService.getDeptById(id);
    }

}
