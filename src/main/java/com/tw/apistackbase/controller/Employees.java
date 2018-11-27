package com.tw.apistackbase.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * Created by jxzhong on 18/08/2017.
 */
@RestController
@RequestMapping("/employees")
public class Employees {

    private final Logger log = Logger.getLogger(this.getClass().getName());

    @GetMapping(path = "", produces = {"application/json"})
    public ResponseEntity<String> getAll() {
        String result = " [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"Xiaoming\",\n" +
                "      \"age\": 20,\n" +
                "      \"gender\": \"Male\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 1,\n" +
                "      \"name\": \"Xiaohong\",\n" +
                "      \"age\": 19,\n" +
                "      \"gender\": \"Female\"  \n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 2,\n" +
                "      \"name\": \"Xiaozhi\",\n" +
                "      \"age\": 15,\n" +
                "      \"gender\": \"Male\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 3,\n" +
                "      \"name\": \"Xiaogang\",\n" +
                "      \"age\": 16,\n" +
                "      \"gender\": \"Male\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 4,\n" +
                "      \"name\": \"Xiaoxia\",\n" +
                "      \"age\": 15,\n" +
                "      \"gender\": \"Female\"\n" +
                "    }\n" +
                "  ]";
        return ResponseEntity.ok(result);
    }


}
