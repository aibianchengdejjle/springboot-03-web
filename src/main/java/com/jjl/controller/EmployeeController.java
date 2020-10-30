package com.jjl.controller;

import com.jjl.dao.DepatmentDao;
import com.jjl.dao.EmployeeDao;
import com.jjl.pojo.Department;
import com.jjl.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.websocket.server.PathParam;
import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepatmentDao depatmentDao;
    @RequestMapping("/emps")
    public  String list(Model model){
        Collection<Employee> employees = employeeDao.selectAll();
        model.addAttribute("list",employees);
        return "/emp/list";
    }
    @RequestMapping("/emp")
    public String add(Model model){
        Collection<Department> departments = depatmentDao.get();
        System.out.println(departments);
        model.addAttribute("departments",departments);
        return "/emp/add";
    }
    @PostMapping("/toAdd")
    public  String toadd(Employee employee){
        //添加员工
        employee.setDepartment(depatmentDao.getDepatment(employee.getDepartment().getId()));
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:emps";
    }
    //Restful 风格
    @RequestMapping("/toUpdate/{id}")
    public String toupdate(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.selectID(id);
        model.addAttribute("update",employee);
        Collection<Department> departments = depatmentDao.get();
        model.addAttribute("departments",departments);
        return  "/emp/update";
    }
    //用于更新
    @RequestMapping("/update")
    public  String update(Employee employee,Model model){
        //调用更新操作
        employee.setDepartment(depatmentDao.getDepatment(employee.getDepartment().getId()));
        //employeeDao.delete(employee.getId());
        employeeDao.save(employee);
        Collection<Employee> employees = employeeDao.selectAll();
        model.addAttribute("list",employees);
        return "/emp/list";
    }
    //
    @RequestMapping("/toDelete/{id}")
    public String todelete(@PathVariable("id") int id,Model model){
        employeeDao.delete(id);
        Collection<Employee> employees = employeeDao.selectAll();
        model.addAttribute("list",employees);
        return "redirect:emps";
    }
    @RequestMapping("/toDelete/emps")
    public String  test(Model model){
        Collection<Employee> employees = employeeDao.selectAll();
        model.addAttribute("list",employees);
        return "redirect:emps";
    }
}
