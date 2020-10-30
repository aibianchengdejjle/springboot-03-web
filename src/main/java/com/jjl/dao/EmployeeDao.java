package com.jjl.dao;

import com.jjl.pojo.Department;
import com.jjl.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees=null;
    @Autowired
    private static DepatmentDao depatmentDao;
    static {
        employees=new HashMap<>();
        employees.put(1,new Employee(1,"ljj","11@qq.com",1,new Department(1,"教育部1")));
        employees.put(2,new Employee(2,"ljj2","22@qq.com",1,new Department(2,"教育部2")));
        employees.put(3,new Employee(3,"ljj3","33@qq.com",1,new Department(3,"教育部3")));

    }
    private static  Integer initid=3;
    //增加一个员工
    public static void save(Employee employee){
        //employee.setDepartment(depatmentDao.getDepatment(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }
    //查询全部员工
    public Collection<Employee> selectAll(){
        return employees.values();
    }
    //通过id查询员工
    public  Employee selectID(Integer id){
        return employees.get(id);
    }
    //删除员工
    public  void delete(Integer id){
        employees.remove(id);
    }

}
