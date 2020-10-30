package com.jjl.dao;

import com.jjl.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepatmentDao {
    //模拟数据库数据
    private static Map<Integer, Department>departmentMap=null;
    static {
        departmentMap=new HashMap<>();
        departmentMap.put(101,new Department(101,"教育部1"));
        departmentMap.put(102,new Department(102,"教育部2"));
        departmentMap.put(103,new Department(103,"教育部3"));
        departmentMap.put(104,new Department(104,"教育部4"));
        departmentMap.put(105,new Department(105,"教育部5"));

    }
    //获得所有信息
    public Collection<Department> get(){
        return  departmentMap.values();
    }
    //通过id得到部门
    public  Department getDepatment(Integer id){
        return departmentMap.get(id);
    }
}
