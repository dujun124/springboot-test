package com.ablf.service;

import com.ablf.entity.Department;
import com.ablf.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by du on 2019/2/22.
 */
@Service
public class DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;


    @Cacheable(value = "dept", key = "#id", cacheManager = "deptRedisCacheManager")
    public Department getDeptById(Integer id){
        Department department = departmentMapper.getDeptById(id);
        return department;
    }

}
