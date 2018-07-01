package com.sada.demos.cassandra;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@SpringBootApplication
@EnableCassandraRepositories(basePackages = { "com.sada.demos.cassandra.repository" })
public class DemoApplication {

}

