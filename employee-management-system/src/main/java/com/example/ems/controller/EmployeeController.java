package com.example.ems.controller;


import com.example.ems.entity.Employee;
import com.example.ems.service.EmployeeService;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// @RequestMapping("/api/v1/employees/")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/api/v1/employees")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployees();
    }

    @PostMapping("/api/v1/employees")
    public Employee addEmployee(@Valid @RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/api/v1/employees/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
         return employeeService.getEmployeeById(id);
    }

    @PutMapping("/api/v1/employees/{id}")
    public Employee updateEmployee(
            @PathVariable Long id,
            @RequestBody Employee employee
    ){
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/api/v1/employees/{id}")
    public void deleteEmployee(@PathVariable Long id){
         employeeService.deleteEmployee(id);
    }
}
