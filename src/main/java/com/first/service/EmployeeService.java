package com.first.service;

import com.first.exception.EmployeeException;
import com.first.model.Employee;
import com.first.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployee(){
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
       return employeeRepo.save(employee);
    }

    public void delteEmployee(Long id){
        employeeRepo.deleteById(id);
    }

    public Employee findEmployeebyId(Long id) {
        //this is a query method it s all abt naming convention
        return employeeRepo.findEmployeeById(id).orElseThrow(()->new EmployeeException("employee with id "+id+" is not found!"));
    }
}
