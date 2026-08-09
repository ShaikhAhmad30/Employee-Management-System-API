package com.example.ems.service;

import com.example.ems.entity.Employee;
import com.example.ems.exception.EmployeeNotFoundException;
import com.example.ems.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }


    @Override
    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);

    }

    @Override
    public Employee getEmployeeById(Long id) {
       return employeeRepository.findById(id).orElseThrow(() ->
               new EmployeeNotFoundException(
                       "Employee not found with id: "+ id
               ));
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee existingEmployee = employeeRepository
                .findById(id)
                .orElseThrow(()->
                    new EmployeeNotFoundException(
                            "Employee not found with id "+id)
                );

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setDesignation(employee.getDesignation());
        existingEmployee.setActive(employee.getActive());
        existingEmployee.setSalary(employee.getSalary());
        existingEmployee.setJoiningDate(employee.getJoiningDate());
        existingEmployee.setPhoneNumber(employee.getPhoneNumber());

        return employeeRepository.save(existingEmployee);
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
