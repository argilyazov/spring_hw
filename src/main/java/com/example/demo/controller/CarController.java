package com.example.demo.controller;

import com.example.demo.entity.Car;
import com.example.demo.repository.CarRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarRepo carRepo;
    @GetMapping
    public Iterable<Car> getCars(){
        return carRepo.findAll();
    }
    @PostMapping
    public String postCar(@ModelAttribute Car car){
        carRepo.save(car);
        return "Добавлено";
    }
}
