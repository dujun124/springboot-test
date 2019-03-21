package com.ablf.mapper;

import com.ablf.entity.Employee;
import org.apache.ibatis.annotations.*;

/**
 * Created by du on 2019/2/21.
 */
@Mapper
public interface EmployeeMapper {


    @Select("select * from employee where id=#{id}")
    public Employee getEmpById(Integer id);

    @Update("update employee set lastName=#{lastName},email=#{email},gender=#{gender} where id=#{id}")
    public void updateEmp(Employee employee);

    @Delete("DELETE from employee WHERE id=#{id}")
    public void deleteEmp(Integer id);

    @Insert("insert into employee(lastName,email,gender) values(#{lastName},#{email},#{gender})")
    public void insertEmp(Employee employee);

    @Select("select * from employee where lastName=#{lastName}")
    public Employee getEmpByLastName(String lastName);
}
