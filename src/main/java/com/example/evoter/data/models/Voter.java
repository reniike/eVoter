package com.example.evoter.data.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Voters")
@AllArgsConstructor
@NoArgsConstructor
public class Voter {
    @Id
    private String id;
    @NotBlank(message = "First name is mandatory")
    private String firstName;
    @NotBlank(message = "Last name is mandatory")
    private String lastName;
    @Email
    @NotBlank(message = "Email address is mandatory")
    private String emailAddress;
    @NotBlank(message = "Age is mandatory")
    private int age;
    @NotBlank(message = "Password is mandatory")
    private String password;
}
