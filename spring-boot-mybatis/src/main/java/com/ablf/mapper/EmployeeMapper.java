package com.ablf.mapper;

import com.ablf.bean.Employee;

/**
 * Created by du on 2019/2/19.
 */
//需要使用@Mapper或@MapperScan装配到Spring容器中
public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);


}
