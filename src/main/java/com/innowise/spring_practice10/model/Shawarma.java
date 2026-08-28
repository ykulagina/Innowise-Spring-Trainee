package com.innowise.spring_practice10.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shawarma {
    @NotNull(message = "May not be null.")
    @Size(min = 3, message = "Must be at least 3 symbols.")
    private String name;
    @NotNull
    @Size(min = 1, message = "At leas one ingredient must be selected.")
    private List<Ingredient> ingredients;
}
