package com.sada.demos.cassandra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.QueryLogger;

@SpringBootApplication
@EnableCassandraRepositories(basePackages = { "com.sada.demos.cassandra.repository" })
public class DemoApplication {

	@Autowired
	Cluster cluster;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public QueryLogger queryLogger(Cluster cluster) {
	    QueryLogger queryLogger = QueryLogger.builder()
	            .build();
	    cluster.register(queryLogger);
	    return queryLogger;
	}
}

