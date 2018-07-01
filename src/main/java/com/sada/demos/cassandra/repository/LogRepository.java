package com.sada.demos.cassandra.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.sada.demos.cassandra.entities.LogEntityCass;

public interface LogRepository extends CassandraRepository<LogEntityCass,String> {
}