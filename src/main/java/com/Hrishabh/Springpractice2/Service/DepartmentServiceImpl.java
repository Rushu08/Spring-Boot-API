package com.Hrishabh.Springpractice2.Service;

import com.Hrishabh.Springpractice2.Entity.Department;
import com.Hrishabh.Springpractice2.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService  {
    @Autowired
    public DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).get() ;
    }

    @Override
    public void deleteDepartment(Long departmentId) {
         departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(long departmentId, Department department) {
        Department depBD= departmentRepository.findById(departmentId).get();
        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
            depBD.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){
            depBD.setDepartmentAddress(department.getDepartmentAddress());
        }
        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
            depBD.setDepartmentCode(department.getDepartmentCode());
        }
        return departmentRepository.save(depBD);
    }


    @Override
    public Department findDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }
}
