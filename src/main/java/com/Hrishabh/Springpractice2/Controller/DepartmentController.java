package com.Hrishabh.Springpractice2.Controller;

import com.Hrishabh.Springpractice2.Entity.Department;
import com.Hrishabh.Springpractice2.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    public DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentLsit(){
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId){
        return departmentService.fetchDepartmentById(departmentId);
    }
    @DeleteMapping("/departments/{id}")
    public String deleteDepartment(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartment(departmentId);
        return "department deleted suceessfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") long departmentId,
                                       @RequestBody Department department){
        return departmentService.updateDepartment(departmentId,department);
    }

    @GetMapping("departments/name/{name}")
    public Department findDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.findDepartmentByName(departmentName);
    }

}
