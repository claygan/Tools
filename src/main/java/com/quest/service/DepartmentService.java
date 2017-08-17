package com.quest.service;

import com.quest.entity.Department;
import com.quest.entity.Pager;

public interface DepartmentService {
	Department findDepartmentByParentId(Integer parentId);
	
	Department findDepartmentById(Integer id);

	Pager<Department> queryDepartment(String deptName);
	
}
