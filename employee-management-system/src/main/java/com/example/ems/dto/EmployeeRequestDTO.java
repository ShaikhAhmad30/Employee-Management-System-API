package com.example.ems.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class EmployeeRequestDTO {
    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotBlank(message = "email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Department is required")
    private String department;

    @NotNull(message = "Salary is required")
    @Positive(message = "Salary must be greater than 0")
    private double salary;

    @NotNull(message = "Phone number is required")
    @Pattern(
            regexp = "^[0-9]{10}$",
            message = "Phone number must be contains exactly 10 digits"
    )
    private String phoneNumber;

    private String designation;


    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate joiningDate;

    @NotNull(message = "Active status is required")
    private Boolean active;
}
