package com.example.ems.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"id","firstName","lastName","email","department","salary","phoneNumber","designation","joiningDate","active"})
public class Employee {

    public Employee(String firstName,
                    String lastName,
                    String email,
                    String department,
                    double salary,
                    String phoneNumber,
                    String designation,
                    LocalDate joiningDate,
                    Boolean active) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.department = department;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.designation = designation;
        this.joiningDate = joiningDate;
        this.active = active;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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
