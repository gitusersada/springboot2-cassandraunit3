package com.sada.demos.cassandra.controller;

import org.springframework.stereotype.Component;

import com.sada.demos.cassandra.entities.LogEntityCass;

import java.util.function.Function;

@Component
public class LogMapper implements Function<LogEntityCass, Log> {

    @Override
    public Log apply(LogEntityCass logEntityCass) {
        if (logEntityCass == null) {
            return null;
        }

        Log log = new Log();

        log.setId(logEntityCass.getId());
        log.setQuery(logEntityCass.getQuery());
        log.setDate(logEntityCass.getDate());

        return log;
    }
}
