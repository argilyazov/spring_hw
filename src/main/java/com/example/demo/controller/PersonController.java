package com.example.demo.controller;

import com.example.demo.dao.PersonDAO;
import com.example.demo.dto.Person;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
@AllArgsConstructor
@Validated
public class PersonController {
    private PersonDAO personDAO;
    @GetMapping()
    public List<Person> getPersons(){
        return personDAO.index();
    }
    @GetMapping("/{id}")
    public Person getPerson(@PathVariable int id){
        return personDAO.show(id);
    }
    @PostMapping
    public String postPerson(@ModelAttribute @Valid Person person){
        personDAO.save(person);
        return "Добавление выполнено успешно!";
    }
    @PatchMapping("/{id}")
    public String patchPerson(@ModelAttribute @Valid Person person, @PathVariable int id){
        personDAO.update(person,id);
        return "Обновление выполнено успешно!";
    }
    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable int id){
        personDAO.delete(id);
        return "Удаление выполнено успешно!";
    }
}
