package com.quest.service;

import com.quest.entity.Department;

public interface DepartmentService {
	Department findDepartmentByParentId(Integer parentId);
	
	Department findDepartmentById(Integer id);
	
}
