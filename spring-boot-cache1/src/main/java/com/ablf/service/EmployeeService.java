package com.ablf.service;

import com.ablf.entity.Employee;
import com.ablf.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.*;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by du on 2019/2/21.
 */
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Qualifier("empRedisCacheManager")
    @Autowired
    RedisCacheManager empRedisCacheManager;

    /**
     * Cacheable:放缓存
     *      先查询缓存中有没有
     *          没有,去查数据库
     *          有,返回缓存中的内容
     *
     * cacheNames:缓存名称
     *          key:缓存的键,可自定义
     * @param id
     * @return
     */
    /*//key = "'{'+#root.args[0]+'}'"
    @Cacheable(cacheNames = {"emp"}*//*, keyGenerator = "myKeyGenerator", condition = "#id==1"*//*)
    public Employee getEmpById(Integer id){

        return employeeMapper.getEmpById(id);
    }*/

    public Employee getEmpById(Integer id){
        Employee emp = employeeMapper.getEmpById(id);

        empRedisCacheManager.getCache("emp").put("emp@"+id,emp);
        return emp;
    }

    /**
     * CachePut:先执行方法,再更新缓存  (标注CachePut的方法是一定会执行的,不管有没有缓存)
     *
     *      注意key是否是查询时的缓存,需要一致
     * @param employee
     * @return
     */
    @CachePut(value = "emp", key = "#result.id")
    public Employee updateEmp(Employee employee){

        employeeMapper.updateEmp(employee);
        return employee;

    }


    /**
     * CacheEvict: 清除缓存
     *
     *      beforeInvocation: 方法执行之前清除缓存,默认是false
     * @param id
     */
    @CacheEvict(value = "emp" ,beforeInvocation = true)
    public void deleteEmp(Integer id){
        System.out.println("执行了deleteEmp方法...............");
        int i=1/0;
    }

    @Caching(
            cacheable = {
                    @Cacheable(value = "emp",key = "#lastName")
            },
            put = {
                    @CachePut(value = "emp",key = "#result.id"),
                    @CachePut(value = "emp",key = "#result.email")
            }
    )
    public Employee getEmpByLastName(String lastName){
        return employeeMapper.getEmpByLastName(lastName);

    }

    @Cacheable(value = "emp",key = "#lastName")
    public Employee getEmpByLastNameFromCache(String lastName){
        return employeeMapper.getEmpByLastName(lastName);

    }

}
