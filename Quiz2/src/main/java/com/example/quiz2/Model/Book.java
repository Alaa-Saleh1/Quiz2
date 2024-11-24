package com.example.quiz2.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Book {

    @NotEmpty(message = "id cannot be empty")
    private String id;

    @NotEmpty(message = "name cannot be empty")
    private String name;

    @Positive
    @NotNull(message = "number of page cannot be null.")
    private int number_of_pages;

    @Positive
    @NotNull(message = "price cannot be null")
    private double price;

    @NotEmpty(message = "category cannot be empty")
    @Pattern(regexp = "novel|academic",message = "The category should be novel or academic just.")
    private String category;

    private boolean isAvailable = true;

}
