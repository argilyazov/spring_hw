package com.example.demo.controller;

import com.example.demo.dto.ExampleDTO;
import com.example.demo.service.ExampleService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@Validated
public class DemoController {
    private ExampleService service;
    @GetMapping("hello/{param}")
    public ExampleDTO getName(@PathVariable @Max(100) int param, @RequestParam @NotNull String name, @RequestBody @Valid ExampleDTO arsel) {
        return service.renameExample(arsel,param,name);
    }
}
