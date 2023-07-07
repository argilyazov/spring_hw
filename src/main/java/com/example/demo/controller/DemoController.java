package com.example.demo.controller;

import com.example.demo.config.ExampleConfig;
import com.example.demo.dto.ConfigProperties;
import com.example.demo.dto.ExampleDTO;
import com.example.demo.service.ExampleService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@Validated
public class DemoController {

    private ExampleService service;
    private String param;
    private ConfigProperties properties;

    public DemoController(@Value("${example.value}") String param, ExampleService service, @Qualifier("configurateProperties") ConfigProperties properties) {
        this.service = service;
        this.param = param;
        this.properties =properties;
    }

    @GetMapping("object/{param}")
    public ExampleDTO getName(@PathVariable @Max(100) int param, @RequestParam @NotNull String name, @RequestBody @Valid ExampleDTO arsel) {
        return service.renameExample(arsel, param, name);
    }

    @GetMapping("param")
    public String getParam() {
        return this.param + " " + properties.getHost() + ":" + properties.getPort();
    }
}
