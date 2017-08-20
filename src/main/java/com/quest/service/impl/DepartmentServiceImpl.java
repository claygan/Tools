package com.quest.service.impl;

import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import com.quest.entity.Pager;
import com.quest.entity.PaginationContext;
import org.springframework.stereotype.Service;

import com.quest.dao.DepartmentDao;
import com.quest.entity.Department;
import com.quest.service.DepartmentService;

import java.util.List;

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

	@Override
	public Pager<Department> queryDepartment(String deptName) {
		PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
		List<Department> list =  departmentDao.selectByDeptName(deptName);
		return new Pager<Department>(list);
	}

}
