package com.student.api.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
    private String email;

    @Column(unique = true)
    @NotBlank(message = "phone is mandatory")
    private String phone;

    @Min(0)
    @Max(4)
    private double cgpa;

    @Min(1900)
    private int year;
}
