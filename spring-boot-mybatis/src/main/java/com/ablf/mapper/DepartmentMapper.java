package com.ablf.mapper;

import com.ablf.bean.Department;
import org.apache.ibatis.annotations.*;

/**
 * Created by du on 2019/2/19.
 */
//@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    public Department getDeptById(Integer id);


    @Delete("delete from department where id=#{id}")
    public int deleteDepart(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(department_name) values(#{departmentName})")
    public int insertDept(Department department);

    @Update("update department set department_name=#{departmentName} where id=#{id}")
    public int updateDept(Department department);

}
