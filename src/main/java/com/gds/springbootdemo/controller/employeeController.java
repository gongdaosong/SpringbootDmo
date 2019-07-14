package com.gds.springbootdemo.controller;

/**
 * @Author 龚道松
 * @Date 2019/7/14 11:07
 * @Version 1.0
 **/

import com.gds.springbootdemo.dao.DepartmentDao;
import com.gds.springbootdemo.dao.EmployeeDao;
import com.gds.springbootdemo.entities.Department;
import com.gds.springbootdemo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * 处理员工相关的请求
 */
@Controller
public class employeeController {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    // 查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model){

        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps", all);
        return "emp/list";
    }

    // 跳转添加员工页面
    @GetMapping("/emp")
    public String toAddPage(Model model){

        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    // 员工添加 , BindingResult bindingResult
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        employeeDao.save(employee);
        // 重定向到指定页面
        return "redirect:/emps";
    }

    // 来到修改页面 查询单签员工 在页面回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        // 查出部门，页面显示部门信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        // add是一个修改添加二合一的页面
        return "emp/add";
    }

    // 员工修改
    @PutMapping("/emp")
    public String updateEmp(Employee employee){

        System.out.println("员工修改:"+employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    // 删除员工
    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){

        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
