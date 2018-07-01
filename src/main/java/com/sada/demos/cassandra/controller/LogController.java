package com.sada.demos.cassandra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sada.demos.cassandra.service.LogService;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogController {

    @Autowired
    LogService service;

    @RequestMapping("/{id}")
    public ResponseEntity<Log> findOne(@PathVariable("id") String id) {
        return new ResponseEntity<>(
                service.findOne(id), HttpStatus.OK
        );
    }
    
    @RequestMapping("/getAll")
    public ResponseEntity<List<Log>> getAll() {
        return new ResponseEntity<>(
                service.findAll(), HttpStatus.OK
        );
    }
}
