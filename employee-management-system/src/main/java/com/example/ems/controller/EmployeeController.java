package com.example.ems.controller;


import com.example.ems.dto.EmployeeRequestDTO;
import com.example.ems.dto.EmployeeResponseDTO;
import com.example.ems.entity.Employee;
import com.example.ems.service.EmployeeService;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
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
    public List<EmployeeResponseDTO> getAllEmployee(){
        return employeeService.getAllEmployees();
    }

    @PostMapping("/api/v1/employees")
    public EmployeeResponseDTO addEmployee(@Valid @RequestBody EmployeeRequestDTO employeeRequestDTO){
        return employeeService.addEmployee(employeeRequestDTO);
    }

    @GetMapping("/api/v1/employees/{id}")
    public EmployeeResponseDTO getEmployeeById(@PathVariable Long id){
         return employeeService.getEmployeeById(id);
    }

    @PutMapping("/api/v1/employees/{id}")
    public EmployeeResponseDTO updateEmployee(
            @PathVariable Long id,
            @RequestBody EmployeeResponseDTO employeeRequestDTO
    ){
        return employeeService.updateEmployee(id, employeeRequestDTO);
    }

    @DeleteMapping("/api/v1/employees/{id}")
   public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted Successfully with id: "+ id);

    }
}
