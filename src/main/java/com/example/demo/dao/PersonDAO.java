package com.example.demo.dao;

import com.example.demo.dto.Person;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonDAO {
    private JdbcTemplate jdbcTemplate;

    public List<Person> index() {
        return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id) {
        return jdbcTemplate.query("select * from person where id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
    }

    public void save(Person person) {
        jdbcTemplate.update("insert into person(name,email) values(?,?)",person.getName(),person.getEmail());
    }

    public void update(Person person, int id) {
        jdbcTemplate.update("update person set name=?, email=? where id=?", person.getName(),person.getEmail(),id);
    }
    public void delete(int id){
        jdbcTemplate.update("delete from person where id=?",id);
    }
}

