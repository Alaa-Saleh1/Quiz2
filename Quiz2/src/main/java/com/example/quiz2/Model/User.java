package com.example.quiz2.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class User {
    @NotEmpty(message = "id cannot be empty")
    private String id;

    @NotEmpty(message = "name cannot be empty")
    private String name;

    @NotNull(message = "Age cannot be null ")
    @Positive
    private int age;

    @NotNull(message = "balance cannot be null")
    @Positive(message = "only positive number")
    private double balance;

    @NotEmpty(message = "role cannot be empty")
    @Pattern(regexp = "customer|libraian")
    private String role;

}
