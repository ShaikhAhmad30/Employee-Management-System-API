package com.example.ems.service;

import com.example.ems.dto.EmployeeRequestDTO;
import com.example.ems.dto.EmployeeResponseDTO;
import com.example.ems.entity.Employee;
import com.example.ems.exception.EmployeeNotFoundException;
import com.example.ems.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeResponseDTO convertToResponseDTO(Employee employee) {

        EmployeeResponseDTO response = new EmployeeResponseDTO();

        response.setId(employee.getId());
        response.setFirstName(employee.getFirstName());
        response.setLastName(employee.getLastName());
        response.setEmail(employee.getEmail());
        response.setDepartment(employee.getDepartment());
        response.setSalary(employee.getSalary());
        response.setPhoneNumber(employee.getPhoneNumber());
        response.setDesignation(employee.getDesignation());
        response.setJoiningDate(employee.getJoiningDate());
        response.setActive(employee.getActive());

        return response;
    }

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List<EmployeeResponseDTO> getAllEmployees()

    {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(this::convertToResponseDTO)
                .toList();
    }


    @Override
    public EmployeeResponseDTO addEmployee(EmployeeRequestDTO dto){

        Employee employee = new Employee();

        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setEmail(dto.getEmail());
        employee.setDepartment(dto.getDepartment());
        employee.setSalary(dto.getSalary());
        employee.setDesignation(dto.getDesignation());
        employee.setPhoneNumber(dto.getPhoneNumber());
        employee.setJoiningDate(dto.getJoiningDate());
        employee.setActive(dto.getActive());

        Employee savedEmployee = employeeRepository.save(employee);

        return convertToResponseDTO(savedEmployee);
    }

    @Override
    public EmployeeResponseDTO getEmployeeById(Long id) {
      Employee employee = employeeRepository.findById(id).orElseThrow(() ->
          new EmployeeNotFoundException(
                  "Employee is not found with  id: "+ id
          )
      );
      return convertToResponseDTO(employee);
    }


    @Override
    public EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO dto) {
        Employee existingEmployee = employeeRepository
                .findById(id)
                .orElseThrow(()->
                    new EmployeeNotFoundException(
                            "Employee not found with id "+id)
                );

        existingEmployee.setFirstName(dto.getFirstName());
        existingEmployee.setLastName(dto.getLastName());
        existingEmployee.setEmail(dto.getEmail());
        existingEmployee.setDepartment(dto.getDepartment());
        existingEmployee.setDesignation(dto.getDesignation());
        existingEmployee.setActive(dto.getActive());
        existingEmployee.setSalary(dto.getSalary());
        existingEmployee.setJoiningDate(dto.getJoiningDate());
        existingEmployee.setPhoneNumber(dto.getPhoneNumber());

        Employee updateEmployee = employeeRepository.save(existingEmployee);


        return convertToResponseDTO(updateEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee existingEmployee = employeeRepository
                .findById(id)
                .orElseThrow(()->
                        new EmployeeNotFoundException(
                                "Employee not found with id " +id
                        ));
        employeeRepository.deleteById(id);

    }
}
