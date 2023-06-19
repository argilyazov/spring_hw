package com.example.demo.service.impl;

import com.example.demo.dto.ExampleDTO;
import com.example.demo.exception.ExampleException;
import com.example.demo.service.ExampleService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;


@Service
public class ExampleServiceImpl implements ExampleService {
    @Override
    public ExampleDTO renameExample( ExampleDTO example,  int id,  String name) {
        example.setId(id);
        example.setName(name);
        return example;
    }
}
