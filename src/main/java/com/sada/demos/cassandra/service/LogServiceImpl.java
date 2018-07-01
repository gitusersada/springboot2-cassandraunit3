package com.sada.demos.cassandra.service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.cassandra.repository.MapId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.sada.demos.cassandra.controller.Log;
import com.sada.demos.cassandra.controller.LogMapper;
import com.sada.demos.cassandra.entities.LogEntityCass;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private CrudRepository<LogEntityCass, String> repository;

    @Autowired
    private LogMapper mapper;

    @Override
    public List<Log> findAll() {

        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(mapper)
                .collect(Collectors.toList());
    }

    @Override
    public Log findOne(String id) {

        /*return mapper.apply(
                repository.findOne(
                        id().with("id", id)
                )
        );*/
    	return findAll().stream().filter(l -> l.getId().equals(id)).findFirst().get();

    }
}
