package com.quest.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.quest.dao.DepartmentDao;
import com.quest.entity.Department;
import com.quest.service.DepartmentService;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

	@Resource
	private DepartmentDao departmentDao;
	@Override
	public Department findDepartmentByParentId(Integer parentId) {
		return departmentDao.selectByParentId(parentId);
	}

	@Override
	public Department findDepartmentById(Integer id) {
		return departmentDao.selectByPrimaryKey(id);
	}

}
