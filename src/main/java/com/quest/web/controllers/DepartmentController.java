package com.quest.web.controllers;

import com.quest.entity.Department;
import com.quest.entity.Pager;
import com.quest.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Quest on 2017/7/27.
 */
@Controller
@RequestMapping("/depment")
public class DepartmentController extends BaseController{

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("list")
    public String queryList( Model model) {
        String deptName = request.getParameter("name");
        String pageNum = request.getParameter("pageNum");
        String pageSize = request.getParameter("pageSize");
        Pager<Department> departmentPager = departmentService.queryDepartment(deptName);
        model.addAttribute("list",departmentPager.getList());
        return "/dept/list";
    }
}
