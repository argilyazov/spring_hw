package com.example.demo.dto;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.EnableMBeanExport;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {
    private String name;
    @Pattern(regexp ="[a-zA-Z0-9]*@[a-zA-Z]*\\.[a-zA-z]*")
    private String email;
}
