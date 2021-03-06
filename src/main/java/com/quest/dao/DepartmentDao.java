package com.quest.dao;

import com.quest.entity.Department;

import java.util.List;

public interface DepartmentDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);
    
    Department selectByParentId(Integer parentId);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    List<Department> selectByDeptName(String deptName);
}