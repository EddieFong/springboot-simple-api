package com.tw.apistackbase.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Created by jxzhong on 18/08/2017.
 */
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final Logger log = Logger.getLogger(this.getClass().getName());
    List<Employee> employees = new ArrayList<>();
    @GetMapping(path = "", produces = {"application/json"})
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(employees);
    }

    @GetMapping(path = "/init", produces = {"application/json"})
    public ResponseEntity<List<Employee>> initAll() {

        this.employees = new ArrayList<Employee>(java.util.Arrays.asList(new Employee("A","A",1,'A'),new Employee("B","B",2,'B')));
        return ResponseEntity.ok(employees);
    }


    @PostMapping(produces = {"application/json"})
    public ResponseEntity<String> add(@RequestBody Employee employee) {
        this.employees.add(new Employee(employee.getId(),employee.getName(),employee.getAge(),employee.getGender()));
        return ResponseEntity.ok("Success");
    }

    @GetMapping(path = "/del/{id}", produces = {"application/json"})
    public ResponseEntity<String> delById(@PathVariable String id) {
        this.employees.stream().filter(employee -> employee.getId() != id).collect(Collectors.toList());
        return ResponseEntity.ok("Deleted");
    }
}
