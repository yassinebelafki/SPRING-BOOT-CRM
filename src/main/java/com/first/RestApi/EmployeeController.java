package com.first.RestApi;


import com.first.model.Employee;
import com.first.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


@GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employeeList=employeeService.findAllEmployee();
        return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
    }

@PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
            employee.setId(0);
            Employee employee1= employeeService.addEmployee(employee);
            return new ResponseEntity<Employee>(employee1,HttpStatus.CREATED);
        }

 @GetMapping("/get/{id}")
 public ResponseEntity<Employee> findEmployee(@PathVariable("id") Long id){
    Employee employee=employeeService.findEmployeebyId(id);
    return new ResponseEntity<Employee>(employee,HttpStatus.OK);
 }

 @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
    Employee updateEmployee=employeeService.updateEmployee(employee);
    return new ResponseEntity<Employee>(updateEmployee,HttpStatus.OK);
 }

 @DeleteMapping("/delete/{id}")
 public void updateEmployee(@PathVariable Long id){
     employeeService.delteEmployee(id);
 }

}
