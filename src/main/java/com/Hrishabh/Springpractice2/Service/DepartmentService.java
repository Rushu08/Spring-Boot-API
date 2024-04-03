package com.Hrishabh.Springpractice2.Service;

import com.Hrishabh.Springpractice2.Entity.Department;

import java.util.List;

public interface DepartmentService {


    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long departmentId);

    public void deleteDepartment(Long departmentId);

    public Department updateDepartment(long departmentId, Department department);

    public Department findDepartmentByName(String departmentName);
}
