package com.example.ems.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@JsonPropertyOrder({"id","firstName","lastName","email","department","salary","phoneNumber","designation","joiningDate","active"})
public class EmployeeResponseDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String department;
    private double salary;
    private String phoneNumber;
    private String designation;
    private LocalDate joiningDate;
    private Boolean active;
}
