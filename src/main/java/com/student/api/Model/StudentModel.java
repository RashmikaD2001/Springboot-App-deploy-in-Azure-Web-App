package com.student.api.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "First name is mandatory")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    private String lastName;

    @Column(unique = true)
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    @Column(unique = true)
    @NotBlank(message = "phone is mandatory")
    @Size(min=10, max = 10)
    private String phone;

    @DecimalMin(value = "0.0", inclusive = true, message = "cgpa must be >= 0.0")
    @DecimalMax(value = "4.0", inclusive = true, message = "cgpa must be <= 4.0")
    private double cgpa;

    @Min(value = 1, message = "year must be at least 1")
    @Max(value = 4, message = "year must be at most 4")
    private int year;
}
