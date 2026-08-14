package com.example.ems.service;

import com.example.ems.dto.EmployeeRequestDTO;
import com.example.ems.dto.EmployeeResponseDTO;
import com.example.ems.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<EmployeeResponseDTO> getAllEmployees();

    EmployeeResponseDTO addEmployee(EmployeeRequestDTO employeeRequestDTO);

    EmployeeResponseDTO getEmployeeById(Long id);


    EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO dto);

    void deleteEmployee(Long id);


}
