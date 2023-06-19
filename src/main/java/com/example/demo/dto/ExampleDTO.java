package com.example.demo.dto;

import com.example.demo.anotation.PhoneNumberConstraint;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@AllArgsConstructor
@Data
@Setter
public class ExampleDTO {
    @Max(1000)
    private int id;
    @NotNull
    private String name;
    @PhoneNumberConstraint
    private String phone;
}
