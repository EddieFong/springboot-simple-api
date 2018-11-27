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

        this.employees = new ArrayList<Employee>(java.util.Arrays.asList(new Employee("1","Name1",1,"Male"),new Employee("2","Name2",2,"Female")));
        return ResponseEntity.ok(employees);
    }


    @PostMapping(produces = {"application/json"})
    public ResponseEntity<String> add(@RequestBody Employee employee) {
        this.employees.add(new Employee(employee.getId(),employee.getName(),employee.getAge(),employee.getGender()));
        return ResponseEntity.ok("Success");
    }

    @GetMapping(path = "/del/{id}", produces = {"application/json"})
    public ResponseEntity<String> delById(@PathVariable String id) {
        String result = "";
        for (Employee employee : employees) {
            if (employee.getId().contentEquals(id)) {
                employees.remove(employee);
                result += employee.getName() + " is deleted. ";
            }
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.ok("Not found");
    }

    @PostMapping(path = "/update/{id}", produces = {"application/json"})
    public ResponseEntity<String> updateById(@PathVariable String id, @RequestBody Employee newEmployee) {
        String result = "";
        for (Employee employee : employees) {
            if (employee.getId().contentEquals(id)) {
                employee.setName(newEmployee.getName());
                employee.setAge(newEmployee.getAge());
                employee.setGender(newEmployee.getGender());

                result += employee.getName() + " is updated. ";
            }
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.ok("Not found");

    }
}
